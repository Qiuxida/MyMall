package com.star.mall.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Http工具类
 * @author Sam
 * @since 2021-04-15
 */
@Component
public class IPUtil {
    public static final String IP_ADDRESS = "ipAddress";

    private static RedisTemplate redisTemplate;
    //静态变量通过set方法进行注入
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        IPUtil.redisTemplate = redisTemplate;
    }

    /**
     * 获取请求的ip地址
     * @param request
     * @return 请求的ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1") || ip.equals("")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        return ip;
    }

    /**
     * 获取ip所属区域的地理位置
     * @param request
     * @return
     */
    public static Map<String, String> getIpPosition(HttpServletRequest request) {
        String ip = getIpAddress(request);
        return getIpPosition(ip);
    }

    /**
     * 根据Ip获取ip所属区域的地理位置
     * @param ip
     * @return
     */
    public static Map<String, String> getIpPosition(String ip) {
        if (StringUtil.isEmpty(ip)) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put("ip", ip);
        //省份
        String position = (String)redisTemplate.opsForHash().get(IP_ADDRESS, ip);

        if(!StringUtil.isEmpty(position)){
            map.put("position", position);
            return map;
        }

        // 126 ip API
        String path = "http://ip.ws.126.net/ipquery?ip=" + ip;

        HttpClient httpClient = new HttpClient();
        // 设置超时时间
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        httpClient.getHttpConnectionManager().getParams().setSoTimeout(5000);
        // get请求
        GetMethod getMethod = new GetMethod(path);

        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != 200) {
                return map;
            }
            // 获取返回内容
            // 读取内容
            String str = getMethod.getResponseBodyAsString();
            // 处理内容
            // 获取数据内容
            str = str.substring(str.lastIndexOf("=") + 1, str.length());

            JSONObject jo = JSON.parseObject(str);
            position = jo.getString("province") + jo.getString("city");
            map.put("position", position);
            map.put("ip", ip);
            //存入redis中
            redisTemplate.opsForHash().put(IP_ADDRESS, ip, position);

            return map;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}

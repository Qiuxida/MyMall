package com.star.mall.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
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

    private static RedisTemplate<String,String> redisTemplate;

    private static RestTemplate restTemplate;

    //静态变量通过set方法进行注入
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        IPUtil.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        IPUtil.restTemplate = restTemplate;
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
        if (StringUtils.isEmpty(ip)) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put("ip", ip);
        //省份
        String position = (String) redisTemplate.opsForHash().get(IP_ADDRESS, ip);

        if(!StringUtils.isEmpty(position)){
            map.put("position", position);
            return map;
        }

        // 126 ip API
        String path = "http://ip.ws.126.net/ipquery?ip=" + ip;

        // 获取返回内容
        // 读取内容
        String response = restTemplate.getForObject(path, String.class);
        // 处理内容
        // 获取数据内容
        response = response.substring(response.lastIndexOf("=") + 1, response.length());

        JSONObject jo = JSONUtil.parseObj(response);
        position = jo.getStr("province") + jo.getStr("city");
        map.put("position", position);
        map.put("ip", ip);
        //存入redis中
        redisTemplate.opsForHash().put(IP_ADDRESS, ip, position);
        return map;
    }
}

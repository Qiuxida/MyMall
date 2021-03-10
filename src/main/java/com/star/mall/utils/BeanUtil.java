package com.star.mall.utils;

/**
 * 对象工具类
 * @author StarQ
 * @since 2021-2-20
 */
public class BeanUtil {

    /**
     * 驼峰转蛇形
     * @param humpString
     * @return
     */
    public static String toLineString(String humpString) {
        StringBuilder sb = new StringBuilder(humpString);
        int temp = 0;
        for(int i = 0 ;i < humpString.length(); i++){
            if(Character.isUpperCase(humpString.charAt(i))){
                sb.insert(i+temp,"_");
                temp+=1;
            }
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 蛇形转驼峰
     * @param lineString
     * @return
     */
    public static String toHumpString(String lineString) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = lineString.split("_");
        for (String string2 : str) {
            if(stringBuilder.length()==0){
                stringBuilder.append(string2);
            }else {
                stringBuilder.append(string2.substring(0, 1).toUpperCase());

                stringBuilder.append(string2.substring(1));

            }
        }
        return stringBuilder.toString();
    }

}

package com.star.mall.utils;

import com.star.mall.annotations.ConvertProperty;
import com.star.mall.base.model.TreeNode;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author qiuxd
 */
public class BeanUtil {

    public final static <T,E> E convert(T t, Class<E> returnClass) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<>();
        Arrays.stream(declaredFields).forEach(item -> {
            ConvertProperty property = item.getAnnotation(ConvertProperty.class);
            item.setAccessible(true);
            if (Objects.nonNull(property)) {
                try {
                    map.put(property.field(), item.get(t));
                    System.out.println(item.get(t));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            E value = returnClass.newInstance();
            Field[] declaredFields1 = returnClass.getDeclaredFields();
            for (int i=0; i<declaredFields1.length;i++) {
                Field field = declaredFields1[i];
                field.setAccessible(true);
                field.set(value, map.get(field));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String getMethodName(String name) {
        String firstChar = name.substring(0,1);
        StringBuffer nameBuffer = new StringBuffer(name);
        nameBuffer.replace(0,1,firstChar.toUpperCase());
        StringBuffer buffer = new StringBuffer("get");
        buffer.append(nameBuffer);
        return buffer.toString();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.setId("2");
        node.setName("2");
        node.setParentId("2");
        TreeNode node1 = convert(node, TreeNode.class);
    }
}

package com.star.mall.utils;

import com.star.mall.annotations.ConvertProperty;
import com.star.mall.base.model.TreeNode;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author qiuxd
 */
public class BeanUtil {

    public final static <T,E> E convert(T t, Class<E> returnClass) {
        Field[] declaredFields = t.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<>(10);
        Arrays.stream(declaredFields).forEach(item -> {
            ConvertProperty property = item.getAnnotation(ConvertProperty.class);
            if (Objects.nonNull(property)) {
                item.setAccessible(true);
                try {
                    map.put(property.field(), item.get(t));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        E value = null;
        try {
            value = returnClass.newInstance();
            Field[] declaredFields1 = returnClass.getDeclaredFields();
            for (int i=0; i<declaredFields1.length;i++) {
                Field field = declaredFields1[i];
                field.setAccessible(true);
                field.set(value, map.get(field.getName()));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.setId("2");
        node.setName("2");
        node.setParentId("2");
        node.setInteger(1);
        TreeNode node1 = convert(node, TreeNode.class);
        System.out.println(node1);
    }
}

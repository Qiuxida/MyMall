package com.star.mall.utils;

import com.star.mall.base.model.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 树形工具类
 * @author StarQ
 * @since 2021-2-20
 */
public class TreeUtil {

    public final static <T extends Tree> List<T> listToTree(List<T> list) {
        List<T> treeList = new ArrayList<>();
        if (list.size()==0){
            return treeList;
        }

        Map<String, Tree> treeMap = list.stream()
                .collect(Collectors.toMap(item -> item.getId(),item -> item));

        list.forEach(item -> {
            if (treeMap.containsKey(item.getPid()) && !item.isHead()) {
                if (treeMap.get(item.getPid()).getChildren() == null){
                    treeMap.get(item.getPid()).setChildren(new ArrayList<>());
                }
                treeMap.get(item.getPid()).getChildren().add(item);
            }else {
                treeList.add(item);
            }
        });

        return treeList;
    }

}

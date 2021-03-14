package com.star.mall.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 根据用户分配角色参数
 */
@Data
@EqualsAndHashCode
public class UserRoleParam {

    /**
     * 添加id
     */
    private List<String> addIds;

    /**
     * 删除id
     */
    private List<String> deleteIds;
}

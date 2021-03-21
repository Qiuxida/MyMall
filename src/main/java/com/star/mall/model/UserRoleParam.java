package com.star.mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 根据用户分配角色参数
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "分配角色参数")
public class UserRoleParam {

    /**
     * 添加id
     */
    @ApiModelProperty(value = "添加角色ID数组")
    private List<String> addIds;

    /**
     * 删除id
     */
    @ApiModelProperty(value = "删除角色ID数组")
    private List<String> deleteIds;
}

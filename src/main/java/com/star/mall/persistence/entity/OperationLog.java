package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 操作日志 
 * </p>
 *
 * @author StarQ
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_operation_log")
@ApiModel(value = "操作日志")
public class OperationLog extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 请求地址
     */
    @TableField("URL_")
    @ApiModelProperty(value = "请求地址")
    private String url;

    /**
     * 请求类型
     */
    @TableField("TYPE_")
    @ApiModelProperty(value = "请求类型")
    private String type;

    /**
     * 请求内容
     */
    @TableField("REQUEST_")
    @ApiModelProperty(value = "请求内容")
    private String request;

    /**
     * 响应内容
     */
    @TableField("RESPONSE_")
    @ApiModelProperty(value = "响应内容")
    private String response;

    /**
     * 详细
     */
    @TableField("NOTE_")
    @ApiModelProperty(value = "详细")
    private String note;

    /**
     * IP地址
     */
    @TableField("IP_")
    @ApiModelProperty(value = "IP地址")
    private String ip;

}

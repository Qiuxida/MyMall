package com.star.mall.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.star.mall.base.model.BaseModel;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class OperationLog extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID_")
    private String id;

    /**
     * 请求地址
     */
    @TableField("URL_")
    private String url;

    /**
     * 请求类型
     */
    @TableField("TYPE_")
    private String type;

    /**
     * 请求内容
     */
    @TableField("REQUEST_")
    private String request;

    /**
     * 响应内容
     */
    @TableField("RESPONSE_")
    private String response;

    /**
     * 详细
     */
    @TableField("NOTE_")
    private String note;

    /**
     * IP地址
     */
    @TableField("IP_")
    private String ip;

}

package com.star.mall.base;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class BaseModel {

    @TableField("create_time_")
    private Date createTime;
    @TableField("update_time_")
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

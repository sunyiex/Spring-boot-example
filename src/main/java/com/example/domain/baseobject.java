package com.example.domain;

import java.util.Date;

/**
 * Created by SunYi on 2016/2/1/0001.
 * 基础类，包含创建时间和id
 */
public class baseobject {
    private int id;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

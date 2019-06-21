package com.hand.variable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author panbailiang
 * @version 1.0
 * @description:请假实体类,注意，需要实现序列化接口
 * @date 2019/6/15 14:50
 */
public class Holiday implements Serializable {

    private static final long serialVersionUID = 8396667767265822844L;
    //主键
    private String id;
    //请假人姓名
    private String name;
    //请假理由
    private String reason;
    //请假天数 硬编码 就不去计算了
    private String day;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

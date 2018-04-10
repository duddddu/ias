package com.ias.admin.device.pojo;

import com.ias.admin.eduAdmin.pojo.ClassroomPO;

import java.io.Serializable;
import java.util.Date;

public class DevicePO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String number;

    private String state;

    private Integer classroomId;

    private Date lastStartTime;

    private String type;

    private String ip;

    private ClassroomPO classroomPO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Date getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(Date lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ClassroomPO getClassroomPO() {
        return classroomPO;
    }

    public void setClassroomPO(ClassroomPO classroomPO) {
        this.classroomPO = classroomPO;
    }
}

package com.ias.admin.system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class BackUpPO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer backuperId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date backupTime;

    private AdminPO backuper;

    public Date getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(Date backupTime) {
        this.backupTime = backupTime;
    }

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

    public Integer getBackuperId() {
        return backuperId;
    }

    public void setBackuperId(Integer backuperId) {
        this.backuperId = backuperId;
    }


    public AdminPO getBackuper() {
        return backuper;
    }

    public void setBackuper(AdminPO backuper) {
        this.backuper = backuper;
    }

    @Override
    public String toString(){
        return "Backup{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", backuperId=" + backuperId + '\'' +
                ", backupTime=" + backupTime +
                "}";
    }
}

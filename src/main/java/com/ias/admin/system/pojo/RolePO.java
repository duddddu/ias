package com.ias.admin.system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dududu
 * @email 345912664@qq.com
 * @date 2018-03-22
 */
public class RolePO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer type;

    private String note;

    private Integer sort;

    private Integer display;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString(){
        return "RolePO{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", type=" + type + '\'' +
                ", note=" + note + '\'' +
                ", sort=" + sort + '\'' +
                ", display=" + display + '\'' +
                ", createTime=" + createTime + '\'' +
                '}';
    }
}

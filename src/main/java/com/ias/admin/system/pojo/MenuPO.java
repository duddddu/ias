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
public class MenuPO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //父类id
    private Integer parentId;
    //名称
    private String name;
    //图标
    private String icon;
    //url
    private String url;
    // 授权(多个用逗号分隔，如：user:list,user:create)
    private String perms;
    //显示
    private Integer display;
    //类型
    private Integer type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //排序
    private Integer sort;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 设置：授权(多个用逗号分隔，如：user:list,user:create)
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }

    /**
     * 获取：授权(多个用逗号分隔，如：user:list,user:create)
     */
    public String getPerms() {
        return perms;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    @Override
    public String toString(){
        return "Menu{" +
                "id=" + id + '\'' +
                ", parentId=" + parentId + '\'' +
                ", name=" + name + '\'' +
                ", icon=" + icon + '\'' +
                ", url=" + url + '\'' +
                ", type=" + type + '\'' +
                ", perms=" + perms + '\'' +
                ", createTime=" + createTime + '\'' +
                ", display=" + display +
                '}';
    }
}
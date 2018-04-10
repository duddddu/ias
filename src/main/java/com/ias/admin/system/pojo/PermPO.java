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
public class PermPO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //角色id
    private Integer roleId;
    //菜单id
    private Integer menuId;
    //排序
    private String sort;
    //显示
    private Integer display;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private RolePO rolePO;

    private MenuPO menuPO;

    public RolePO getRolePO() {
        return rolePO;
    }

    public void setRolePO(RolePO rolePO) {
        this.rolePO = rolePO;
    }

    public MenuPO getMenuPO() {
        return menuPO;
    }

    public void setMenuPO(MenuPO menuPO) {
        this.menuPO = menuPO;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    @Override
    public String toString(){
        return "Perm{" +
                "id=" + id + '\'' +
                ", roleId=" + roleId + '\'' +
                ", menuId=" + menuId + '\'' +
                ", sort=" + sort + '\'' +
                ", display="+ display + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

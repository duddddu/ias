package com.ias.admin.system.pojo;

import java.io.Serializable;

/**
 *
 * @author dududu
 * @email 345912664@qq.com
 * @date 2018-03-27
 */
public class AdminPO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String username;

    private String password;

    private Integer roleId;

    private String post;

    private RolePO role;

    public RolePO getRole() {
        return role;
    }

    public void setRole(RolePO role) {
        this.role = role;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString(){
        return "AdminPO{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", username=" + username +  '\'' +
                ", password=" + password +  '\'' +
                ", post=" + post +  '\'' +
                '}';
    }
}


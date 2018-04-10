package com.ias.admin.common.pojo;

import com.ias.admin.eduAdmin.pojo.DepartmentPO;

import java.io.Serializable;

public class TeacherPO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //人脸
    private String face;
    //院系id
    private Integer departmentId;
    //工号
    private String employeeNumber;
    //密码
    private String password;
    //职务
    private Integer post;

    private DepartmentPO departmentPO;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public DepartmentPO getDepartmentPO() {
        return departmentPO;
    }

    public void setDepartmentPO(DepartmentPO departmentPO) {
        this.departmentPO = departmentPO;
    }

    @Override
    public String toString(){
        return "TeacherPO{" +
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", sex=" + sex + '\'' +
                ", age=" + age + '\'' +
                ", face=" + face + '\'' +
                ", departmentId=" + departmentId + '\'' +
                ", employeeNumber=" + employeeNumber + '\'' +
                ", password=" + password + '\'' +
                ", post=" + post +
                '}';
    }
}

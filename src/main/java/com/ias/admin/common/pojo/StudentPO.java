package com.ias.admin.common.pojo;

import com.ias.admin.eduAdmin.pojo.ClassPO;

import java.io.Serializable;
import java.util.Date;

public class StudentPO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //入学年份
    private Date emrollmentYear;
    //班级id
    private Integer classId;
    //人脸
    private String face;
    //学号
    private String studentNumber;
    //密码
    private String password;

    private ClassPO classPO;

    public ClassPO getClassPO() {
        return classPO;
    }

    public void setClassPO(ClassPO classPO) {
        this.classPO = classPO;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getEmrollmentYear() {
        return emrollmentYear;
    }

    public void setEmrollmentYear(Date emrollmentYear) {
        this.emrollmentYear = emrollmentYear;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "StudentPO{" +
                "id=" + id +
                ", name=" + name +
                ", sex=" + sex +
                ", enrollmentYear=" + emrollmentYear +
                ", classId=" + classId +
                ", face=" + face +
                ", studentNumber=" + studentNumber +
                ", password=" + password +
                "}";
    }
}

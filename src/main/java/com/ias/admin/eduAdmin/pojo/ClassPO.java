package com.ias.admin.eduAdmin.pojo;

import com.ias.admin.common.pojo.TeacherPO;

import java.io.Serializable;
import java.util.Date;



/**
 * 班级表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class ClassPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//名称
	private String name;
	//院系id
	private Integer departmentId;
	//辅导员id
	private Integer teacherId;

	private DepartmentPO departmentPO;

	private TeacherPO teacherPO;

	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}

	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
	}

	public TeacherPO getTeacherPO() {
		return teacherPO;
	}

	public void setTeacherPO(TeacherPO teacherPO) {
		this.teacherPO = teacherPO;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：院系id
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：院系id
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}
	/**
	 * 设置：辅导员id
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：辅导员id
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
}

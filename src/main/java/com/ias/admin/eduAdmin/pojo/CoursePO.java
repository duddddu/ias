package com.ias.admin.eduAdmin.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 课程表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class CoursePO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//名称
	private String name;
	//
	private Integer departmentId;

	private DepartmentPO departmentPO;

	public DepartmentPO getDepartmentPO() {
		return departmentPO;
	}

	public void setDepartmentPO(DepartmentPO departmentPO) {
		this.departmentPO = departmentPO;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
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
	 * 设置：
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}
}

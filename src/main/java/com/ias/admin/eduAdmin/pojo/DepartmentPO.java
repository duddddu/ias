package com.ias.admin.eduAdmin.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 院系表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class DepartmentPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//名称
	private String name;

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
}

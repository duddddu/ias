package com.ias.admin.eduAdmin.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 学年表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 09:48:51
 */
public class StuYearPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//名称
	private String name;

	/**
	 * 设置：序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：序号
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

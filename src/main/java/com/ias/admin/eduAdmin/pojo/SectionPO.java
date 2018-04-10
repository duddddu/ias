package com.ias.admin.eduAdmin.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 节次表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class SectionPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//名称
	private String name;
	//开始时间
	private Date beginTime;
	//结束时间
	private Date endTime;

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
	 * 设置：开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
}

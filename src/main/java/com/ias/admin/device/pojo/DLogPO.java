package com.ias.admin.device.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 设备日志表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 15:55:40
 */
public class DLogPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer id;
	//设备编号
	private String number;
	//名称
	private String name;
	//ip地址
	private String ip;
	//事件
	private String operations;
	//操作时间
	private Date operationTime;

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
	 * 设置：设备编号
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：设备编号
	 */
	public String getNumber() {
		return number;
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
	 * 设置：ip地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：ip地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：事件
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}
	/**
	 * 获取：事件
	 */
	public String getOperations() {
		return operations;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getOperationTime() {
		return operationTime;
	}
}

package com.ias.admin.eduAdmin.pojo;

import java.io.Serializable;
import java.util.Date;



/**
 * 学生课表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class StuCoursePO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//排课id
	private Integer arrCourseId;
	//学生id
	private Integer studentId;
	//考勤， 1 正常/-1 迟到/0 旷课/ -2 早退/-3 请假
	private Integer attend;
	//请假理由
	private String reason;
	//请假佐证
	private String material;
	//审批 1 同意/0 不同意
	private String approval;

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
	 * 设置：排课id
	 */
	public void setArrCourseId(Integer arrCourseId) {
		this.arrCourseId = arrCourseId;
	}
	/**
	 * 获取：排课id
	 */
	public Integer getArrCourseId() {
		return arrCourseId;
	}
	/**
	 * 设置：学生id
	 */
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学生id
	 */
	public Integer getStudentId() {
		return studentId;
	}
	/**
	 * 设置：考勤， 1 正常/-1 迟到/0 旷课/ -2 早退/-3 请假
	 */
	public void setAttend(Integer attend) {
		this.attend = attend;
	}
	/**
	 * 获取：考勤， 1 正常/-1 迟到/0 旷课/ -2 早退/-3 请假
	 */
	public Integer getAttend() {
		return attend;
	}
	/**
	 * 设置：请假理由
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * 获取：请假理由
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * 设置：请假佐证
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * 获取：请假佐证
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * 设置：审批 1 同意/0 不同意
	 */
	public void setApproval(String approval) {
		this.approval = approval;
	}
	/**
	 * 获取：审批 1 同意/0 不同意
	 */
	public String getApproval() {
		return approval;
	}
}

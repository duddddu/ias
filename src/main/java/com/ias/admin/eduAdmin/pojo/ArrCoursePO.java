package com.ias.admin.eduAdmin.pojo;

import com.ias.admin.common.pojo.TeacherPO;

import java.io.Serializable;
import java.util.Date;



/**
 * 排课表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public class ArrCoursePO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//学期id
	private Integer termId;
	//课程id
	private Integer courseId;
	//周次id
	private Integer weekId;
	//星期id
	private Integer dayId;
	//节次id
	private Integer sectionId;
	//教师id
	private Integer teacherId;
	//教室id
	private Integer classroomId;
	//考勤， 1 正常/-1 迟到/0 旷课/ -2 早退/-3 请假
	private Integer attend;


	private TermPO termPO;

	private CoursePO coursePO;

	private WeekPO weekPO;

	private DayPO dayPO;

	private SectionPO sectionPO;

	private TeacherPO teacherPO;

	private ClassroomPO classroomPO;

	public TermPO getTermPO() {
		return termPO;
	}

	public void setTermPO(TermPO termPO) {
		this.termPO = termPO;
	}

	public CoursePO getCoursePO() {
		return coursePO;
	}

	public void setCoursePO(CoursePO coursePO) {
		this.coursePO = coursePO;
	}

	public WeekPO getWeekPO() {
		return weekPO;
	}

	public void setWeekPO(WeekPO weekPO) {
		this.weekPO = weekPO;
	}

	public DayPO getDayPO() {
		return dayPO;
	}

	public void setDayPO(DayPO dayPO) {
		this.dayPO = dayPO;
	}

	public SectionPO getSectionPO() {
		return sectionPO;
	}

	public void setSectionPO(SectionPO sectionPO) {
		this.sectionPO = sectionPO;
	}

	public TeacherPO getTeacherPO() {
		return teacherPO;
	}

	public void setTeacherPO(TeacherPO teacherPO) {
		this.teacherPO = teacherPO;
	}

	public ClassroomPO getClassroomPO() {
		return classroomPO;
	}

	public void setClassroomPO(ClassroomPO classroomPO) {
		this.classroomPO = classroomPO;
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
	 * 设置：学期id
	 */
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	/**
	 * 获取：学期id
	 */
	public Integer getTermId() {
		return termId;
	}
	/**
	 * 设置：课程id
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：周次id
	 */
	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}
	/**
	 * 获取：周次id
	 */
	public Integer getWeekId() {
		return weekId;
	}
	/**
	 * 设置：星期id
	 */
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	/**
	 * 获取：星期id
	 */
	public Integer getDayId() {
		return dayId;
	}
	/**
	 * 设置：节次id
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * 获取：节次id
	 */
	public Integer getSectionId() {
		return sectionId;
	}
	/**
	 * 设置：教师id
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教师id
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：教室id
	 */
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	/**
	 * 获取：教室id
	 */
	public Integer getClassroomId() {
		return classroomId;
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
}

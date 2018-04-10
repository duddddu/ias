package com.ias.admin.eduAdmin.service.Impl;

import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.common.service.TeacherService;
import com.ias.admin.eduAdmin.pojo.*;
import com.ias.admin.eduAdmin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.ArrCourseMapper;


@Service
public class ArrCourseServiceImpl implements ArrCourseService {
	@Autowired
	private ArrCourseMapper arrCourseMapper;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private DayService dayService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TermService termService;
	@Autowired
	private WeekService weekService;
	@Autowired
	private SectionService sectionService;
	
	
	@Override
	public ArrCoursePO get(Integer id){
		ArrCoursePO arrCoursePO = arrCourseMapper.get(id);
		setForeignKeyObject(arrCoursePO);
		return arrCoursePO;
	}
	
	@Override
	public List<ArrCoursePO> list(Map<String, Object> map){
		List<ArrCoursePO> list = arrCourseMapper.list(map);
		setForeignKeyObject(list);
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return arrCourseMapper.count(map);
	}
	
	@Override
	public int save(ArrCoursePO arrCourse){
		return arrCourseMapper.save(arrCourse);
	}
	
	@Override
	public int update(ArrCoursePO arrCourse){
		return arrCourseMapper.update(arrCourse);
	}
	
	@Override
	public int remove(Integer id){
		return arrCourseMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return arrCourseMapper.batchRemove(ids);
	}

	public void setForeignKeyObject(List<ArrCoursePO> arrCoursePOs){
		for(ArrCoursePO arrCoursePO : arrCoursePOs){
			setForeignKeyObject(arrCoursePO);
		}
	}

	public void setForeignKeyObject(ArrCoursePO arrCoursePO){
		SectionPO sectionPO = sectionService.get(arrCoursePO.getSectionId());
		ClassroomPO classroomPO = classroomService.get(arrCoursePO.getClassroomId());
		CoursePO coursePO = courseService.get(arrCoursePO.getCourseId());
		DayPO dayPO = dayService.get(arrCoursePO.getDayId());
		TeacherPO teacherPO = teacherService.get(arrCoursePO.getTeacherId());
		TermPO termPO = termService.get(arrCoursePO.getTermId());
		WeekPO weekPO = weekService.get(arrCoursePO.getWeekId());
		arrCoursePO.setSectionPO(sectionPO);
		arrCoursePO.setClassroomPO(classroomPO);
		arrCoursePO.setCoursePO(coursePO);
		arrCoursePO.setDayPO(dayPO);
		arrCoursePO.setTeacherPO(teacherPO);
		arrCoursePO.setTermPO(termPO);
		arrCoursePO.setWeekPO(weekPO);
	}
}

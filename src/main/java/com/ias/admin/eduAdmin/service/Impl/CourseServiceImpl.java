package com.ias.admin.eduAdmin.service.Impl;

import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.CourseMapper;
import com.ias.admin.eduAdmin.pojo.CoursePO;
import com.ias.admin.eduAdmin.service.CourseService;



@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private DepartmentService departmentService;

	@Override
	public CoursePO get(Integer id){
		CoursePO coursePO = courseMapper.get(id);
		setForeignKeyObject(coursePO);
		return coursePO;
	}
	
	@Override
	public List<CoursePO> list(Map<String, Object> map){
		List<CoursePO> coursePOs = courseMapper.list(map);
		setForeignKeyObject(coursePOs);
		return coursePOs;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseMapper.count(map);
	}
	
	@Override
	public int save(CoursePO course){
		return courseMapper.save(course);
	}
	
	@Override
	public int update(CoursePO course){
		return courseMapper.update(course);
	}
	
	@Override
	public int remove(Integer id){
		return courseMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return courseMapper.batchRemove(ids);
	}

	public void setForeignKeyObject(List<CoursePO> coursePOs){
		for(CoursePO coursePO : coursePOs){
			setForeignKeyObject(coursePO);
		}
	}

	public void setForeignKeyObject(CoursePO coursePO){
		DepartmentPO departmentPO = departmentService.get(coursePO.getDepartmentId());
		coursePO.setDepartmentPO(departmentPO);
	}
}

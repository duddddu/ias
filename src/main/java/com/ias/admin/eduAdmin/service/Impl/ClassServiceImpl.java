package com.ias.admin.eduAdmin.service.Impl;

import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.common.service.TeacherService;
import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.ClassMapper;
import com.ias.admin.eduAdmin.pojo.ClassPO;
import com.ias.admin.eduAdmin.service.ClassService;



@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private ClassMapper classMapper;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private TeacherService teacherService;
	
	@Override
	public ClassPO get(Integer id){
		ClassPO classPO = classMapper.get(id);
		setForeignKeyObject(classPO);
		return classPO;
	}
	
	@Override
	public List<ClassPO> list(Map<String, Object> map){
		List<ClassPO> list = classMapper.list(map);
		setForeignKeyObject(list);
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return classMapper.count(map);
	}
	
	@Override
	public int save(ClassPO classPO){
		return classMapper.save(classPO);
	}
	
	@Override
	public int update(ClassPO classPO){
		return classMapper.update(classPO);
	}
	
	@Override
	public int remove(Integer id){
		return classMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return classMapper.batchRemove(ids);
	}

	public void setForeignKeyObject(List<ClassPO> classPOs){
		for(ClassPO classPO : classPOs){
			setForeignKeyObject(classPO);
		}
	}

	public void setForeignKeyObject(ClassPO classPO){
		DepartmentPO departmentPO = departmentService.get(classPO.getDepartmentId());
		TeacherPO teacherPO = teacherService.get(classPO.getTeacherId());
		classPO.setTeacherPO(teacherPO);
		classPO.setDepartmentPO(departmentPO);
	}
}

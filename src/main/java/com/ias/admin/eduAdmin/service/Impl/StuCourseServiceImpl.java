package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.StuCourseMapper;
import com.ias.admin.eduAdmin.pojo.StuCoursePO;
import com.ias.admin.eduAdmin.service.StuCourseService;



@Service
public class StuCourseServiceImpl implements StuCourseService {
	@Autowired
	private StuCourseMapper stuCourseMapper;
	
	@Override
	public StuCoursePO get(Integer id){
		return stuCourseMapper.get(id);
	}
	
	@Override
	public List<StuCoursePO> list(Map<String, Object> map){
		return stuCourseMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stuCourseMapper.count(map);
	}
	
	@Override
	public int save(StuCoursePO stuCourse){
		return stuCourseMapper.save(stuCourse);
	}
	
	@Override
	public int update(StuCoursePO stuCourse){
		return stuCourseMapper.update(stuCourse);
	}
	
	@Override
	public int remove(Integer id){
		return stuCourseMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return stuCourseMapper.batchRemove(ids);
	}
	
}

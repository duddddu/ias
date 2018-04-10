package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.ClassroomMapper;
import com.ias.admin.eduAdmin.pojo.ClassroomPO;
import com.ias.admin.eduAdmin.service.ClassroomService;



@Service
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomMapper classroomMapper;
	
	@Override
	public ClassroomPO get(Integer id){
		return classroomMapper.get(id);
	}
	
	@Override
	public List<ClassroomPO> list(Map<String, Object> map){
		return classroomMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return classroomMapper.count(map);
	}
	
	@Override
	public int save(ClassroomPO classroom){
		return classroomMapper.save(classroom);
	}
	
	@Override
	public int update(ClassroomPO classroom){
		return classroomMapper.update(classroom);
	}
	
	@Override
	public int remove(Integer id){
		return classroomMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return classroomMapper.batchRemove(ids);
	}
	
}

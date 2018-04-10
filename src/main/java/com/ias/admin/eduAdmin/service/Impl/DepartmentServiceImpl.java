package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.DepartmentMapper;
import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;



@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public DepartmentPO get(Integer id){
		return departmentMapper.get(id);
	}
	
	@Override
	public List<DepartmentPO> list(Map<String, Object> map){
		return departmentMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return departmentMapper.count(map);
	}
	
	@Override
	public int save(DepartmentPO department){
		return departmentMapper.save(department);
	}
	
	@Override
	public int update(DepartmentPO department){
		return departmentMapper.update(department);
	}
	
	@Override
	public int remove(Integer id){
		return departmentMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return departmentMapper.batchRemove(ids);
	}
	
}

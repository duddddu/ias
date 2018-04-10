package com.ias.admin.eduAdmin.service.Impl;

import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.MajorMapper;
import com.ias.admin.eduAdmin.pojo.MajorPO;
import com.ias.admin.eduAdmin.service.MajorService;



@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorMapper majorMapper;
	@Autowired
	private DepartmentService departmentService;
	
	@Override
	public MajorPO get(Integer id){
		MajorPO major = majorMapper.get(id);
		setForeignKeyObject(major);
		return major;
	}
	
	@Override
	public List<MajorPO> list(Map<String, Object> map){
		List<MajorPO> list = majorMapper.list(map);
		setForeignKeyObject(list);
		return list;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return majorMapper.count(map);
	}
	
	@Override
	public int save(MajorPO major){
		return majorMapper.save(major);
	}
	
	@Override
	public int update(MajorPO major){
		return majorMapper.update(major);
	}
	
	@Override
	public int remove(Integer id){
		return majorMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return majorMapper.batchRemove(ids);
	}

	public void setForeignKeyObject(List<MajorPO> majorPOs){
		for(MajorPO majorPO : majorPOs){
			setForeignKeyObject(majorPO);
		}
	}

	public void setForeignKeyObject(MajorPO majorPO){
		DepartmentPO departmentPO = departmentService.get(majorPO.getDepartmentId());
		majorPO.setDepartmentPO(departmentPO);
	}
}

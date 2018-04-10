package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.DayMapper;
import com.ias.admin.eduAdmin.pojo.DayPO;
import com.ias.admin.eduAdmin.service.DayService;



@Service
public class DayServiceImpl implements DayService {
	@Autowired
	private DayMapper dayMapper;
	
	@Override
	public DayPO get(Integer id){
		return dayMapper.get(id);
	}
	
	@Override
	public List<DayPO> list(Map<String, Object> map){
		return dayMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dayMapper.count(map);
	}
	
	@Override
	public int save(DayPO day){
		return dayMapper.save(day);
	}
	
	@Override
	public int update(DayPO day){
		return dayMapper.update(day);
	}
	
	@Override
	public int remove(Integer id){
		return dayMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return dayMapper.batchRemove(ids);
	}
	
}

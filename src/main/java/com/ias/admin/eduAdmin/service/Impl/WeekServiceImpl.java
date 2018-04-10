package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.WeekMapper;
import com.ias.admin.eduAdmin.pojo.WeekPO;
import com.ias.admin.eduAdmin.service.WeekService;



@Service
public class WeekServiceImpl implements WeekService {
	@Autowired
	private WeekMapper weekMapper;
	
	@Override
	public WeekPO get(Integer id){
		return weekMapper.get(id);
	}
	
	@Override
	public List<WeekPO> list(Map<String, Object> map){
		return weekMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weekMapper.count(map);
	}
	
	@Override
	public int save(WeekPO week){
		return weekMapper.save(week);
	}
	
	@Override
	public int update(WeekPO week){
		return weekMapper.update(week);
	}
	
	@Override
	public int remove(Integer id){
		return weekMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return weekMapper.batchRemove(ids);
	}
	
}

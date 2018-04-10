package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.StuYearMapper;
import com.ias.admin.eduAdmin.pojo.StuYearPO;
import com.ias.admin.eduAdmin.service.StuYearService;



@Service
public class StuYearServiceImpl implements StuYearService {
	@Autowired
	private StuYearMapper stuYearMapper;
	
	@Override
	public StuYearPO get(Integer id){
		return stuYearMapper.get(id);
	}
	
	@Override
	public List<StuYearPO> list(Map<String, Object> map){
		return stuYearMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return stuYearMapper.count(map);
	}
	
	@Override
	public int save(StuYearPO stuYear){
		return stuYearMapper.save(stuYear);
	}
	
	@Override
	public int update(StuYearPO stuYear){
		return stuYearMapper.update(stuYear);
	}
	
	@Override
	public int remove(Integer id){
		return stuYearMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return stuYearMapper.batchRemove(ids);
	}
	
}

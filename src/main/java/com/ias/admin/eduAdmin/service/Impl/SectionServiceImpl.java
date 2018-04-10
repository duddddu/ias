package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.SectionMapper;
import com.ias.admin.eduAdmin.pojo.SectionPO;
import com.ias.admin.eduAdmin.service.SectionService;



@Service
public class SectionServiceImpl implements SectionService {
	@Autowired
	private SectionMapper sectionMapper;
	
	@Override
	public SectionPO get(Integer id){
		return sectionMapper.get(id);
	}
	
	@Override
	public List<SectionPO> list(Map<String, Object> map){
		return sectionMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sectionMapper.count(map);
	}
	
	@Override
	public int save(SectionPO section){
		return sectionMapper.save(section);
	}
	
	@Override
	public int update(SectionPO section){
		return sectionMapper.update(section);
	}
	
	@Override
	public int remove(Integer id){
		return sectionMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return sectionMapper.batchRemove(ids);
	}
	
}

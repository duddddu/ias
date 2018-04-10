package com.ias.admin.eduAdmin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.eduAdmin.mapper.TermMapper;
import com.ias.admin.eduAdmin.pojo.TermPO;
import com.ias.admin.eduAdmin.service.TermService;



@Service
public class TermServiceImpl implements TermService {
	@Autowired
	private TermMapper termMapper;
	
	@Override
	public TermPO get(Integer id){
		return termMapper.get(id);
	}
	
	@Override
	public List<TermPO> list(Map<String, Object> map){
		return termMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return termMapper.count(map);
	}
	
	@Override
	public int save(TermPO term){
		return termMapper.save(term);
	}
	
	@Override
	public int update(TermPO term){
		return termMapper.update(term);
	}
	
	@Override
	public int remove(Integer id){
		return termMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return termMapper.batchRemove(ids);
	}
	
}

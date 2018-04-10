package com.ias.admin.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ias.admin.device.mapper.DLogMapper;
import com.ias.admin.device.pojo.DLogPO;
import com.ias.admin.device.service.DLogService;



@Service
public class DLogServiceImpl implements DLogService {
	@Autowired
	private DLogMapper dlogMapper;
	
	@Override
	public DLogPO get(Integer id){
		return dlogMapper.get(id);
	}
	
	@Override
	public List<DLogPO> list(Map<String, Object> map){
		return dlogMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dlogMapper.count(map);
	}
	
	@Override
	public int save(DLogPO log){
		return dlogMapper.save(log);
	}
	
	@Override
	public int update(DLogPO log){
		return dlogMapper.update(log);
	}
	
	@Override
	public int remove(Integer id){
		return dlogMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return dlogMapper.batchRemove(ids);
	}
	
}

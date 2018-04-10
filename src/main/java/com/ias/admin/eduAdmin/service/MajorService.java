package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.MajorPO;

import java.util.List;
import java.util.Map;

/**
 * 专业表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public interface MajorService {
	
	MajorPO get(Integer id);
	
	List<MajorPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MajorPO major);
	
	int update(MajorPO major);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

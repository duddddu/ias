package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.TermPO;

import java.util.List;
import java.util.Map;

/**
 * 学期表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 21:59:37
 */
public interface TermService {
	
	TermPO get(Integer id);
	
	List<TermPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TermPO term);
	
	int update(TermPO term);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

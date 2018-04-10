package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.DayPO;

import java.util.List;
import java.util.Map;

/**
 * 星期表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public interface DayService {
	
	DayPO get(Integer id);
	
	List<DayPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DayPO day);
	
	int update(DayPO day);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

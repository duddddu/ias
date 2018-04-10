package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.WeekPO;

import java.util.List;
import java.util.Map;

/**
 * 周次表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public interface WeekService {
	
	WeekPO get(Integer id);
	
	List<WeekPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WeekPO week);
	
	int update(WeekPO week);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

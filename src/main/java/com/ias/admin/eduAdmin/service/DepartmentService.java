package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.DepartmentPO;

import java.util.List;
import java.util.Map;

/**
 * 院系表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public interface DepartmentService {
	
	DepartmentPO get(Integer id);
	
	List<DepartmentPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DepartmentPO department);
	
	int update(DepartmentPO department);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

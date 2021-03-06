package com.ias.admin.eduAdmin.service;

import com.ias.admin.eduAdmin.pojo.ArrCoursePO;

import java.util.List;
import java.util.Map;

/**
 * 排课表
 * 
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
public interface ArrCourseService {
	
	ArrCoursePO get(Integer id);
	
	List<ArrCoursePO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ArrCoursePO arrCourse);
	
	int update(ArrCoursePO arrCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

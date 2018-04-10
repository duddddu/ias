package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.ArrCoursePO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 排课表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface ArrCourseMapper {

	ArrCoursePO get(Integer id);
	
	List<ArrCoursePO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ArrCoursePO arrCourse);
	
	int update(ArrCoursePO arrCourse);
	
	int remove(Integer Id);
	
	int batchRemove(Integer[] ids);
}

package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.CoursePO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 课程表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface CourseMapper {

	CoursePO get(Integer id);
	
	List<CoursePO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoursePO course);
	
	int update(CoursePO course);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

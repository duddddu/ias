package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.StuCoursePO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学生课表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface StuCourseMapper {

	StuCoursePO get(Integer id);
	
	List<StuCoursePO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StuCoursePO stuCourse);
	
	int update(StuCoursePO stuCourse);
	
	int remove(Integer Id);
	
	int batchRemove(Integer[] ids);
}

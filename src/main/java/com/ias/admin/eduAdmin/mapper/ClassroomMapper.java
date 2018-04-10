package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.ClassroomPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 教室表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface ClassroomMapper {

	ClassroomPO get(Integer id);
	
	List<ClassroomPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ClassroomPO classroom);
	
	int update(ClassroomPO classroom);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

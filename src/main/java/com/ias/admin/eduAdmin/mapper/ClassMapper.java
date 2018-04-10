package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.ClassPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 班级表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface ClassMapper {

	ClassPO get(Integer id);
	
	List<ClassPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ClassPO classPO);
	
	int update(ClassPO classPO);
	
	int remove(Integer Id);
	
	int batchRemove(Integer[] ids);
}

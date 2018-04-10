package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.MajorPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 专业表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface MajorMapper {

	MajorPO get(Integer id);
	
	List<MajorPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MajorPO major);
	
	int update(MajorPO major);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

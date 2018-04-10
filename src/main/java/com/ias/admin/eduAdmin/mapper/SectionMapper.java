package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.SectionPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 节次表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface SectionMapper {

	SectionPO get(Integer id);
	
	List<SectionPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SectionPO section);
	
	int update(SectionPO section);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.WeekPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 周次表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface WeekMapper {

	WeekPO get(Integer id);
	
	List<WeekPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WeekPO week);
	
	int update(WeekPO week);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

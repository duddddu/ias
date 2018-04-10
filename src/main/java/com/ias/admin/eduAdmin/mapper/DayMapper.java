package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.DayPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 星期表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */
@Mapper
public interface DayMapper {

	DayPO get(Integer id);
	
	List<DayPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DayPO day);
	
	int update(DayPO day);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

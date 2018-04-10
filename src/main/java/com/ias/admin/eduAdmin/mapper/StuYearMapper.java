package com.ias.admin.eduAdmin.mapper;

import com.ias.admin.eduAdmin.pojo.StuYearPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学年表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 09:48:51
 */
@Mapper
public interface StuYearMapper {

	StuYearPO get(Integer id);
	
	List<StuYearPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(StuYearPO stuYear);
	
	int update(StuYearPO stuYear);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

package com.ias.admin.device.mapper;

import com.ias.admin.device.pojo.DLogPO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 设备日志表
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 15:55:40
 */
@Mapper
public interface DLogMapper {

	DLogPO get(Integer id);
	
	List<DLogPO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DLogPO log);
	
	int update(DLogPO log);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}

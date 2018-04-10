package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.LogPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface LogMapper {
    LogPO get(Integer id);

    List<LogPO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogPO logPO);

    int update(LogPO logPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

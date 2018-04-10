package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.BackUpPO;

import java.util.List;
import java.util.Map;

public interface BackUpMapper {
    BackUpPO get(Integer id);

    List<BackUpPO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(BackUpPO logPO);

    int update(BackUpPO logPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

}

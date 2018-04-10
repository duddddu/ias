package com.ias.admin.system.service;

import com.ias.admin.system.pojo.BackUpPO;

import java.util.List;
import java.util.Map;

public interface BackupService {
    BackUpPO get(Integer id);

    List<BackUpPO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(BackUpPO backUpPO);

    int update(BackUpPO backUpPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

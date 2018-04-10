package com.ias.admin.system.service;

import com.ias.admin.system.pojo.PermPO;

import java.util.List;
import java.util.Map;

public interface PermService {
    PermPO get(Integer id);

    List<PermPO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PermPO perm);

    int update(PermPO perm);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

}

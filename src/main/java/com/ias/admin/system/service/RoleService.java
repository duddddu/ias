package com.ias.admin.system.service;

import com.ias.admin.system.pojo.RolePO;

import java.util.List;
import java.util.Map;

public interface RoleService {
    RolePO get(Integer roleId);

    List<RolePO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(RolePO role);

    int update(RolePO role);

    int remove(Integer roleId);

    int batchRemove(Integer[] roleIds);

}

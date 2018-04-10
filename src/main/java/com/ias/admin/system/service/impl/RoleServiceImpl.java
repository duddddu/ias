package com.ias.admin.system.service.impl;

import com.ias.admin.system.mapper.RoleMapper;
import com.ias.admin.system.pojo.RolePO;
import com.ias.admin.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public RolePO get(Integer roleId) {
        return roleMapper.get(roleId);
    }

    @Override
    public List<RolePO> list(Map<String, Object> map) {
        return roleMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return roleMapper.count(map);
    }

    @Override
    public int save(RolePO role) {
        return roleMapper.save(role);
    }

    @Override
    public int update(RolePO role) {
        return roleMapper.update(role);
    }

    @Override
    public int remove(Integer roleId) {
        return roleMapper.remove(roleId);
    }

    @Override
    public int batchRemove(Integer[] roleIds) {
        return roleMapper.batchRemove(roleIds);
    }
}

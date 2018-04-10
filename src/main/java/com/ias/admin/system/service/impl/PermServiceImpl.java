package com.ias.admin.system.service.impl;

import com.ias.admin.system.mapper.PermMapper;
import com.ias.admin.system.pojo.MenuPO;
import com.ias.admin.system.pojo.PermPO;
import com.ias.admin.system.pojo.RolePO;
import com.ias.admin.system.service.MenuService;
import com.ias.admin.system.service.PermService;
import com.ias.admin.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermServiceImpl implements PermService {

    @Autowired
    PermMapper permMapper;
    @Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;

    @Override
    public PermPO get(Integer id) {
        PermPO permPO = permMapper.get(id);
        setForeignKeyObject(permPO);
        return permPO;
    }

    @Override
    public List<PermPO> list(Map<String, Object> map) {
        List<PermPO> permPOS = permMapper.list(map);
        setForeignKeyObject(permPOS);
        return permPOS;
    }

    @Override
    public int count(Map<String, Object> map) {
        return permMapper.count(map);
    }

    @Override
    public int save(PermPO perm) {
        return permMapper.save(perm);
    }

    @Override
    public int update(PermPO perm) {
        return permMapper.update(perm);
    }

    @Override
    public int remove(Integer id) {
        return permMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return permMapper.batchRemove(ids);
    }

    public void setForeignKeyObject(PermPO permPO){
        RolePO rolePO = roleService.get(permPO.getRoleId());
        MenuPO menuPO = menuService.get(permPO.getMenuId());
        permPO.setRolePO(rolePO);
        permPO.setMenuPO(menuPO);
    }

    public void setForeignKeyObject(List<PermPO> permPOs){
        for(PermPO permPO : permPOs){
            setForeignKeyObject(permPO);
        }
    }
}

package com.ias.admin.system.service.impl;

import com.ias.admin.common.pojo.Tree;
import com.ias.admin.common.util.MD5Utils;
import com.ias.admin.system.mapper.AdminMapper;
import com.ias.admin.system.mapper.RoleMapper;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.pojo.RolePO;
import com.ias.admin.system.service.AdminService;
import com.ias.admin.system.service.RoleService;
import com.ias.admin.system.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public AdminPO get(Integer id) {
        AdminPO adminPO = adminMapper.get(id);
        setForeignKeyObject(adminPO);
        return adminPO;
    }

    @Override
    public List<AdminPO> list(Map<String, Object> map) {
        List<AdminPO> adminPOS = adminMapper.list(map);
        setForeignKeyObject(adminPOS);
        return adminPOS;
    }

    @Override
    public int count(Map<String, Object> map) {
        return adminMapper.count(map);
    }

    @Override
    public int save(AdminPO admin) {
        return adminMapper.save(admin);
    }

    @Override
    public int update(AdminPO admin) {
        return adminMapper.update(admin);
    }

    @Override
    public int remove(Integer id) {
        return adminMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return adminMapper.batchRemove(ids);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = adminMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public int resetPwd(AdminVO adminVO, AdminPO adminPO) throws Exception {
        if(Objects.equals(adminVO.getAdminPO().getId(), adminPO.getId())){
            if(Objects.equals(MD5Utils.encrypt(adminPO.getUsername(), adminVO.getOldPwd()), adminPO.getPassword())){
                adminPO.setPassword(MD5Utils.encrypt(adminPO.getUsername(), adminVO.getNewPwd()));
                return adminMapper.update(adminPO);
            }else{
                throw new Exception("输入的旧密码有误");
            }
        }else{
            throw new Exception("你修改的不是你登录的账号!");
        }
    }

    @Override
    public int adminResetPwd(AdminVO adminVO) throws Exception{
        AdminPO adminPO = get(adminVO.getAdminPO().getId());
        if("admin".equals(adminPO.getUsername())){
            throw new Exception("超级管理员的账号不允许直接重置!");
        }
        adminPO.setPassword(MD5Utils.encrypt(adminPO.getUsername(), adminVO.getNewPwd()));
        return adminMapper.update(adminPO);
    }


    public void setForeignKeyObject(AdminPO adminPO){
        RolePO rolePO = roleService.get(adminPO.getRoleId());
        adminPO.setRole(rolePO);
    }

    public void setForeignKeyObject(List<AdminPO> adminPOs){
        for(AdminPO adminPO : adminPOs){
            setForeignKeyObject(adminPO);
        }
    }
}

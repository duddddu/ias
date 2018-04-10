package com.ias.admin.system.service.impl;


import com.ias.admin.system.mapper.BackUpMapper;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.pojo.BackUpPO;
import com.ias.admin.system.service.AdminService;
import com.ias.admin.system.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BackupServiceImpl implements BackupService{

    @Autowired
    BackUpMapper backUpMapper;

    @Autowired
    AdminService adminService;

    @Override
    public BackUpPO get(Integer id) {
        BackUpPO backUpPO = backUpMapper.get(id);
        setForeignKeyObject(backUpPO);
        return backUpPO;
    }

    @Override
    public List<BackUpPO> list(Map<String, Object> map) {
        List<BackUpPO> list = backUpMapper.list(map);
        setForeignKeyObject(list);
        return list;
    }

    @Override
    public int count(Map<String, Object> map) {
        return backUpMapper.count(map);
    }

    @Override
    public int save(BackUpPO backUpPO) {
        return backUpMapper.save(backUpPO);
    }

    @Override
    public int update(BackUpPO backUpPO) {
        return backUpMapper.update(backUpPO);
    }

    @Override
    public int remove(Integer id) {
        return backUpMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return backUpMapper.batchRemove(ids);
    }

    public void setForeignKeyObject(List<BackUpPO> backUpPOs){
        for(BackUpPO backUpPO : backUpPOs){
            setForeignKeyObject(backUpPO);
        }
    }

    public void setForeignKeyObject(BackUpPO backUpPO){
        AdminPO adminPO = adminService.get(backUpPO.getBackuperId());
        backUpPO.setBackuper(adminPO);
    }
}

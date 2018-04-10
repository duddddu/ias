package com.ias.admin.system.service.impl;

import com.ias.admin.common.pojo.PagePO;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.system.mapper.LogMapper;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.pojo.LogPO;
import com.ias.admin.system.service.AdminService;
import com.ias.admin.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@SuppressWarnings("AlibabaRemoveCommentedCode")
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;
    @Autowired
    AdminService adminService;


    @Override
    public PagePO<LogPO> queryList(PageParams pageParams) {
        int total = logMapper.count(pageParams);
        List<LogPO> logs = logMapper.list(pageParams);
        setForeignKeyObject(logs);
        PagePO<LogPO> page = new PagePO<>();
        page.setTotal(total);
        page.setRows(logs);
        return page;
    }

    @Override
    public int remove(Integer id) {
        return logMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return logMapper.batchRemove(ids);
    }

    public void setForeignKeyObject(List<LogPO> logPOs){
        AdminPO adminPO = null;
        for(LogPO logPO : logPOs){
            adminPO = adminService.get(logPO.getOperatorId());
            logPO.setOperator(adminPO);
        }
    }
}

package com.ias.admin.system.service;

import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.vo.AdminVO;

import java.util.List;
import java.util.Map;

public interface AdminService {
    AdminPO get(Integer id);

    List<AdminPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(AdminPO admin);

    int update(AdminPO admin);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    boolean exit(Map<String, Object> params);

    int resetPwd(AdminVO adminVO, AdminPO adminPO) throws Exception;

    int adminResetPwd(AdminVO adminVo) throws Exception;
    }


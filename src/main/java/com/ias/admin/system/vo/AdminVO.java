package com.ias.admin.system.vo;

import com.ias.admin.system.pojo.AdminPO;

public class AdminVO {

    private AdminPO adminPO = new AdminPO();

    private String oldPwd;

    private String newPwd;

    public AdminPO getAdminPO() {
        return adminPO;
    }

    public void setAdminPO(AdminPO adminPO) {
        this.adminPO = adminPO;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}

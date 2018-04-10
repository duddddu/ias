package com.ias.admin.common.controller;

import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.common.util.MyLogger;
import com.ias.admin.common.util.ShiroUtils;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.common.pojo.StudentPO;
import org.springframework.stereotype.Controller;


@Controller
public class BaseController {

    protected MyLogger logger = MyLogger.getLogger(this.getClass());

    public AdminPO getAdmin(){
        return ShiroUtils.getAdmin();
    }

    public TeacherPO getTeacher(){
        return ShiroUtils.getTeacher();
    }

    public StudentPO getStudent(){
        return ShiroUtils.getStudent();
    }

    public Integer getAdminId(){
        return getAdmin().getId();
    }

    public Integer getTeacherId(){
        return getTeacher().getId();
    }

    public Integer getStudentId(){
        return getStudent().getId();
    }

    public String getAdminUsername(){
        return getAdmin().getUsername();
    }

    public String getStudentNumber(){
        return getStudent().getStudentNumber();
    }

    public String getEmployeeNumber(){
        return getTeacher().getEmployeeNumber();
    }


}

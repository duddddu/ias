package com.ias.admin.common.util;

import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.common.pojo.StudentPO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Object getPrincipal(){
        Object object = getSubject().getPrincipal();
        return object;
    }

    public static AdminPO getAdmin(){
        return (AdminPO)getPrincipal();
    }

    public static TeacherPO getTeacher(){
        return (TeacherPO)getPrincipal();
    }

    public static StudentPO getStudent(){
        return (StudentPO)getPrincipal();
    }

    public static Integer getAdminId(){
        return getAdmin().getId();
    }

    public static Integer getTeacherId(){
        return getTeacher().getId();
    }

    public static Integer getStudentId(){
        return getStudent().getId();
    }

    public static void logout(){
        getSubject().logout();
    }

    public static List<Principal> getPrincipals(){
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}

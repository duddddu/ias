package com.ias.admin.system.shiro;

import com.ias.admin.common.config.ApplicaConte;
import com.ias.admin.common.mapper.TeacherMapper;
import com.ias.admin.common.pojo.TeacherPO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class TeacherRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("暂无权限控制");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String employeeNumber = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("employeeNumber", employeeNumber);
        map.put("post", 1);
        String password = new String((char[]) token.getCredentials());

        TeacherMapper teacherMapper = ApplicaConte.getBean(TeacherMapper.class);
        //查询用户信息
        TeacherPO teacherPO = null;
        try{
            teacherPO = teacherMapper.list(map).get(0);
        }catch(IndexOutOfBoundsException e){
            System.out.println("查询了教师账号");
        }

        //账号不存在
        if(teacherPO == null){
            throw new UnknownAccountException("账号不存在");
        }

        //密码错误
        if(!password.equals(teacherPO.getPassword())){
            throw new IncorrectCredentialsException("密码错误");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(teacherPO, password, getName());
        return info;
    }
}

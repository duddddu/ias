package com.ias.admin.system.shiro;

import com.ias.admin.common.config.ApplicaConte;
import com.ias.admin.common.mapper.StudentMapper;
import com.ias.admin.common.pojo.StudentPO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class StudentRealm extends AuthorizingRealm{

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("暂无权限控制");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String studentNumber = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("studentNumber", studentNumber);

        String password = new String((char[]) token.getCredentials());

        StudentMapper studentMapper = ApplicaConte.getBean(StudentMapper.class);
        //查询用户信息
        StudentPO studentPO = null;
        try{
            studentPO = studentMapper.list(map).get(0);
        }catch(IndexOutOfBoundsException e){
            System.out.println("查询了学生账号");
        }

        //账号不存在
        if(studentPO == null){
            throw new UnknownAccountException("账号不存在");
        }

        //密码错误
        if(!password.equals(studentPO.getPassword())){
            throw new IncorrectCredentialsException("密码错误");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(studentPO, password, getName());
        return info;
    }
}

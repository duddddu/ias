package com.ias.admin.system.shiro;

import com.ias.admin.common.config.ApplicaConte;
import com.ias.admin.common.util.ShiroUtils;
import com.ias.admin.system.mapper.AdminMapper;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    MenuService menuService;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*Integer adminId = ShiroUtils.getAdminId();
        Set<String> perms = menuService.listPerms(adminId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;*/
        System.out.println("暂无权限控制");
        return null;
    }


    /*
    * 提供账户信息返回认证信息
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//主体，就是当前登录的数据实体
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        String password = new String((char[]) token.getCredentials());
        //凭证，用户的密码，具体加密方式用户自己实现，什么都不做就是原文

        //Roles：用户拥有的角色标识（角色名称，admin,account,customer_service），
        // 字符串格式列表:用户拥有多个角色的可能

        //Permissions：用户拥有的权限标识（每个权限唯一标识，比如主键或者权限唯一标识编码），
        // 字符串格式列表：用户拥有多个权限的可能

        //查询用户信息
        adminMapper = ApplicaConte.getBean(AdminMapper.class);
        AdminPO adminPO = null;
        try{
            adminPO = adminMapper.list(map).get(0);
        }catch(IndexOutOfBoundsException e){
            System.out.println("查询了管理员账号");
        }

        // 账号不存在
        if (adminPO == null) {
            throw new UnknownAccountException("账号不存在");
        }

        //密码错误
        if (!password.equals(adminPO.getPassword())) {
            throw new UnknownAccountException("密码错误");
        }

        //第一个参数是user对象，第二个是指从数据库中获取的password，第三个参数是当前realm的名称。
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(adminPO, password, getName());
        return info;
    }
}
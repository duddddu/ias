package com.ias.admin.system.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.pojo.Tree;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.MD5Utils;
import com.ias.admin.common.util.ShiroUtils;
import com.ias.admin.system.pojo.MenuPO;
import com.ias.admin.system.service.MenuService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminLoginController extends BaseController {

    @Autowired
    MenuService menuService;

    @GetMapping({"/", "", "/login"})
    public String login(){
        return "admin/login";
    }

    @Log("管理系统登录")
    @PostMapping("/login")
    @ResponseBody
    public DU ajaxLogin(String username, String password){
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = ShiroUtils.getSubject();
        try{
            subject.login(token);
            return DU.ok();
        }catch(AuthenticationException e){
            return DU.error("账号或密码错误");
        }
    }

    @Log("访问管理系统主页")
    @GetMapping("/index")
    public String index(Model model){
        List<Tree<MenuPO>> menus = menuService.listMenuTree(getAdminId());
        model.addAttribute("menus", menus);
        model.addAttribute("name", getAdmin().getName());
        model.addAttribute("username", getAdminUsername() );
        return "admin/index";
    }
}

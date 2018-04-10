package com.ias.counselorMobile.common.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.MD5Utils;
import com.ias.admin.common.util.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cm")
public class CMLoginController extends BaseController {


    @GetMapping({"/", "", "/login"})
    public String login() {
        return "counselorMobile/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public DU ajaxLogin(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = ShiroUtils.getSubject();
        try {
            subject.login(token);
            return DU.ok();
        } catch (AuthenticationException e) {
            return DU.error("账号或密码错误");
        }
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", getTeacher().getName());
        model.addAttribute("username", getEmployeeNumber());
        return "counselorMobile/index";
    }
}

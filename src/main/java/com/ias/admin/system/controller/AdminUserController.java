package com.ias.admin.system.controller;


import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.pojo.Tree;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.MD5Utils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.system.pojo.AdminPO;
import com.ias.admin.system.pojo.RolePO;
import com.ias.admin.system.service.AdminService;
import com.ias.admin.system.service.RoleService;
import com.ias.admin.system.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin/sys/user")
@Controller
public class AdminUserController extends BaseController{
    private String prefix = "admin/system/user";

    @Autowired
    AdminService adminService;
    @Autowired
    RoleService roleService;

    @GetMapping("")
    public String admin(){
        return prefix + "/user";
    }

    @GetMapping("/list")
    @ResponseBody
    public PageUtils list(@RequestParam Map<String, Object> params){
        PageParams pageParams = new PageParams(params);
        List<AdminPO> adminPOList = adminService.list(pageParams);
        int total = adminService.count(pageParams);
        PageUtils pageUtils = new PageUtils(adminPOList, total);
        return pageUtils;
    }

    @Log("添加用户")
    @GetMapping("/add")
    public String add(Model model){
        List<RolePO> rolePOS = roleService.list(new HashMap<>());
        model.addAttribute("roles", rolePOS);
        return prefix + "/add";
    }

    @Log("编辑用户")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        AdminPO adminPO = adminService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<RolePO> rolePOS = roleService.list(map);
        model.addAttribute("admin", adminPO);
        model.addAttribute("roles", rolePOS);
        return prefix + "/edit";
    }

    @Log("保存用户")
    @PostMapping("/save")
    @ResponseBody
    public DU save(AdminPO adminPO){
        adminPO.setPassword(MD5Utils.encrypt(adminPO.getUsername(), adminPO.getPassword()));
        if(adminService.save(adminPO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    public DU update(AdminPO adminPO){
        if(adminService.update(adminPO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("删除用户")
    @PostMapping("/remove")
    @ResponseBody
    public DU remove(Integer id){
        if(adminService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("批量删除用户")
    @PostMapping("/batchRemove")
    @ResponseBody
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(adminService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @PostMapping("/exit")
    @ResponseBody
    public boolean exit(@RequestParam Map<String, Object> params){
        //存在
        return !adminService.exit(params);
    }

    @Log("请求更改用户密码")
    @GetMapping("/resetPwd/{id}")
    public String resetPwd(@PathVariable("id") Integer id, Model model){
        AdminPO adminPO = new AdminPO();
        adminPO.setId(id);
        model.addAttribute("admin", adminPO);
        return prefix + "/reset_pwd";
    }

    @Log("提交更改用户密码")
    @PostMapping("/resetPwd")
    @ResponseBody
    public DU resetPwd(AdminVO adminVO){
        try{
            adminService.resetPwd(adminVO, getAdmin());
            return DU.ok();
        }catch(Exception e){
            return DU.error(1, e.getMessage());
        }
    }

    @Log("admin提交更改用户密码")
    @PostMapping("/adminResetPwd")
    @ResponseBody
    public DU adminResetPwd(AdminVO adminVO){
        try{
            adminService.adminResetPwd(adminVO);
            return DU.ok();
        }catch(Exception e){
            return DU.error(1, e.getMessage());
        }
    }
}

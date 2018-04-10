package com.ias.admin.system.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.system.pojo.RolePO;
import com.ias.admin.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/sys/role")
public class AdminRoleController extends BaseController {
    private String prefix  = "admin/system/role";

    @Autowired
    RoleService roleService;

    @GetMapping("")
    public String admin(){
        return prefix + "/role";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<RolePO> list(){
        List<RolePO> rolePOs = roleService.list(new HashMap<>());
        return rolePOs;
    }

    @Log("添加角色")
    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @Log("编辑角色")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        RolePO rolePO = roleService.get(id);
        model.addAttribute("role", rolePO);
        return prefix + "/edit";
    }

    @Log("保存角色")
    @PostMapping("/save")
    @ResponseBody
    public DU save(RolePO rolePO){
        rolePO.setCreateTime(new Date());
        if(roleService.save(rolePO) > 0){
            return DU.ok();
        }
        return DU.error(1, "保存失败");
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    public DU update(RolePO rolePO){
        if(roleService.update(rolePO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("删除角色")
    @PostMapping("/remove")
    @ResponseBody
    public DU remove(Integer id){
        if(roleService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("批量删除角色")
    @PostMapping("/batchRemove")
    @ResponseBody
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(roleService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }
}

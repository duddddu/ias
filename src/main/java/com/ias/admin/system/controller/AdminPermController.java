package com.ias.admin.system.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.util.DU;
import com.ias.admin.system.pojo.PermPO;
import com.ias.admin.system.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/sys/perm")
public class AdminPermController {
    String prefix = "admin/system/perm";
    
    
    @Autowired
    PermService permService;

    @GetMapping("")
    public String admin(){
        return prefix + "/perm";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<PermPO> list(){
        List<PermPO> permPOs = permService.list(new HashMap<>());
        return permPOs;
    }

    @Log("添加权限")
    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @Log("编辑权限")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        PermPO permPO = permService.get(id);
        model.addAttribute("perm", permPO);
        return prefix + "/edit";
    }

    @Log("保存权限")
    @PostMapping("/save")
    @ResponseBody
    public DU save(PermPO permPO){
        permPO.setCreateTime(new Date());
        if(permService.save(permPO) > 0){
            return DU.ok();
        }
        return DU.error(1, "保存失败");
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    public DU update(PermPO permPO){
        if(permService.update(permPO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("删除权限")
    @PostMapping("/remove")
    @ResponseBody
    public DU remove(Integer id){
        if(permService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("批量删除权限")
    @PostMapping("/batchRemove")
    @ResponseBody
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(permService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }

}

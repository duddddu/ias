package com.ias.admin.system.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.util.DU;
import com.ias.admin.system.pojo.BackUpPO;
import com.ias.admin.system.service.BackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/sys/backup")
public class AdminBackUpController {

    String prefix = "/admin/system/backup";

    @Autowired
    BackupService backupService;

    @GetMapping("")
    public String admin(){
        return prefix + "/backup";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<BackUpPO> list(){
        List<BackUpPO> backupPOs = backupService.list(new HashMap<>());
        return backupPOs;
    }

    @Log("添加备份")
    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @Log("编辑备份")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        BackUpPO backupPO = backupService.get(id);
        model.addAttribute("backup", backupPO);
        return prefix + "/edit";
    }

    @Log("保存备份")
    @PostMapping("/save")
    @ResponseBody
    public DU save(BackUpPO backupPO){
        backupPO.setBackupTime(new Date());
        if(backupService.save(backupPO) > 0){
            return DU.ok();
        }
        return DU.error(1, "保存失败");
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    public DU update(BackUpPO backupPO){
        if(backupService.update(backupPO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("删除备份")
    @PostMapping("/remove")
    @ResponseBody
    public DU remove(Integer id){
        if(backupService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("批量删除备份")
    @PostMapping("/batchRemove")
    @ResponseBody
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(backupService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }
}

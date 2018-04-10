package com.ias.admin.system.controller;

import com.ias.admin.common.pojo.PagePO;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.system.pojo.LogPO;
import com.ias.admin.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin/sys/log")
public class AdminLogController {

    @Autowired
    LogService logService;
    String prefix = "/admin/system/log";

    @GetMapping
    public String log(){
        return prefix + "/log";
    }

    @ResponseBody
    @GetMapping("/list")
    public PagePO<LogPO> list(@RequestParam Map<String, Object> params){
        PageParams query = new PageParams(params);
        PagePO<LogPO> page = logService.queryList(query);
        return page;
    }

    @ResponseBody
    @PostMapping("/remove")
    public DU remove(Integer id){
        if(logService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @ResponseBody
    @PostMapping("/batchRemove")
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(logService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }
}

package com.ias.admin.device.controller;


import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.device.pojo.DevicePO;
import com.ias.admin.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/device/manager")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping()
    String Device(){
        return "admin/device/manager/manager";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageParams query = new PageParams(params);
        List<DevicePO> deviceList = deviceService.list(query);
        int total = deviceService.count(query);
        PageUtils pageUtils = new PageUtils(deviceList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(){
        return "admin/device/manager/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model){
        DevicePO device = deviceService.get(id);
        model.addAttribute("device", device);
        return "admin/device/manager/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public DU save(DevicePO device){
        if(deviceService.save(device)>0){
            return DU.ok();
        }
        return DU.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public DU update( DevicePO device){
        if(deviceService.update(device) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    public DU remove( Integer id){
        if(deviceService.remove(id)>0){
            return DU.ok();
        }
        return DU.error();
    }

    /**
     * 删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    public DU remove(@RequestParam("ids[]") Integer[] ids){
        if(deviceService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }
}

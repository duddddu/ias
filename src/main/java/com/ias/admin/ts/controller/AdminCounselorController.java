package com.ias.admin.ts.controller;

import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.common.service.TeacherService;
import com.ias.admin.common.util.DU;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/ts/counselor")
public class AdminCounselorController extends BaseController{

    String prefix = "admin/ts/counselor";

    @Autowired
    TeacherService counselorService;

    @GetMapping()
    String Teacher(){
        return "admin/ts/counselor/counselor";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageParams query = new PageParams(params);
        query.put("post",2);
        List<TeacherPO> counselorList = counselorService.list(query);
        int total = counselorService.count(query);
        PageUtils pageUtils = new PageUtils(counselorList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(){
        return "admin/eduAdmin/counselor/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model){
        TeacherPO counselor = counselorService.get(id);
        model.addAttribute("counselor", counselor);
        return "admin/eduAdmin/counselor/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public DU save( TeacherPO counselor){
        if(counselorService.save(counselor)>0){
            return DU.ok();
        }
        return DU.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public DU update( TeacherPO counselor){
        if(counselorService.update(counselor) > 0){
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
        if(counselorService.remove(id)>0){
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
        if(counselorService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }

}

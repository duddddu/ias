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
@RequestMapping("/admin/ts/teacher")
public class AdminTeacherController extends BaseController{

    String prefix = "admin/ts/teacher";

    @Autowired
    TeacherService teacherService;

    @GetMapping()
    String Teacher(){
        return "admin/ts/teacher/teacher";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageParams query = new PageParams(params);
        query.put("post",1);
        List<TeacherPO> teacherList = teacherService.list(query);
        int total = teacherService.count(query);
        PageUtils pageUtils = new PageUtils(teacherList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(){
        return "admin/eduAdmin/teacher/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model){
        TeacherPO teacher = teacherService.get(id);
        model.addAttribute("teacher", teacher);
        return "admin/eduAdmin/teacher/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public DU save( TeacherPO teacher){
        if(teacherService.save(teacher)>0){
            return DU.ok();
        }
        return DU.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public DU update( TeacherPO teacher){
        if(teacherService.update(teacher) > 0){
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
        if(teacherService.remove(id)>0){
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
        if(teacherService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }

}

package com.ias.admin.ts.controller;

import com.ias.admin.common.controller.BaseController;
import com.ias.admin.common.pojo.StudentPO;
import com.ias.admin.common.service.StudentService;
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
@RequestMapping("/admin/ts/student")
public class AdminStudentController extends BaseController {

    String prefix = "admin/ts/student";

    @Autowired
    StudentService studentService;

    @GetMapping()
    String Student(){
        return "admin/ts/student/student";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
        PageParams query = new PageParams(params);
        List<StudentPO> studentList = studentService.list(query);
        int total = studentService.count(query);
        PageUtils pageUtils = new PageUtils(studentList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(){
        return "admin/ts/student/add";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model){
        StudentPO student = studentService.get(id);
        model.addAttribute("student", student);
        return "admin/ts/student/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public DU save(StudentPO student){
        if(studentService.save(student)>0){
            return DU.ok();
        }
        return DU.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public DU update( StudentPO student){
        if(studentService.update(student) > 0){
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
        if(studentService.remove(id)>0){
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
        if(studentService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }




}

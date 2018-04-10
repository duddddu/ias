package com.ias.admin.eduAdmin.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ias.admin.eduAdmin.pojo.StuCoursePO;
import com.ias.admin.eduAdmin.service.StuCourseService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 学生课表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */

@Controller
@RequestMapping("/admin/eduAdmin/stuCourse")
public class StuCourseController {
	@Autowired
	private StuCourseService stuCourseService;

	@GetMapping()
	String StuCourse(){
	    return "admin/eduAdmin/stuCourse/stuCourse";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<StuCoursePO> stuCourseList = stuCourseService.list(query);
		int total = stuCourseService.count(query);
		PageUtils pageUtils = new PageUtils(stuCourseList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(){
	    return "admin/eduAdmin/stuCourse/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		StuCoursePO stuCourse = stuCourseService.get(id);
		model.addAttribute("stuCourse", stuCourse);
	    return "admin/eduAdmin/stuCourse/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public DU save( StuCoursePO stuCourse){
		if(stuCourseService.save(stuCourse)>0){
			return DU.ok();
		}
		return DU.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public DU update( StuCoursePO stuCourse){
		if(stuCourseService.update(stuCourse) > 0){
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
		if(stuCourseService.remove(id)>0){
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
		if(stuCourseService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

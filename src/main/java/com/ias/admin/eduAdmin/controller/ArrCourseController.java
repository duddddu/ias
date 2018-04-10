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

import com.ias.admin.eduAdmin.pojo.ArrCoursePO;
import com.ias.admin.eduAdmin.service.ArrCourseService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 排课表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */

@Controller
@RequestMapping("/admin/eduAdmin/arrCourse")
public class ArrCourseController {
	@Autowired
	private ArrCourseService arrCourseService;

	@GetMapping()
	String ArrCourse(){
	    return "admin/eduAdmin/arrCourse/arrCourse";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<ArrCoursePO> arrCourseList = arrCourseService.list(query);
		int total = arrCourseService.count(query);
		PageUtils pageUtils = new PageUtils(arrCourseList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(){
	    return "admin/eduAdmin/arrCourse/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		ArrCoursePO arrCourse = arrCourseService.get(id);
		model.addAttribute("arrCourse", arrCourse);
	    return "admin/eduAdmin/arrCourse/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public DU save( ArrCoursePO arrCourse){
		if(arrCourseService.save(arrCourse)>0){
			return DU.ok();
		}
		return DU.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public DU update( ArrCoursePO arrCourse){
		if(arrCourseService.update(arrCourse) > 0){
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
		if(arrCourseService.remove(id)>0){
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
		if(arrCourseService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

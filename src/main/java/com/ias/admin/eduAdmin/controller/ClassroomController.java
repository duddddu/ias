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

import com.ias.admin.eduAdmin.pojo.ClassroomPO;
import com.ias.admin.eduAdmin.service.ClassroomService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 教室表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */

@Controller
@RequestMapping("/admin/eduAdmin/classroom")
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;

	@GetMapping()
	String Classroom(){
	    return "admin/eduAdmin/classroom/classroom";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<ClassroomPO> classroomList = classroomService.list(query);
		int total = classroomService.count(query);
		PageUtils pageUtils = new PageUtils(classroomList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(){
	    return "admin/eduAdmin/classroom/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		ClassroomPO classroom = classroomService.get(id);
		model.addAttribute("classroom", classroom);
	    return "admin/eduAdmin/classroom/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public DU save( ClassroomPO classroom){
		if(classroomService.save(classroom)>0){
			return DU.ok();
		}
		return DU.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public DU update( ClassroomPO classroom){
		if(classroomService.update(classroom) > 0){
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
		if(classroomService.remove(id)>0){
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
		if(classroomService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

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

import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 院系表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-08 22:54:13
 */

@Controller
@RequestMapping("/admin/eduAdmin/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping()
	String Department(){
	    return "admin/eduAdmin/department/department";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<DepartmentPO> departmentList = departmentService.list(query);
		int total = departmentService.count(query);
		PageUtils pageUtils = new PageUtils(departmentList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(){
	    return "admin/eduAdmin/department/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		DepartmentPO department = departmentService.get(id);
		model.addAttribute("department", department);
	    return "admin/eduAdmin/department/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public DU save( DepartmentPO department){
		if(departmentService.save(department)>0){
			return DU.ok();
		}
		return DU.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public DU update( DepartmentPO department){
		if(departmentService.update(department) > 0){
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
		if(departmentService.remove(id)>0){
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
		if(departmentService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

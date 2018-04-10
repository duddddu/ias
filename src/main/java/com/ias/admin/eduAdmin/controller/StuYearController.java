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

import com.ias.admin.eduAdmin.pojo.StuYearPO;
import com.ias.admin.eduAdmin.service.StuYearService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 学年表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 09:48:51
 */

@Controller
@RequestMapping("/admin/eduAdmin/stuYear")
public class StuYearController {
	@Autowired
	private StuYearService stuYearService;

	@GetMapping()
	String StuYear(){
	    return "admin/eduAdmin/stuYear/stuYear";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<StuYearPO> stuYearList = stuYearService.list(query);
		int total = stuYearService.count(query);
		PageUtils pageUtils = new PageUtils(stuYearList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add(){
	    return "admin/eduAdmin/stuYear/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		StuYearPO stuYear = stuYearService.get(id);
		model.addAttribute("stuYear", stuYear);
	    return "admin/eduAdmin/stuYear/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public DU save( StuYearPO stuYear){
		if(stuYearService.save(stuYear)>0){
			return DU.ok();
		}
		return DU.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public DU update( StuYearPO stuYear){
		if(stuYearService.update(stuYear) > 0){
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
		if(stuYearService.remove(id)>0){
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
		if(stuYearService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

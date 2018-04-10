package com.ias.admin.device.controller;

import java.util.Date;
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

import com.ias.admin.device.pojo.DLogPO;
import com.ias.admin.device.service.DLogService;
import com.ias.admin.common.util.PageUtils;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.common.util.DU;

/**
 * 设备日志表
 *
 * @author dudu
 * @email 345912664@qq.com
 * @date 2018-04-09 15:55:40
 */

@Controller
@RequestMapping("/admin/device/log")
public class DLogController {
	@Autowired
	private DLogService dlogService;

	@GetMapping()
	String DLog(){
	    return "admin/device/log/log";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        PageParams query = new PageParams(params);
		List<DLogPO> dlogList = dlogService.list(query);
		int total = dlogService.count(query);
		PageUtils pageUtils = new PageUtils(dlogList, total);
		return pageUtils;
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public DU remove( Integer id){
		if(dlogService.remove(id)>0){
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
		if(dlogService.batchRemove(ids) > 0){
            return DU.ok();
        }
		return DU.error();
	}
	
}

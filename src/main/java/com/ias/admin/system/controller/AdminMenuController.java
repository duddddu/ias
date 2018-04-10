package com.ias.admin.system.controller;

import com.ias.admin.common.annotation.Log;
import com.ias.admin.common.pojo.Tree;
import com.ias.admin.common.util.DU;
import com.ias.admin.system.pojo.MenuPO;
import com.ias.admin.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/sys/menu")
public class AdminMenuController {
    String prefix = "admin/system/menu";
    @Autowired
    MenuService menuService;

    @GetMapping("")
    public String admin(){
        return prefix + "/menu";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<MenuPO> list(@RequestParam Map<String, Object> params){
        List<MenuPO> menuPOs = menuService.list(params);
        return menuPOs;
    }

    @Log("添加菜单")
    @GetMapping("/add/{pId}")
    public String add(Model model, @PathVariable("pId") Integer pId){
        model.addAttribute("pId", pId);
        if(pId == 0){
            model.addAttribute("pName", "根目录");
        }else{
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        return prefix + "/add";
    }

    @Log("编辑菜单")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        MenuPO menuPO = menuService.get(id);
        Integer pId = menuPO.getParentId();
        model.addAttribute("pId", pId);
        if(pId == 0){
            model.addAttribute("pName", "根目录");
        }else{
            model.addAttribute("pName", menuService.get(pId).getName());
        }
        model.addAttribute("menu", menuPO);
        return prefix + "/edit";
    }

    @Log("保存菜单")
    @PostMapping("/save")
    @ResponseBody
    public DU save(MenuPO menuPO){
        menuPO.setCreateTime(new Date());
        if(menuService.save(menuPO) > 0){
            return DU.ok();
        }
        return DU.error(1, "保存失败");
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    public DU update(MenuPO menuPO){
        if(menuService.update(menuPO) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    @Log("删除菜单")
    @PostMapping("/remove")
    @ResponseBody
    public DU remove(Integer id){
        if(menuService.remove(id) > 0){
            return DU.ok();
        }
        return DU.error();
    }

    /*@Log("批量删除菜单")
    @PostMapping("/batchRemove")
    @ResponseBody
    public DU batchRemove(@RequestParam("ids[]") Integer[] ids){
        if(menuService.batchRemove(ids) > 0){
            return DU.ok();
        }
        return DU.error();
    }*/


    @GetMapping("/tree/{id}")
    @ResponseBody
    Tree<MenuPO> tree(@PathVariable("id") Integer roleId) {
        Tree<MenuPO> tree = new Tree<MenuPO>();
        tree = menuService.getTree(roleId);
        return tree;
    }

    @GetMapping("/tree")
    @ResponseBody
    Tree<MenuPO> tree() {
        Tree<MenuPO> tree = new Tree<MenuPO>();
        tree = menuService.getTree();
        return tree;
    }

}

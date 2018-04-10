package com.ias.admin.system.service.impl;

import com.ias.admin.common.pojo.Tree;
import com.ias.admin.common.util.BuildTree;
import com.ias.admin.system.mapper.MenuMapper;
import com.ias.admin.system.mapper.PermMapper;
import com.ias.admin.system.pojo.MenuPO;
import com.ias.admin.system.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SuppressWarnings("AlibabaRemoveCommentedCode")
@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    PermMapper permMapper;

    /**
     * @param
     * @return 树形菜单
     * */
    @Cacheable
    @Override
    public Tree<MenuPO> getSysMenuTree(Integer id) {
        List<Tree<MenuPO>> trees = new ArrayList<>();
        List<MenuPO> menuPOS = menuMapper.listMenuByAdminId(id);
        for(MenuPO menuPO : menuPOS){
            Tree<MenuPO> tree = new Tree();
            tree.setId(menuPO.getId().toString());
            tree.setParentId(menuPO.getParentId().toString());
            tree.setText(menuPO.getName());
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("url", menuPO.getUrl());
            attributes.put("icon", menuPO.getIcon());
            tree.setAttributes(attributes);
            trees.add(tree);
        }
        // 默认顶级菜单为0， 根据数据库实际情况调整
        Tree<MenuPO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public List<Tree<MenuPO>> listMenuTree(Integer id) {
       List<Tree<MenuPO>> trees = new ArrayList<>();
       List<MenuPO> menuPOS = menuMapper.listMenuByAdminId(id);
       for(MenuPO menuPO : menuPOS){
           Tree<MenuPO> tree = new Tree();
           tree.setId(menuPO.getId().toString());
           tree.setParentId(menuPO.getParentId().toString());
           tree.setText(menuPO.getName());
           Map<String, Object> attributes = new HashMap<>();
           attributes.put("url", menuPO.getUrl());
           attributes.put("icon", menuPO.getIcon());
           tree.setAttributes(attributes);
           trees.add(tree);
       }
       List<Tree<MenuPO>> list = BuildTree.buildList(trees, "0");
        return list;
    }

    @Override
    public Tree<MenuPO> getTree() {
        List<Tree<MenuPO>> trees = new ArrayList<>();
        List<MenuPO> menuPOS = menuMapper.list(new HashMap<>());
        for(MenuPO menuPO : menuPOS){
            Tree<MenuPO> tree = new Tree();
            tree.setId(menuPO.getId().toString());
            tree.setParentId(menuPO.getParentId().toString());
            tree.setText(menuPO.getName());
            trees.add(tree);
        }
        Tree<MenuPO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public Tree<MenuPO> getTree(Integer id) {
        //根据roleId查询权限
        List<MenuPO> menuPOs = menuMapper.list(new HashMap<>());
        List<Integer> menuIds = permMapper.listMenuIdByRoleId(id);
        List<Integer> temp = menuIds;
        for(MenuPO menuPO : menuPOs){
            if(temp.contains(menuPO.getParentId())){
                menuIds.remove(menuPO.getParentId());
            }
        }
        List<Tree<MenuPO>> trees = new ArrayList<>();
        List<MenuPO> menus = menuMapper.list(new HashMap<>());
        for(MenuPO menuPO : menuPOs){
            Tree<MenuPO> tree = new Tree();
            tree.setId(menuPO.getId().toString());
            tree.setParentId(menuPO.getParentId().toString());
            tree.setText(menuPO.getName());
            Map<String, Object> state = new HashMap<>();
            Integer menuId = menuPO.getId();
            if(menuIds.contains(menuId)){
                state.put("selected", true);
            }else{
                state.put("selected", false);
            }
            tree.setState(state);
            trees.add(tree);
        }
        Tree<MenuPO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public List<MenuPO> list(Map<String, Object> params) {
        return menuMapper.list(params);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return menuMapper.batchRemove(ids);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int remove(Integer id) {
        return menuMapper.remove(id);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int save(MenuPO menu) {
        return menuMapper.save(menu);
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int update(MenuPO menu) {
        return menuMapper.update(menu);
    }

    @Override
    public MenuPO get(Integer id) {
        return menuMapper.get(id);
    }

    @Override
    public Set<String> listPerms(Integer adminId) {
        List<String> perms = menuMapper.listStaffPerms(adminId);
        Set<String> permsSet = new HashSet<>();
        for(String perm : perms){
            if(StringUtils.isNotBlank(perm)){
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}

package com.ias.admin.system.service;

import com.ias.admin.common.pojo.Tree;
import com.ias.admin.system.pojo.MenuPO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface MenuService {

    Tree<MenuPO> getSysMenuTree(Integer id);

    List<Tree<MenuPO>> listMenuTree(Integer id);

    Tree<MenuPO> getTree();

    Tree<MenuPO> getTree(Integer id);

    List<MenuPO> list(Map<String, Object> params);

    int batchRemove(Integer[] ids);

    int remove(Integer id);

    int save(MenuPO menu);

    int update(MenuPO menu);

    MenuPO get(Integer id);

    Set<String> listPerms(Integer adminId);

}

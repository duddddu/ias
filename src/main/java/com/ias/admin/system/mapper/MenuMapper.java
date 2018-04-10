package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.MenuPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface MenuMapper {

    MenuPO get(Integer menuPOId);

    List<MenuPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(MenuPO menuPO);

    int update(MenuPO menuPO);

    int remove(Integer menuPOId);

    int batchRemove(Integer[] menuPOIds);

    List<MenuPO> listMenuByAdminId(Integer id);

    List<String> listStaffPerms(Integer id);

}

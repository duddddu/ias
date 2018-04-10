package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.PermPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface PermMapper {
    PermPO get(Integer id);

    List<PermPO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PermPO perm);

    int update(PermPO perm);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

    List<Integer> listMenuIdByRoleId(Integer roleId);

    int removeByRoleId(Integer roleId);

    int removeByMenuId(Integer menuId);

    int batchSave(List<PermPO> list);
}
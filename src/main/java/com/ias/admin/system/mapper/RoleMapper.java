package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.RolePO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    RolePO get(Integer roleId);

    List<RolePO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(RolePO role);

    int update(RolePO role);

    int remove(Integer roleId);

    int batchRemove(Integer[] roleIds);


}

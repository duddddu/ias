package com.ias.admin.system.mapper;

import com.ias.admin.system.pojo.AdminPO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;
@Mapper
public interface AdminMapper {

    AdminPO get(Integer id);

    List<AdminPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(AdminPO adminPO);

    int update(AdminPO adminPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
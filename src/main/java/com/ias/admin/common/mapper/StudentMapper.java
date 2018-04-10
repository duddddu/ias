package com.ias.admin.common.mapper;

import com.ias.admin.common.pojo.StudentPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    StudentPO get(Integer id);

    List<StudentPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(StudentPO StudentPO);

    int update(StudentPO StudentPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

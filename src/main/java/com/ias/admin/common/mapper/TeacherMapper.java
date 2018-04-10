package com.ias.admin.common.mapper;

import com.ias.admin.common.pojo.TeacherPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

    TeacherPO get(Integer id);

    List<TeacherPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(TeacherPO teacherPO);

    int update(TeacherPO teacherPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

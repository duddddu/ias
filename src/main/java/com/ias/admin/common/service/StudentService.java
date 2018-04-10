package com.ias.admin.common.service;

import com.ias.admin.common.pojo.StudentPO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    StudentPO get(Integer id);

    List<StudentPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(StudentPO studentPO);

    int update(StudentPO studentPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

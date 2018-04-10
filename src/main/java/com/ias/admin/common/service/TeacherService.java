package com.ias.admin.common.service;

import com.ias.admin.common.pojo.TeacherPO;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    TeacherPO get(Integer id);

    List<TeacherPO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(TeacherPO TeacherPO);

    int update(TeacherPO TeacherPO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}

package com.ias.admin.common.service.impl;

import com.ias.admin.common.mapper.TeacherMapper;
import com.ias.admin.common.pojo.TeacherPO;
import com.ias.admin.common.service.TeacherService;
import com.ias.admin.eduAdmin.pojo.DepartmentPO;
import com.ias.admin.eduAdmin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    DepartmentService departmentService;

    @Override
    public TeacherPO get(Integer id) {
        TeacherPO teacherPO = teacherMapper.get(id);
        setForeignKeyObject(teacherPO);
        return teacherPO;
    }

    @Override
    public List<TeacherPO> list(Map<String, Object> map) {
        List<TeacherPO> teacherPOs = teacherMapper.list(map);
        setForeignKeyObject(teacherPOs);
        return teacherPOs;
    }

    @Override
    public int count(Map<String, Object> map) {
        return teacherMapper.count(map);
    }

    @Override
    public int save(TeacherPO teacherPO) {
        return teacherMapper.save(teacherPO);
    }

    @Override
    public int update(TeacherPO teacherPO) {
        return teacherMapper.update(teacherPO);
    }

    @Override
    public int remove(Integer id) {
        return teacherMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return teacherMapper.batchRemove(ids);
    }

    public void setForeignKeyObject(List<TeacherPO> teacherPOs){
        for(TeacherPO teacherPO : teacherPOs){
            setForeignKeyObject(teacherPO);
        }
    }

    public void setForeignKeyObject(TeacherPO teacherPO){
        DepartmentPO departmentPO = departmentService.get(teacherPO.getDepartmentId());
        teacherPO.setDepartmentPO(departmentPO);
    }
}

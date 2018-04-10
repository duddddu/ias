package com.ias.admin.common.service.impl;

import com.ias.admin.common.mapper.StudentMapper;
import com.ias.admin.common.pojo.StudentPO;
import com.ias.admin.common.service.StudentService;
import com.ias.admin.eduAdmin.pojo.ClassPO;
import com.ias.admin.eduAdmin.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassService classService;

    @Override
    public StudentPO get(Integer id) {
        StudentPO studentPO = studentMapper.get(id);
        setForeignKeyObject(studentPO);
        return studentPO;
    }

    @Override
    public List<StudentPO> list(Map<String, Object> map) {
        List<StudentPO> list = studentMapper.list(map);
        setForeignKeyObject(list);
        return list;
    }

    @Override
    public int count(Map<String, Object> map) {
        return studentMapper.count(map);
    }

    @Override
    public int save(StudentPO studentPO) {
        return studentMapper.save(studentPO);
    }

    @Override
    public int update(StudentPO studentPO) {
        return studentMapper.update(studentPO);
    }

    @Override
    public int remove(Integer id) {
        return studentMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return studentMapper.batchRemove(ids);
    }


    public void setForeignKeyObject(List<StudentPO> studentPOs){
        for(StudentPO studentPO : studentPOs){
            setForeignKeyObject(studentPO);
        }
    }

    public void setForeignKeyObject(StudentPO studentPO){
        ClassPO classPO = classService.get(studentPO.getClassId());
        studentPO.setClassPO(classPO);
    }
}

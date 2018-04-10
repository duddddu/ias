package com.ias.admin.device.service.impl;

import com.ias.admin.device.mapper.DeviceMapper;
import com.ias.admin.device.pojo.DevicePO;
import com.ias.admin.device.service.DeviceService;
import com.ias.admin.eduAdmin.pojo.ClassroomPO;
import com.ias.admin.eduAdmin.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    ClassroomService classroomService;

    @Override
    public DevicePO get(Integer id) {
        DevicePO devicePO = deviceMapper.get(id);
        setForeignKeyObject(devicePO);
        return devicePO;
    }

    @Override
    public List<DevicePO> list(Map<String, Object> map) {
        List<DevicePO> list = deviceMapper.list(map);
        setForeignKeyObject(list);
        return list;
    }

    @Override
    public int count(Map<String, Object> map) {
        return deviceMapper.count(map);
    }

    @Override
    public int save(DevicePO devicePO) {
        return deviceMapper.save(devicePO);
    }

    @Override
    public int update(DevicePO devicePO) {
        return deviceMapper.update(devicePO);
    }

    @Override
    public int remove(Integer id) {
        return deviceMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return deviceMapper.batchRemove(ids);
    }

    public void setForeignKeyObject(List<DevicePO> devicePOs){
        for(DevicePO devicePO : devicePOs){
            setForeignKeyObject(devicePO);
        }
    }

    public void setForeignKeyObject(DevicePO devicePO){
        ClassroomPO classroomPO = classroomService.get(devicePO.getClassroomId());
        devicePO.setClassroomPO(classroomPO);
    }
}

package com.ias.admin.device.mapper;

import com.ias.admin.device.pojo.DevicePO;

import java.util.List;
import java.util.Map;

public interface DeviceMapper {
    DevicePO get(Integer id);

    List<DevicePO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(DevicePO devicePO);

    int update(DevicePO devicePO);

    int remove(Integer id);

    int batchRemove(Integer[] ids);

}

package com.ias.admin.system.service;

import com.ias.admin.common.pojo.PagePO;
import com.ias.admin.common.util.PageParams;
import com.ias.admin.system.pojo.LogPO;

import java.util.List;
import java.util.Map;

public interface LogService {
    PagePO<LogPO> queryList(PageParams pageParams);
    int remove(Integer id);
    int batchRemove(Integer[] ids);

}

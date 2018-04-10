package com.ias.admin.common.util;

import java.util.HashMap;
import java.util.Map;

public class DU extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public DU(){
        put("code", 0);
        put("msg", "操作成功");
    }

    public static DU error(){
        return error(1, "操作失败");
    }

    public static DU error(String msg){
        return error(500, msg);
    }

    public static DU error(int code, String msg){
        DU du = new DU();
        du.put("code", code);
        du.put("msg", msg);
        return du;
    }

    public static DU ok(String msg){
        DU du = new DU();
        du.put("msg", msg);
        return du;
    }

    public static DU ok(Map<String, Object> map){
        DU du = new DU();
        du.putAll(map);
        return du;
    }

    public static DU ok(){
        return new DU();
    }

    @Override
    public DU put(String key, Object value){
        super.put(key, value);
        return this;
    }
}

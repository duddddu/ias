package com.ias.admin.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
    private static final String SALT = "banban2";

    //加密算法名
    private static final String ALGORITH_NAME = "md5";
    //加密算法次数
    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String pswd){
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
        return newPassword;
    }

    public static String encrypt(String username, String pswd){
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }

    public static void main(String[]args){
        //管理系统测试账号
        System.out.println(MD5Utils.encrypt("admin", "1"));
        //辅导员系统测试账号
        System.out.println(MD5Utils.encrypt("cm001", "1"));
        //教师系统测试账号
        System.out.println(MD5Utils.encrypt("tm001", "1"));
        System.out.println(MD5Utils.encrypt("tp001", "1"));
        //学生系统测试账号
        System.out.println(MD5Utils.encrypt("sm001", "1"));
    }
}

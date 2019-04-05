package com.kairoshijun.excel.web01selectexcel.databases;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;

/**
 * ClassName:DatabaseContextHolder
 * Package:com.kairoshijun.excel.web01selectexcel.databases
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:17:40
 * @Hello-Idea
 */
public class DatabaseContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static String DEFAULT_DS= Contants.ZZMPAYDB;
    public static void setDatabaseType(String type){
        contextHolder.set(type);
    }

    public static String getDatabaseType(){
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }
}

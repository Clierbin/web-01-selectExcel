package com.kairoshijun.excel.web01selectexcel.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ClassName:TimeUtil
 * Package:com.kairoshijun.excel.web01selectexcel.time
 * description
 *
 * @author:zhangbin
 * @date:2019/3/23
 * @Time:13:57
 * @Hello-Idea
 */
public class TimeUtil {
    public static String getYesterdayString(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String ZUOTIAN=sp.format(d);
        return ZUOTIAN;
    }
    public static String getBeforeYseterDayString(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-2);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String ZUOTIAN=sp.format(d);
        return ZUOTIAN;
    }
    public static Date getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        return new Date();
    }
}

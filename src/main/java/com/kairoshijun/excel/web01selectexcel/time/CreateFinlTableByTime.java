package com.kairoshijun.excel.web01selectexcel.time;

import com.kairoshijun.excel.web01selectexcel.service.FinalTableService;
import com.kairoshijun.excel.web01selectexcel.service.FinaltableTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ClassName:CreateFinlTableByTime
 * Package:com.kairoshijun.excel.web01selectexcel.time
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:11:49
 * @Hello-Idea
 */
@Component
public class CreateFinlTableByTime {

    @Autowired
    private FinalTableService finalTableService;
    @Autowired
    private FinaltableTwoService finaltableTwoService;
    //每天中午12点执行更新昨天的数据   "0 0 12 * * ?"  "0/3 * * * * ?"
   /* @Scheduled(cron = "0 0 12 * * ?")
    public void test(){
        System.out.println("定时任务启动,正在向Finltable表中导入数据");
        finalTableService.insertTable();
    }
    //每天12点更新最全的数据库(前天的数据)
    @Scheduled(cron = "0 0 12 * * ?")
    public void test2(){
        System.out.println("定时任务启动,正在向FinltableTwo表中导入数据");
        finaltableTwoService.insertTable();
    }*/
}

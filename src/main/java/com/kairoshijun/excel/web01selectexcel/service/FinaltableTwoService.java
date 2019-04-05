package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.Finaltable;

import java.util.List;

/**
 * ClassName:FinaltableTwoService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/3/25
 * @Time:12:02
 * @Hello-Idea
 */
public interface FinaltableTwoService {
    void insertTable(String time);


    List<Finaltable> selectByTD(String[] channelSZ, String[] youxiSZ, String startTime, String endTime);
}

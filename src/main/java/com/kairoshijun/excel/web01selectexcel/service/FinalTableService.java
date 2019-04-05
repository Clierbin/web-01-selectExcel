package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.Finaltable;

import java.util.List;

/**
 * ClassName:FinalTableService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:12:01
 * @Hello-Idea
 */
public interface FinalTableService {
    void insertTable(String time);


    List<Finaltable> selectByTD(String[] channelSZ, String[] youxiSZ, String startTime, String endTime);
}

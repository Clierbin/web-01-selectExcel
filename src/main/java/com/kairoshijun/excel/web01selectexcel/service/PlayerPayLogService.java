package com.kairoshijun.excel.web01selectexcel.service;


import com.kairoshijun.excel.web01selectexcel.model.PlayerPayLog;

import java.util.List;

/**
 * ClassName:PlayerPayLogService
 * Package:com.kairogame.select02.service
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:25
 * @Hello-Idea
 */
public interface PlayerPayLogService {
    /**
     * 通过 游戏 (渠道 现在默认只要ios)和时间 查询 所有的数据
     * @param i
     * @param youxiSZ
     * @param startTime
     * @param endTime
     * @return
     */
    List<PlayerPayLog> selectByTD(int i, Integer[] youxiSZ, String startTime, String endTime);
}

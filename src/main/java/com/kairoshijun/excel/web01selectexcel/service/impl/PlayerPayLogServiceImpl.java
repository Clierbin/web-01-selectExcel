package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.PlayerPayLogMapper;
import com.kairoshijun.excel.web01selectexcel.model.PlayerPayLog;
import com.kairoshijun.excel.web01selectexcel.service.PlayerPayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:PlayerPayLogServiceImpl
 * Package:com.kairogame.select02.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:26
 * @Hello-Idea
 */
@Service
public class PlayerPayLogServiceImpl implements PlayerPayLogService {
    @Autowired
    private PlayerPayLogMapper playerPayLogMapper;
    @DS(Contants.NEWGAMEDB)
    @Override
    public List<PlayerPayLog> selectByTD(int i, Integer[] youxiSZ, String startTime, String endTime) {
        return playerPayLogMapper.selectByTD(10000,youxiSZ,startTime,endTime);
    }
}

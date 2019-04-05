package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.GameNotifyMapper;
import com.kairoshijun.excel.web01selectexcel.model.GameNotify;
import com.kairoshijun.excel.web01selectexcel.service.GameNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:GameNotifyServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/4/2
 * @Time:15:13
 * @Hello-Idea
 */
@Service
public class GameNotifyServiceImpl implements GameNotifyService {
    @Autowired
    private GameNotifyMapper gameNotifyMapper;
    @DS(Contants.NEWGAMEDB)
    @Transactional
    @Override
    public void insert(GameNotify gameNotify) {
        gameNotifyMapper.insertSelective(gameNotify);
    }
}

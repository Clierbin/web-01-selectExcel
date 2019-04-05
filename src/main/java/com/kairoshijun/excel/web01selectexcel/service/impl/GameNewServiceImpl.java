package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.GameNewMapper;
import com.kairoshijun.excel.web01selectexcel.model.GameNew;
import com.kairoshijun.excel.web01selectexcel.service.GameNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:GameServiceImpl
 * Package:com.kairogame.select02.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:26
 * @Hello-Idea
 */
@Service
public class GameNewServiceImpl implements GameNewService {
    @Autowired
    private GameNewMapper gameNewMapper;
    @DS(Contants.NEWGAMEDB)
    @Override
    public List<GameNew> selectAll() {
        return gameNewMapper.selectAll();
    }
}

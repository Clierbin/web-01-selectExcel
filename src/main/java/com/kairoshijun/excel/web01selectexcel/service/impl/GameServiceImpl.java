package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.GameMapper;
import com.kairoshijun.excel.web01selectexcel.model.Game;
import com.kairoshijun.excel.web01selectexcel.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:GameServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:11:20
 * @Hello-Idea
 */
@Service
public class GameServiceImpl implements GameService {
    //数据库中表重复了...日了狗
    @Autowired
    private GameMapper gameMapper;

    @Override
    public List<Game> selectAll() {
        return gameMapper.selectAll();
    }

    @Override
    public boolean checkGameId(Integer gameId) {
        return gameMapper.checkGameId(gameId)==0;
    }
    @Transactional
    @Override
    public boolean insertGame(Game game) {
        return gameMapper.insertSelective(game)==1;
    }


}

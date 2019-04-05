package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Game;

import java.util.List;

public interface GameMapper {
    int deleteByPrimaryKey(Game key);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectAll();

    int checkGameId(Integer gameId);
}
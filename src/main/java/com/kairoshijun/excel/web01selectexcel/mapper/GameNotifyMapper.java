package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.GameNotify;

public interface GameNotifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameNotify record);

    int insertSelective(GameNotify record);

    GameNotify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameNotify record);

    int updateByPrimaryKey(GameNotify record);
}
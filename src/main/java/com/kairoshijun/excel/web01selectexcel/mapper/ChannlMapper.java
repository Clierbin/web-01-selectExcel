package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Channl;

import java.util.List;

public interface ChannlMapper {
    int deleteByPrimaryKey(Integer channelid);

    int insert(Channl record);

    int insertSelective(Channl record);

    Channl selectByPrimaryKey(Integer channelid);

    int updateByPrimaryKeySelective(Channl record);

    int updateByPrimaryKey(Channl record);

    List<Channl> selectAll();

    int checkChannelId(Integer channelId);
}
package com.kairoshijun.excel.web01selectexcel.mapper;


import com.kairoshijun.excel.web01selectexcel.model.ChannelAndVersion;

import java.util.List;

public interface ChannelAndVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelAndVersion record);

    int insertSelective(ChannelAndVersion record);

    ChannelAndVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelAndVersion record);

    int updateByPrimaryKey(ChannelAndVersion record);

    List<ChannelAndVersion> getAll();
}
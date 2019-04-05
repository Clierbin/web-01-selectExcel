package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.PlayerPayLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerPayLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlayerPayLog record);

    int insertSelective(PlayerPayLog record);

    PlayerPayLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlayerPayLog record);

    int updateByPrimaryKeyWithBLOBs(PlayerPayLog record);

    int updateByPrimaryKey(PlayerPayLog record);

    List<PlayerPayLog> selectByTD(@Param(value = "channelId") int channelId, @Param(value = "youxiSZ") Integer[] youxiSZ, @Param(value = "startTime") String startTime, @Param(value = "endTime") String endTime);
}
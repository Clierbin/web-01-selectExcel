package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Finaltable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinaltableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Finaltable record);

    int insertSelective(Finaltable record);

    Finaltable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Finaltable record);

    int updateByPrimaryKey(Finaltable record);

    List<Finaltable> selectByTD(@Param(value = "channelSZ") String[] channelSZ, @Param(value = "youxiSZ") String[] youxiSZ, @Param(value = "startTime") String startTime, @Param(value = "endTime") String endTime);

    void insertByDSTime(@Param(value = "flist") List<Finaltable> flist);
}
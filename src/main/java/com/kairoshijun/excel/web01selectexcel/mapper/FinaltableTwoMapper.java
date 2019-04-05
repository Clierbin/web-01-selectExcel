package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Finaltable;
import com.kairoshijun.excel.web01selectexcel.model.FinaltableTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinaltableTwoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinaltableTwo record);

    int insertSelective(FinaltableTwo record);

    FinaltableTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinaltableTwo record);

    int updateByPrimaryKey(FinaltableTwo record);

    List<Finaltable> selectByTD(@Param(value = "channelSZ") String[] channelSZ, @Param(value = "youxiSZ") String[] youxiSZ, @Param(value = "startTime") String startTime, @Param(value = "endTime") String endTime);

    void insertByDSTime(@Param(value = "flist") List<Finaltable> flist);
}
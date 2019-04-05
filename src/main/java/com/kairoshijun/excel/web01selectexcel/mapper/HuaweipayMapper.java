package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Huaweipay;
import org.apache.ibatis.annotations.Param;

public interface HuaweipayMapper {
    int insert(Huaweipay record);

    int insertSelective(Huaweipay record);

    Double selectIncome(@Param(value = "time") String time, @Param(value = "gameId") Integer gameId);
}
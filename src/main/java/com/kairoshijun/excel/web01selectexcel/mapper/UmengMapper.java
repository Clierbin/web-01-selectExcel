package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Umeng;

import java.util.Date;
import java.util.List;

public interface UmengMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Umeng record);

    int insertSelective(Umeng record);

    Umeng selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Umeng record);

    int updateByPrimaryKey(Umeng record);

    List<Umeng> selectByTime(String date);
}
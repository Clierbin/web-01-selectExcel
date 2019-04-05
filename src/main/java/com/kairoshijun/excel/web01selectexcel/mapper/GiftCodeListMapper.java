package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.GiftCodeList;

public interface GiftCodeListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GiftCodeList record);

    int insertSelective(GiftCodeList record);

    GiftCodeList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GiftCodeList record);

    int updateByPrimaryKey(GiftCodeList record);

    int selectBylist(GiftCodeList giftCodeList);
}
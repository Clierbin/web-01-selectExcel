package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.GiftCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiftCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GiftCode record);

    int insertSelective(GiftCode record);

    GiftCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GiftCode record);

    int updateByPrimaryKey(GiftCode record);

    void updateBylist(@Param(value = "giftCodeListID") int giftCodeListID, @Param(value = "giftNum") Integer giftNum);

    List<GiftCode> selectByList(int giftCodeListID);
}
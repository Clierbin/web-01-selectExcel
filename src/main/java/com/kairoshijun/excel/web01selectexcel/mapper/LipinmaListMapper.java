package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.LipinmaList;

public interface LipinmaListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LipinmaList record);

    int insertSelective(LipinmaList record);

    LipinmaList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LipinmaList record);

    int updateByPrimaryKey(LipinmaList record);

    int selectBylist(LipinmaList lipinmaList);
}
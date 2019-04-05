package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Lipinma;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LipinmaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lipinma record);

    int insertSelective(Lipinma record);

    Lipinma selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lipinma record);

    int updateByPrimaryKey(Lipinma record);


    List<Lipinma> selectByList(int lipinmalistID);

    void updateBylist(@Param(value = "lipinmalistID") int lipinmalistID, @Param(value = "lpNum")Integer lpNum);
}
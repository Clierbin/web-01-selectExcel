package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.GameNew;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameNewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameNew record);

    int insertSelective(GameNew record);

    GameNew selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameNew record);

    int updateByPrimaryKey(GameNew record);
    @Select(" select * from game")@ResultMap(value = "BaseResultMap")
    List<GameNew> selectAll();
}
package com.kairoshijun.excel.web01selectexcel.mapper;

import com.kairoshijun.excel.web01selectexcel.model.Mail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mail record);

    int insertSelective(Mail record);

    Mail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKey(Mail record);

    void insertYiban(@Param(value = "mailList") List<Mail> mailList);

    void insertQufu(Mail mail);
}
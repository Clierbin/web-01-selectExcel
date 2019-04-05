package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.MailMapper;
import com.kairoshijun.excel.web01selectexcel.model.Mail;
import com.kairoshijun.excel.web01selectexcel.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:MailServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/4/1
 * @Time:14:48
 * @Hello-Idea
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailMapper mailMapper;
    @Transactional
    @DS(Contants.NEWGAMEDB)
    @Override
    public void insertYiban(List<Mail> mailList) {
        mailMapper.insertYiban(mailList);
    }
    @Transactional
    @DS(Contants.NEWGAMEDB)
    @Override
    public void insertQufu(Mail mail) {
        mailMapper.insertQufu(mail);
    }
}

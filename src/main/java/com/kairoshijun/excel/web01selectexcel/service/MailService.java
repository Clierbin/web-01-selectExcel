package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ClassName:MailService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/4/1
 * @Time:14:48
 * @Hello-Idea
 */
public interface MailService {
    void insertQufu(Mail mail);

    void insertYiban(List<Mail> mailList);
}

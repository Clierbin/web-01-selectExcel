package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.mapper.UmengMapper;
import com.kairoshijun.excel.web01selectexcel.service.UmengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * ClassName:UmengServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:11:11
 * @Hello-Idea
 */
@Service
public class UmengServiceImpl implements UmengService {
    @Autowired
    private UmengMapper umengMapper;
}

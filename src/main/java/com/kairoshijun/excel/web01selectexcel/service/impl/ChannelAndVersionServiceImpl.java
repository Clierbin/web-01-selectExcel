package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.ChannelAndVersionMapper;
import com.kairoshijun.excel.web01selectexcel.model.ChannelAndVersion;
import com.kairoshijun.excel.web01selectexcel.service.ChannelAndVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:ChannelAndVersionServiceImpl
 * Package:com.kairogame.select02.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:14:26
 * @Hello-Idea
 */
@Service
public class ChannelAndVersionServiceImpl implements ChannelAndVersionService {
    @Autowired
    private ChannelAndVersionMapper channelAndVersionMapper;
    @DS(Contants.NEWGAMEDB)
    @Override
    public List<ChannelAndVersion> getAll() {
        return channelAndVersionMapper.getAll();
    }
}

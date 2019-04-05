package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.databases.DatabaseContextHolder;
import com.kairoshijun.excel.web01selectexcel.mapper.ChannlMapper;
import com.kairoshijun.excel.web01selectexcel.model.Channl;
import com.kairoshijun.excel.web01selectexcel.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:ChannelServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:16:01
 * @Hello-Idea
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannlMapper channlMapper;
    @Override
    public List<Channl> getAll() {
        return channlMapper.selectAll();
    }
    @Transactional
    @Override
    public boolean insertChannel(Channl channl) {
        return channlMapper.insertSelective(channl)==1;
    }

    @Override
    public boolean checkChannelId(Integer channelId) {
        return channlMapper.checkChannelId(channelId)==0;
    }
}

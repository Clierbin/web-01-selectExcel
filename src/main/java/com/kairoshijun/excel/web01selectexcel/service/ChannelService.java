package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.Channl;

import java.util.List;

/**
 * ClassName:ChannelService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:16:01
 * @Hello-Idea
 */
public interface ChannelService {
    /**
     * 获取渠道List集合
     * @return List<Channl>
     */
    List<Channl> getAll();

    /**
     * 渠道添加数据时查询渠道Id是否重复  false 为已 存在
     * @param channelId
     * @return
     */
    boolean checkChannelId(Integer channelId);

    /**
     * 渠道添加数据  成功返回true
     * @param channl
     * @return
     */
    boolean insertChannel(Channl channl);
}

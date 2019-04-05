package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.mapper.*;
import com.kairoshijun.excel.web01selectexcel.model.*;
import com.kairoshijun.excel.web01selectexcel.service.FinalTableService;
import com.kairoshijun.excel.web01selectexcel.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ClassName:FinalTableServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 * version2.0: 新加'付费'字段为华为渠道盈利  每次遍历判断是否为华为渠道,不是为0,是去华为表查询金额
 * @author:zhangbin
 * @date:2019/3/22
 * @Time:12:01
 * @Hello-Idea
 */
@Service
public class FinalTableServiceImpl implements FinalTableService {
    @Autowired
    private FinaltableMapper finaltableMapper;
    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private ChannlMapper channlMapper;
    @Autowired
    private UmengMapper umengMapper;
    @Autowired
    private AdvertisementMapper advertisementMapper;
    @Autowired
    private HuaweipayMapper huaweipayMapper;
    Map<Integer,String> gameNameMap;
    Map<Integer,String> gameSeriesMap;
    Map<Integer,String> channelNameMap;
    //定时任务将数据统一插入到最终表
    @Transactional
    @Override
    public void insertTable(String time) {
        //先把游戏中的中文信息保存到map中
        List<Game> gameList=gameMapper.selectAll();
        Iterator<Game> iterator = gameList.iterator();
        while(iterator.hasNext()){
            Game game = iterator.next();
            //防止定时任务重新创建新的map
            if (gameNameMap==null) gameNameMap=new HashMap<>();
            if (gameSeriesMap==null) gameSeriesMap=new HashMap<>();
            //判断是否有新的游戏,有的话加入到map中
            if (gameNameMap.get(game.getGameid())==null) gameNameMap.put(game.getGameid(),game.getGame());
            if (gameSeriesMap.get(game.getGameid())==null) gameSeriesMap.put(game.getGameid(),game.getSeries());
        }
        //把渠道中的信息也放入到map中
        List<Channl> channlList=channlMapper.selectAll();
        Iterator<Channl> iterator1 = channlList.iterator();
        while (iterator1.hasNext()){
            Channl channl = iterator1.next();
            if (channelNameMap==null) channelNameMap=new HashMap<>();
            if (channelNameMap.get(channl.getChannelid())==null) channelNameMap.put(channl.getChannelid(),channl.getChannel());
        }
        //取得昨天所有的umeng数据
        String yesterdayString = TimeUtil.getYesterdayString();
        System.out.println("昨天时间: "+yesterdayString);
        //dev时使用
        //yesterdayString="2019-03-21";
        List<Umeng> umengList=umengMapper.selectByTime(time);
        Iterator<Umeng> iterator2 = umengList.iterator();
        List<Finaltable> flist=new ArrayList<>();
        while (iterator2.hasNext()){
            Umeng umeng = iterator2.next();
            Finaltable finaltable=new Finaltable();
            //可能为空
            String gameName = gameNameMap.get(umeng.getGameid());
            finaltable.setGame(gameName==null? String.valueOf(umeng.getGameid()): gameName);
            //可能为空
            String seriesName = gameSeriesMap.get(umeng.getGameid());
            finaltable.setSeries(seriesName==null ? String.valueOf(umeng.getGameid()) : seriesName);
            //可能为空
            //取得渠道ID
            Integer channlid = umeng.getChannlid();
            //如果渠道为华为,去华为表中找华为收益
            Double ngIncome=0.00;
            if (channlid==2300){
                ngIncome=huaweipayMapper.selectIncome(time,umeng.getGameid());
                if (ngIncome==null) ngIncome=0.00;
            }
            finaltable.setNgIncome(ngIncome);
            String channelName = channelNameMap.get(channlid);
            finaltable.setChannel(channelName==null ? String.valueOf(umeng.getChannlid()) : channelName);
            finaltable.setDateTime(umeng.getDatetime());
            //设置开屏收入 banner收入  视频收入 总收入
            Map<Object,Object> incomeMap=new HashMap<>();
            Date udate=umeng.getDatetime();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat1.format(udate);
            incomeMap.put("date",format);
            incomeMap.put(Contants.AD,Contants.KAIPING);
            incomeMap.put("gameId",umeng.getGameid());
            incomeMap.put("channel",umeng.getChannlid());
            Double sumIncome=0.00;
            BigDecimal sum = new BigDecimal(Double.toString(sumIncome));
            Double splashIncome=advertisementMapper.selectIncome(incomeMap);
            if (splashIncome==null) splashIncome=0.00;
            finaltable.setSplashIncome(splashIncome);
            incomeMap.put(Contants.AD,Contants.BANNER);
            Double bannerIncome=advertisementMapper.selectIncome(incomeMap);
            if (bannerIncome==null) bannerIncome=0.00;
            finaltable.setBannerIncome(bannerIncome);
            incomeMap.put(Contants.AD,Contants.VIDEO);
            Double videoIncome=advertisementMapper.selectIncome(incomeMap);
            if (videoIncome==null) videoIncome=0.00;
            finaltable.setVideoIncome(videoIncome);
            BigDecimal b1 = new BigDecimal(Double.toString(splashIncome));
            BigDecimal b2 = new BigDecimal(Double.toString(bannerIncome));
            BigDecimal b3 = new BigDecimal(Double.toString(videoIncome));
            BigDecimal b4 = new BigDecimal(Double.toString(ngIncome));
            double v = sum.add(b1).add(b2).add(b3).add(b4).doubleValue();
            finaltable.setSumIncome(v);
            finaltable.setNewNumber(umeng.getXinzeng());
            finaltable.setActive(umeng.getHuoyue());
            flist.add(finaltable);
            /*finaltableMapper.insertSelective(finaltable);*/

        }
        //通过定时任务添加数据
        System.out.println("数据开始添加!");
        finaltableMapper.insertByDSTime(flist);
        System.out.println("数据添加完成!");
    }
    //查询
    @Override
    public List<Finaltable> selectByTD(String[] channelSZ, String[] youxiSZ, String startTime, String endTime) {
        return finaltableMapper.selectByTD(channelSZ,youxiSZ,startTime,endTime);
    }



}

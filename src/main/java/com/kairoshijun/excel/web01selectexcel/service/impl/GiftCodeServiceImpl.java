package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.GiftCodeListMapper;
import com.kairoshijun.excel.web01selectexcel.mapper.GiftCodeMapper;
import com.kairoshijun.excel.web01selectexcel.model.GiftCode;
import com.kairoshijun.excel.web01selectexcel.model.GiftCodeList;
import com.kairoshijun.excel.web01selectexcel.service.GiftCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:GiftCodeServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/4/4
 * @Time:11:12
 * @Hello-Idea
 */
@Service
public class GiftCodeServiceImpl implements GiftCodeService {
    @Autowired
    private GiftCodeMapper giftCodeMapper;
    @Autowired
    private GiftCodeListMapper giftCodeListMapper;
    @Transactional
    @DS(Contants.NEWGAMEDB)
    @Override
    public List<GiftCode> insert(GiftCodeList giftCodeList) {
        //向list中添加一条数据
        int resultnum = giftCodeListMapper.insertSelective(giftCodeList);
        //查询list的id
        int giftCodeListID=giftCodeListMapper.selectBylist(giftCodeList);
        //更新gift_code的状态
        giftCodeMapper.updateBylist(giftCodeListID,giftCodeList.getGiftNum());
        //查询出List<GiftCode>
        List<GiftCode> giftCodes=giftCodeMapper.selectByList(giftCodeListID);
        return giftCodes;
    }
}

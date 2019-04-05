package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.GiftCode;
import com.kairoshijun.excel.web01selectexcel.model.GiftCodeList;

import java.util.List;


/**
 * ClassName:GiftCodeService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/4/4
 * @Time:11:11
 * @Hello-Idea
 */
public interface GiftCodeService {

    List<GiftCode> insert(GiftCodeList giftCodeList);
}

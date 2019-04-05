package com.kairoshijun.excel.web01selectexcel.service.impl;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import com.kairoshijun.excel.web01selectexcel.databases.DS;
import com.kairoshijun.excel.web01selectexcel.mapper.LipinmaListMapper;
import com.kairoshijun.excel.web01selectexcel.mapper.LipinmaMapper;
import com.kairoshijun.excel.web01selectexcel.model.Lipinma;
import com.kairoshijun.excel.web01selectexcel.model.LipinmaList;
import com.kairoshijun.excel.web01selectexcel.service.LipinmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:LipinmaServiceImpl
 * Package:com.kairoshijun.excel.web01selectexcel.service.impl
 * description
 *
 * @author:zhangbin
 * @date:2019/4/2
 * @Time:15:53
 * @Hello-Idea
 */
@Service
public class LipinmaServiceImpl implements LipinmaService {
    @Autowired
    private LipinmaMapper lipinmaMapper;
    @Autowired
    private LipinmaListMapper lipinmaListMapper;
    @DS(Contants.NEWGAMEDB)
    @Transactional
    @Override
    public List<Lipinma> insert(LipinmaList lipinmaList) {
        lipinmaListMapper.insertSelective(lipinmaList);
        int lipinmalistID=lipinmaListMapper.selectBylist(lipinmaList);
        lipinmaMapper.updateBylist(lipinmalistID,lipinmaList.getLpNum());
        List<Lipinma> lipinmas=lipinmaMapper.selectByList(lipinmalistID);
        return lipinmas;
    }
}

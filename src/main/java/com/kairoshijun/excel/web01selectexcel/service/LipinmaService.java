package com.kairoshijun.excel.web01selectexcel.service;

import com.kairoshijun.excel.web01selectexcel.model.Lipinma;
import com.kairoshijun.excel.web01selectexcel.model.LipinmaList;

import java.util.List;

/**
 * ClassName:LipinmaService
 * Package:com.kairoshijun.excel.web01selectexcel.service
 * description
 *
 * @author:zhangbin
 * @date:2019/4/2
 * @Time:15:53
 * @Hello-Idea
 */
public interface LipinmaService {
    List<Lipinma> insert(LipinmaList lipinmaList);
}

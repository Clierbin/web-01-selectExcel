package com.kairoshijun.excel.web01selectexcel.databases;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName:DynamicDataSource
 * Package:com.kairoshijun.excel.web01selectexcel.databases
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:17:41
 * @Hello-Idea
 *
 *
 *  动态数据源（需要继承AbstractRoutingDataSource）
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }
}

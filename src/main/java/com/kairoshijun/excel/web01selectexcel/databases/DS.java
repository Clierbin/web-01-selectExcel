package com.kairoshijun.excel.web01selectexcel.databases;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:DS
 * Package:com.kairoshijun.excel.web01selectexcel.databases
 * description
 *
 * @author:zhangbin
 * @date:2019/3/30
 * @Time:10:14
 * @Hello-Idea
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DS {
    String value() default Contants.ZZMPAYDB;
}

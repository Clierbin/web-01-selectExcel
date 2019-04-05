package com.kairoshijun.excel.web01selectexcel.databases;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * ClassName:DynamicDataSourceAspect
 * Package:com.kairoshijun.excel.web01selectexcel.databases
 * description
 *
 * @author:zhangbin
 * @date:2019/3/30
 * @Time:10:33
 * @Hello-Idea
 */
@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered {
    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point){
        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();
        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DatabaseContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 切换数据源
        DatabaseContextHolder.setDatabaseType(dataSource);
    }

    /**
     * 结束之后再贴换回默认的
     * @param point "@annotation(DS)"
     */
    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){
        DatabaseContextHolder.clearDB();
       // DatabaseContextHolder.setDatabaseType(DatabaseContextHolder.DEFAULT_DS);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

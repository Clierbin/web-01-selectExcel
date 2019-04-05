package com.kairoshijun.excel.web01selectexcel.databases;

import com.kairoshijun.excel.web01selectexcel.constants.Contants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * ClassName:MyBatisConfig
 * Package:com.kairoshijun.excel.web01selectexcel.databases
 * description
 *
 * @author:zhangbin
 * @date:2019/3/29
 * @Time:17:43
 * @Hello-Idea springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
@Configuration
@MapperScan(basePackages = "com.kairoshijun.excel.web01selectexcel.mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource zzmpayDbDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("zzmpay.jdbc.driverClassName"));
        props.put("url", env.getProperty("zzmpay.jdbc.url"));
        props.put("username", env.getProperty("zzmpay.jdbc.username"));
        props.put("password", env.getProperty("zzmpay.jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource newgameDb2DataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("new.game.jdbc2.driverClassName"));
        props.put("url", env.getProperty("new.game.jdbc2.url"));
        props.put("username", env.getProperty("new.game.jdbc2.username"));
        props.put("password", env.getProperty("new.game.jdbc2.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     *
     */
    @Bean
    @DependsOn({ "zzmpayDbDataSource", "newgameDb2DataSource"})
    @Primary
    public DynamicDataSource dataSource(@Qualifier("zzmpayDbDataSource") DataSource zzmpayDbDataSource,
                                        @Qualifier("newgameDb2DataSource") DataSource newgameDb2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(Contants.ZZMPAYDB, zzmpayDbDataSource);
        targetDataSources.put(Contants.NEWGAMEDB, newgameDb2DataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(zzmpayDbDataSource);// 默认的datasource设置为zzmpayDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
      /*  fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//
*/
        return fb.getObject();
    }

    /**
     * 配置事务管理器  多数据源开启事务
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}

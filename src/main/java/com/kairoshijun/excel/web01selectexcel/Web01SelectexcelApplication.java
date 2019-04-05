package com.kairoshijun.excel.web01selectexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement(order = 2)
public class Web01SelectexcelApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Web01SelectexcelApplication.class, args);
        //CreateFinlTableByTime finlTableByTime = context.getBean(CreateFinlTableByTime.class);
        //finlTableByTime.test();
    }

}

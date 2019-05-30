package com.xujiang.xujiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class XujiangApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(XujiangApplication.class, args);

//        context.addApplicationListener(new TestListener1());

//        context.publishEvent(new DictEvent("O(∩_∩)O哈哈~"));
    }

}

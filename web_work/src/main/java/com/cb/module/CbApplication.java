package com.cb.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: LinJH
 * @Date: 2020/11/13 19:22
 * @Version:0.0.1
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class CbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbApplication.class, args);
    }

}

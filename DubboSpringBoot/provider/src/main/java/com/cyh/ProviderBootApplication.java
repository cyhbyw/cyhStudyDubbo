package com.cyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * @author: CYH
 * @date: 2019/3/3 0003 9:59
 */
@SpringBootApplication
@EnableDubbo
public class ProviderBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBootApplication.class);
    }

}

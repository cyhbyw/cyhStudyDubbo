package com.dubbo.spi.demo.provider;

import java.time.LocalDateTime;
import java.util.Date;

import com.dubbo.spi.demo.api.IHelloService;

public class HelloService implements IHelloService {

    @Override
    public String hello(String name) {
        System.err.println("hello()..." + name + "  " + new Date());
        return "hello " + name + "  " + LocalDateTime.now();
    }
}

package com.cyh.service;

import java.time.LocalDateTime;

import com.cyh.api.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        String s = "Hello " + name + ". now: " + LocalDateTime.now();
        System.err.println(s);
        return s;
    }
}

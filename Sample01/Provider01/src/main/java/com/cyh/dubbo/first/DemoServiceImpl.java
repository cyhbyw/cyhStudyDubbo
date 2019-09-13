package com.cyh.dubbo.first;

import java.time.LocalDateTime;

/**
 * @author Administrator
 * @date 2018/1/25
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + "! now is " + LocalDateTime.now();
    }
}

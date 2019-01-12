package com.ricky.dubbo.provider.impl;

import java.util.Date;

import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.err.println("Invoking sayHello(). name=" + name);
        return "Hello " + name + "! now is " + new Date();
    }

    @Override
    public User findUserById(long id) {
        System.err.println("Invoking findUserById(). id=" + id);
        User user = new User();
        user.setId(id);
        user.setName("CYH");
        user.setAge(27);
        return user;
    }

}

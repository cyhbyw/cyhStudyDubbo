package com.ricky.dubbo.api;

import com.ricky.dubbo.api.model.User;

public interface DemoService {

    String sayHello(String name);

    User findUserById(long id);
}
package org.apache.dubbo.samples.http.impl;

import java.time.LocalDateTime;

import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.samples.http.api.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        String s = "Hello " + name + ". Request from consumer: " + RpcContext.getContext().getRemoteAddress()
                + ". Now: " + LocalDateTime.now();
        System.err.println(s);
        return s;
    }

}

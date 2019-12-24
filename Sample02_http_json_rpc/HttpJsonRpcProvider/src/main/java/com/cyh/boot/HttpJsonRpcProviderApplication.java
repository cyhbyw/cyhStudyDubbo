package com.cyh.boot;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpJsonRpcProviderApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("json_rpc_provider.xml");
        context.start();
        System.in.read();
    }

}

package com.cyh.dubbo.first;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @date 2018/1/25
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        System.err.println("demoService.getClass().getName(): " + demoService.getClass().getName());

        String hello = demoService.sayHello("world");
        System.err.println(hello);
    }
}

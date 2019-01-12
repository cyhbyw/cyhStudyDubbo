package com.ricky.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ricky.dubbo.api.DemoService;
import com.ricky.dubbo.api.model.User;

/**
 * Dubbo Consumer client
 */
public class ConsumerApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        System.err.println("demoService.getClass().getName(): " + demoService.getClass().getName());

        String hello = demoService.sayHello("CYH");
        System.err.println(hello);

        User user = demoService.findUserById(15);
        System.err.println(user);

    }
}

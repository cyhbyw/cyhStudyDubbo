package com.cyh;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: CYH
 * @date: 2019/9/13 0013 9:52
 */
public class ExceptionProvider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("exception-provider.xml");
        context.start();
        System.in.read();
    }

}

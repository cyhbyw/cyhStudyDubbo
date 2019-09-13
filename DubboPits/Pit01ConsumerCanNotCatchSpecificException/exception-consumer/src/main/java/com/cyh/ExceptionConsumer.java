package com.cyh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: CYH
 * @date: 2019/9/13 0013 9:59
 */
public class ExceptionConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("exception-consumer.xml");
        context.start();
        ExceptionDemoService service = (ExceptionDemoService) context.getBean("demoService");
        try {
            service.testException();
        } catch (DemoException e) {
            // 这里捕获不到
            System.err.println("case01::客户端捕获到了DemoException");
            e.printStackTrace();
        } catch (RuntimeException e) {
            // 实际上会到达这里
            System.err.println("case02::客户端捕获到了RuntimeException");
            e.printStackTrace();
        }
        context.close();
    }

}

package com.cyh;

import java.time.LocalDateTime;

/**
 * @author: CYH
 * @date: 2019/9/13 0013 9:52
 */
public class ExceptionDemoServiceImpl implements ExceptionDemoService {

    @Override
    public void testException() {
        System.err.println("服务端收到请求，时间是：" + LocalDateTime.now());
        throw new DemoException("服务端执行任务过程中抛出了异常");
    }
}

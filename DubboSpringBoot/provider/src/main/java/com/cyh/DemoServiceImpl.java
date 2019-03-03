package com.cyh;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author: CYH
 * @date: 2019/3/3 0003 10:07
 */
@Component
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String service(String name) {
        LocalDateTime now = LocalDateTime.now();
        System.err.println(now + "  收到请求，来自于 " + name);
        return "Hello " + name + "!   " + now;
    }
}

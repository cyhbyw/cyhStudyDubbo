package org.apache.dubbo.samples.http;

import org.apache.dubbo.samples.http.api.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/http-consumer.xml"})
public class DemoServiceIT {
    @Autowired
    private DemoService demoService;

    @Test
    public void test1() {
        Assert.assertTrue(demoService.sayHello("world").contains("Hello world"));
    }

    @Test
    public void test2() {
        boolean isFromTomcat = false;
        boolean isFromJetty = false;
        for (int i = 0; i < 10; i++) {
            String result = demoService.sayHello("world");
            if (result.contains("8080")) {
                isFromTomcat = true;
            }
            if (result.contains("8081")) {
                isFromJetty = true;
            }
        }
        Assert.assertTrue(isFromJetty && isFromTomcat);
    }
}

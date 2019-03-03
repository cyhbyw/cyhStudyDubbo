package com.cyh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author: CYH
 * @date: 2019/3/3 0003 10:17
 */
@RestController
public class DemoController {

    @Reference
    private DemoService demoService;

    @GetMapping("/demo")
    public String demo() {
        return demoService.service("cyh_20190303");
    }

}

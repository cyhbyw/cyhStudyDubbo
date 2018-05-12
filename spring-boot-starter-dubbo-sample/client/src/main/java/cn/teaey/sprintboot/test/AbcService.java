package cn.teaey.sprintboot.test;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Component
public class AbcService {

    @Reference(version = "1.0.0")
    public EchoService echoService;
}

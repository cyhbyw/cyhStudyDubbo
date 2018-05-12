package cn.teaey.sprintboot.test;

import java.util.Date;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Service(version = "1.0.0")
public class EchoServerImpl implements EchoService {

    @Override
    public String echo(String str) {
        System.out.println(str + " " + new Date());
        return str;
    }
}

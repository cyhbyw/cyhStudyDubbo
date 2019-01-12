package com.cyh;

import org.junit.Test;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 18:03
 */
public class DubboSpiTest {

    @Test
    public void sayHello() {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }

}

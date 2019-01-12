package com.cyh;

import java.util.ServiceLoader;

import org.junit.Test;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 17:59
 */
public class JavaSpiTest {

    @Test
    public void sayHello() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }

}

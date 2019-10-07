package com.cyh;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 17:54
 */
@SPI
public interface Robot {
    void sayHello();
}

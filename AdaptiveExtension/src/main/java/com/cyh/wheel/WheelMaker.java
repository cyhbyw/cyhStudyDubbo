package com.cyh.wheel;

import org.apache.dubbo.common.extension.SPI;

import com.alibaba.dubbo.common.URL;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 20:34
 */
@SPI
public interface WheelMaker {

    Wheel makeWheel(URL url);

}

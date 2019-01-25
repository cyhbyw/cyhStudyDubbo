package com.cyh.wheel;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 20:34
 */
@SPI
public interface WheelMaker {

    Wheel makeWheel(URL url);

}

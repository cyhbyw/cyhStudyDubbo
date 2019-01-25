package com.cyh.wheel;

import com.alibaba.dubbo.common.URL;

/**
 * @author: CYH
 * @date: 2019/1/23 0023 7:59
 */
public class MichelinWheelMaker implements WheelMaker {

    @Override
    public Wheel makeWheel(URL url) {
        System.err.println("MichelinWheelMaker.makeWheel()...");
        return null;
    }
}

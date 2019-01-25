package com.cyh.car;

import com.alibaba.dubbo.common.URL;
import com.cyh.wheel.Wheel;
import com.cyh.wheel.WheelMaker;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 20:38
 */
public class RaceCarMaker implements CarMaker {

    private WheelMaker wheelMaker;

    /**
     * 通过 setter 注入 AdaptiveWheelMaker
     * @param wheelMaker
     */
    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }

    @Override
    public Car makeCar(URL url) {
        Wheel wheel = wheelMaker.makeWheel(url);
        return new RaceCar(wheel);
    }
}

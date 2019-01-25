package com.cyh.car;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.common.URL;
import com.cyh.wheel.AdaptiveWheelMaker;

/**
 * @author: CYH
 * @date: 2019/1/23 0023 8:01
 */
public class RaceCarMakerTest {

    public static void main(String[] args) {
        new RaceCarMakerTest().run();
    }

    private void run() {
        RaceCarMaker raceCarMaker = new RaceCarMaker();
        raceCarMaker.setWheelMaker(new AdaptiveWheelMaker());
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("wheel.maker", "michelinWheelMaker");
        raceCarMaker.makeCar(new URL(null, null, 0, map));
    }

}

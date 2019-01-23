package com.cyh.car;

import com.alibaba.dubbo.common.URL;
import com.cyh.car.Car;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 20:37
 */
public interface CarMaker {

    Car makeCar(URL url);

}

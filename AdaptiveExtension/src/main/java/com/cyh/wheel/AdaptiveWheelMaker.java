package com.cyh.wheel;

import org.apache.dubbo.common.extension.ExtensionLoader;

import com.alibaba.dubbo.common.URL;

/**
 * @author: CYH
 * @date: 2019/1/12 0012 20:34
 */
public class AdaptiveWheelMaker implements WheelMaker {

    @Override
    public Wheel makeWheel(URL url) {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }

        // 1. 从 URL 中获取 WheelMaker 名称
        String wheelMakerName = url.getParameter("wheel.maker");
        if (wheelMakerName == null) {
            throw new IllegalArgumentException("wheelMakerName == null");
        }

        // 2. 通过 SPI 加载具体的 WheelMaker
        WheelMaker wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getExtension(wheelMakerName);

        // 3. 调用目标方法
        return wheelMaker.makeWheel(url);
    }
}

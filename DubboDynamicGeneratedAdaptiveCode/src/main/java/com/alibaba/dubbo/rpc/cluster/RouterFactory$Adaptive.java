package com.alibaba.dubbo.rpc.cluster;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class RouterFactory$Adaptive implements RouterFactory {

    @Override
    public Router getRouter(URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        String extName = url.getProtocol();
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(RouterFactory) name from url(" + url.toString() + ") use keys([protocol])");
        }
        RouterFactory extension = ExtensionLoader.getExtensionLoader(RouterFactory.class).getExtension(extName);
        return extension.getRouter(arg0);
    }
}

package com.alibaba.dubbo.cache;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Invocation;

public class CacheFactory$Adaptive implements CacheFactory {

    @Override
    public Cache getCache(URL arg0, Invocation arg1) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        if (arg1 == null) {
            throw new IllegalArgumentException("invocation == null");
        }
        String methodName = arg1.getMethodName();
        String extName = url.getMethodParameter(methodName, "cache", "lru");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(CacheFactory) name from url(" + url.toString() + ") use keys([cache])");
        }
        CacheFactory extension = ExtensionLoader.getExtensionLoader(CacheFactory.class).getExtension(extName);
        return extension.getCache(arg0, arg1);
    }
}

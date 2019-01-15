package com.alibaba.dubbo.common.threadpool;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ThreadPool$Adaptive implements ThreadPool {

    @Override
    public java.util.concurrent.Executor getExecutor(URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        String extName = url.getParameter("threadpool", "fixed");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(ThreadPool) name from url(" + url.toString() + ") use keys([threadpool])");
        }
        ThreadPool extension = ExtensionLoader.getExtensionLoader(ThreadPool.class).getExtension(extName);
        return extension.getExecutor(arg0);
    }
}

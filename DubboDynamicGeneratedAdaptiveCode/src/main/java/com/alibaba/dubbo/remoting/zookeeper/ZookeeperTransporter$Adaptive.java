package com.alibaba.dubbo.remoting.zookeeper;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ZookeeperTransporter$Adaptive implements ZookeeperTransporter {

    @Override
    public ZookeeperClient connect(URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        String extName = url.getParameter("client", url.getParameter("transporter", "curator"));
        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(ZookeeperTransporter) name from url("
                    + url.toString() + ") use keys([client, transporter])");
        }
        ZookeeperTransporter extension =
                ExtensionLoader.getExtensionLoader(ZookeeperTransporter.class).getExtension(extName);
        return extension.connect(arg0);
    }
}

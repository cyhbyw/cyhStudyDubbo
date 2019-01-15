package com.alibaba.dubbo.rpc.cluster;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;

public class Cluster$Adaptive implements Cluster {

    @Override
    public Invoker join(Directory arg0) throws RpcException {
        if (arg0 == null) {
            throw new IllegalArgumentException("Directory argument == null");
        }
        if (arg0.getUrl() == null) {
            throw new IllegalArgumentException("Directory argument getUrl() == null");
        }
        URL url = arg0.getUrl();
        String extName = url.getParameter("cluster", "failover");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(Cluster) name from url(" + url.toString() + ") use keys([cluster])");
        }
        Cluster extension = ExtensionLoader.getExtensionLoader(Cluster.class).getExtension(extName);
        return extension.join(arg0);
    }
}

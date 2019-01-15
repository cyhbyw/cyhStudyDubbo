package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author: CYH
 * @date: 2019/1/15 0015 8:48
 */
public class Protocol$Adaptive implements Protocol {

    @Override
    public void destroy() {
        throw new UnsupportedOperationException(
                "method public abstract void Protocol.destroy() of interface Protocol is not adaptive method!");
    }

    @Override
    public int getDefaultPort() {
        throw new UnsupportedOperationException(
                "method public abstract int Protocol.getDefaultPort() of interface Protocol is not adaptive method!");
    }

    @Override
    public Invoker refer(java.lang.Class arg0, URL arg1) throws RpcException {
        if (arg1 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg1;
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(Protocol) name from url(" + url.toString() + ") use keys([protocol])");
        }
        Protocol extension = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);
        return extension.refer(arg0, arg1);
    }

    @Override
    public Exporter export(Invoker arg0) throws RpcException {
        if (arg0 == null) {
            throw new IllegalArgumentException("Invoker argument == null");
        }
        if (arg0.getUrl() == null) {
            throw new IllegalArgumentException("Invoker argument getUrl() == null");
        }
        URL url = arg0.getUrl();
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(Protocol) name from url(" + url.toString() + ") use keys([protocol])");
        }
        Protocol extension = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension(extName);
        return extension.export(arg0);
    }
}


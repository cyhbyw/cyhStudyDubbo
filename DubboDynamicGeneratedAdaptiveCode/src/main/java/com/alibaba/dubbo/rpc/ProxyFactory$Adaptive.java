package com.alibaba.dubbo.rpc;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ProxyFactory$Adaptive implements ProxyFactory {

    @Override
    public java.lang.Object getProxy(Invoker arg0) throws RpcException {
        if (arg0 == null) {
            throw new IllegalArgumentException("Invoker argument == null");
        }
        if (arg0.getUrl() == null) {
            throw new IllegalArgumentException("Invoker argument getUrl() == null");
        }
        URL url = arg0.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        }
        ProxyFactory extension = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(arg0);
    }

    @Override
    public java.lang.Object getProxy(Invoker arg0, boolean arg1) throws RpcException {
        if (arg0 == null) {
            throw new IllegalArgumentException("Invoker argument == null");
        }
        if (arg0.getUrl() == null) {
            throw new IllegalArgumentException("Invoker argument getUrl() == null");
        }
        URL url = arg0.getUrl();
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        }
        ProxyFactory extension = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getProxy(arg0, arg1);
    }

    @Override
    public Invoker getInvoker(java.lang.Object arg0, java.lang.Class arg1, URL arg2) throws RpcException {
        if (arg2 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg2;
        String extName = url.getParameter("proxy", "javassist");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(ProxyFactory) name from url(" + url.toString() + ") use keys([proxy])");
        }
        ProxyFactory extension = ExtensionLoader.getExtensionLoader(ProxyFactory.class).getExtension(extName);
        return extension.getInvoker(arg0, arg1, arg2);
    }
}

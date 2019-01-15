package com.alibaba.dubbo.rpc.cluster;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class ConfiguratorFactory$Adaptive implements ConfiguratorFactory {

    @Override
    public Configurator getConfigurator(URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        String extName = url.getProtocol();
        if (extName == null) {
            throw new IllegalStateException("Fail to get extension(ConfiguratorFactory) name from url(" + url.toString()
                    + ") use keys([protocol])");
        }
        ConfiguratorFactory extension =
                ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class).getExtension(extName);
        return extension.getConfigurator(arg0);
    }
}

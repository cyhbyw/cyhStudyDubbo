package com.alibaba.dubbo.validation;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class Validation$Adaptive implements Validation {

    @Override
    public Validator getValidator(URL arg0) {
        if (arg0 == null) {
            throw new IllegalArgumentException("url == null");
        }
        URL url = arg0;
        String extName = url.getParameter("validation", "jvalidation");
        if (extName == null) {
            throw new IllegalStateException(
                    "Fail to get extension(Validation) name from url(" + url.toString() + ") use keys([validation])");
        }
        Validation extension = ExtensionLoader.getExtensionLoader(Validation.class).getExtension(extName);
        return extension.getValidator(arg0);
    }
}

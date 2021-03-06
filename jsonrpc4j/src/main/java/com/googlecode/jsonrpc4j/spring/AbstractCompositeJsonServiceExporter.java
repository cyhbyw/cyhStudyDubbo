/*
The MIT License (MIT)

Copyright (c) 2014 jsonrpc4j

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.googlecode.jsonrpc4j.spring;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.ErrorResolver;
import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.ProxyUtil;

/**
 * Abstract class for exposing composite services via spring.
 *
 */
public abstract class AbstractCompositeJsonServiceExporter implements InitializingBean, ApplicationContextAware {

    private ObjectMapper objectMapper;
    private ApplicationContext applicationContext;
    private ErrorResolver errorResolver = null;
    private boolean backwardsComaptible = true;
    private boolean rethrowExceptions = false;
    private boolean allowExtraParams = false;
    private boolean allowLessParams = false;

    private JsonRpcServer jsonRpcServer;

    private boolean allowMultipleInheritance = false;
    private Class<?>[] serviceInterfaces = null;
    private Object[] services = new Object[0];

    /**
     * Called when the service is ready to be exported.
     * @throws Exception on error
     */
    protected void exportService() throws Exception {
        // no-op
    }

    /**
     * {@inheritDoc}
     */
    public final void afterPropertiesSet() throws Exception {

        // find the ObjectMapper
        if (objectMapper == null && applicationContext != null && applicationContext.containsBean("objectMapper")) {
            objectMapper = (ObjectMapper) applicationContext.getBean("objectMapper");
        }
        if (objectMapper == null && applicationContext != null) {
            try {
                objectMapper = (ObjectMapper) BeanFactoryUtils.beanOfTypeIncludingAncestors(applicationContext,
                        ObjectMapper.class);
            } catch (Exception e) {
                /* no-op */ }
        }
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        // create the service
        Object service = ProxyUtil.createCompositeServiceProxy(getClass().getClassLoader(), services, serviceInterfaces,
                allowMultipleInheritance);

        // create the server
        jsonRpcServer = new JsonRpcServer(objectMapper, service);
        jsonRpcServer.setErrorResolver(errorResolver);
        jsonRpcServer.setBackwardsComaptible(backwardsComaptible);
        jsonRpcServer.setRethrowExceptions(rethrowExceptions);
        jsonRpcServer.setAllowExtraParams(allowExtraParams);
        jsonRpcServer.setAllowLessParams(allowLessParams);

        // export
        exportService();
    }

    /**
     * @return the jsonRpcServer
     */
    protected JsonRpcServer getJsonRpcServer() {
        return jsonRpcServer;
    }

    /**
     * @param objectMapper the objectMapper to set
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * @param applicationContext the applicationContext to set
     */
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * @param errorResolver the errorResolver to set
     */
    public void setErrorResolver(ErrorResolver errorResolver) {
        this.errorResolver = errorResolver;
    }

    /**
     * @param backwardsComaptible the backwardsComaptible to set
     */
    public void setBackwardsComaptible(boolean backwardsComaptible) {
        this.backwardsComaptible = backwardsComaptible;
    }

    /**
     * @param allowExtraParams the allowExtraParams to set
     */
    public void setAllowExtraParams(boolean allowExtraParams) {
        this.allowExtraParams = allowExtraParams;
    }

    /**
     * @param allowLessParams the allowLessParams to set
     */
    public void setAllowLessParams(boolean allowLessParams) {
        this.allowLessParams = allowLessParams;
    }

    /**
     * @param allowMultipleInheritance the allowMultipleInheritance to set
     */
    public void setAllowMultipleInheritance(boolean allowMultipleInheritance) {
        this.allowMultipleInheritance = allowMultipleInheritance;
    }

    /**
     * @param serviceInterfaces the serviceInterfaces to set
     */
    public void setServiceInterfaces(Class<?>[] serviceInterfaces) {
        this.serviceInterfaces = serviceInterfaces;
    }

    /**
     * @param services the services to set
     */
    public void setServices(Object[] services) {
        this.services = services;
    }

}

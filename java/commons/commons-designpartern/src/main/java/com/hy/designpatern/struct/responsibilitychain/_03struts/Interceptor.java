package com.hy.designpatern.struct.responsibilitychain._03struts;
public interface Interceptor{
 
    void destroy();

    void init();

    String intercept(ActionInvocation invocation) throws Exception;

}
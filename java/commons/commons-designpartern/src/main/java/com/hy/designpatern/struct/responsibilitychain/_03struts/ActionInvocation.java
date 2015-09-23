package com.hy.designpatern.struct.responsibilitychain._03struts;
public interface ActionInvocation{

    Object getAction();
    boolean isExecuted();
    Result getResult() throws Exception;
    String getResultCode();
    void setResultCode(String resultCode);
    String invoke() throws Exception;
    String invokeActionOnly() throws Exception;
}
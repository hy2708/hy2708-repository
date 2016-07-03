package com.hy.designpatern.struct.responsibilitychain._03struts;
public interface Result {
  
    public void execute(ActionInvocation invocation) throws Exception;

}
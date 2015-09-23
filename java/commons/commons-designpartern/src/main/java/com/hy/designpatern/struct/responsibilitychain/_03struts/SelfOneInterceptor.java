package com.hy.designpatern.struct.responsibilitychain._03struts;
public class SelfOneInterceptor extends AbstractInterceptor {
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
		String result = null ;  	
    	System.out.println("intercept SelfOneInterceptor before aop");		
		result = invocation.invoke(); 		
		System.out.println("intercept SelfOneInterceptor after aop");
		return result; 
    }  
}
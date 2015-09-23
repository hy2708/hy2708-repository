package com.hy.designpatern.dynamicproxy.aopproxy.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("myAroundInterceptor")
public class MyAroundInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object proxyedObject = invocation.getThis();
		String targetName = proxyedObject.getClass().getName();
		Method method = invocation.getMethod();
		System.err.println(proxyedObject);
		System.err.println(proxyedObject.getClass());
		System.err.println(proxyedObject.getClass().getName());

		
		
		System.out.println(this.getClass().getSimpleName() 
				+ "处理的被代理对象的类名称【" + proxyedObject.getClass().getSimpleName()  + "】");
		System.out.println("在被代理对象【" + proxyedObject + "】的方法【" + method.toString()
				+ "】之前执行");
		System.out.println(this.getClass().getSimpleName() + "在执行");
		System.out.println(this.getClass().getSimpleName() + "在执行结束");

		String xx = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		Object result;

		// call target/sub-interceptor
		result = invocation.proceed();

		System.out.println("在被代理对象【" + proxyedObject + "】的方法【" + method
				+ "】之后执行，方法返回值，为【" + result + "】");
		System.out.println(this.getClass().getSimpleName() + "在执行");
		System.out.println(this.getClass().getSimpleName() + "在执行结束");
		return result;
	}

}

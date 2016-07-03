package com.hy.designpatern.dynamicproxy.aopproxy.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component("myAfterAdvice")
public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method arg1, Object[] arg2,
			Object proxyedObject) throws Throwable {
		Class<? extends Object> clazz = proxyedObject.getClass();
		String className = proxyedObject.getClass().getName();
		String methodName = arg1.getName();

		System.out.println("在被代理对象【" +
				proxyedObject+"】的方法【" +
				arg1+"】之后执行，方法返回值，为【" +
						returnValue+"】");
		System.out.println(this.getClass().getSimpleName()+"在执行");
		System.out.println(this.getClass().getSimpleName()+"在执行结束");

	}

}

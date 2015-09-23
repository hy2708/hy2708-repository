package com.hy.designpatern.dynamicproxy.aopproxy.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("myBeforeAdvice")
public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object proxyedObject)
			throws Throwable {
		System.out.println("在被代理对象【" +
				proxyedObject+"】的方法【" +
						arg0+"】之前执行");
		System.out.println(this.getClass().getSimpleName()+"在执行");
		System.out.println(this.getClass().getSimpleName()+"在执行结束");
		
	}

}

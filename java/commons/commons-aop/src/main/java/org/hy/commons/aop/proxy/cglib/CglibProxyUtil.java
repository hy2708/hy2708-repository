package org.hy.commons.aop.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.hy.commons.lang.ClassUtil;

public class CglibProxyUtil {
	
	public static Object getProxy(Object beProxiedObject,String methodName,Class functionObject,
			String functionMethodName, Object[] functionArgs) {
		MethodInterceptor handler = new MyInvocationHandler(beProxiedObject,methodName,functionObject,functionMethodName,functionArgs);
		Enhancer enhancer = new Enhancer();
		//设置被代理类，为代理类的父类
		enhancer.setSuperclass(beProxiedObject.getClass());
		//设置拦截器，为回调函数
		enhancer.setCallback(handler);
		return enhancer.create();
	}

	public static void main(String[] args) {
		
	}
}

class MyInvocationHandler implements MethodInterceptor{

	public MyInvocationHandler(Object beProxiedObject,String methodName, Class functionObject,
			String functionMethodName, Object[] functionArgs) {
		super();
		this.beProxiedObject = beProxiedObject;
		this.methodName = methodName;
		this.functionObject = functionObject;
		this.functionMethodName = functionMethodName;
		this.functionArgs = functionArgs;
	}


	/*public MyInvocationHandler() {
		super();
	}*/

	Object beProxiedObject = null;
	String methodName =null;
	Class<?> functionObject = null;
	String functionMethodName = null;
	Object[] functionArgs = null;
	
	
	public MyInvocationHandler(Object beProxiedObject) {
		super();
		this.beProxiedObject = beProxiedObject;
	}


	//@Override
	public Object invoke(Object proxyObject, Method method, Object[] args)
			throws Throwable {
		Object returnObject = null;

		if (functionObject!=null) {
			Method method2 =ClassUtil.findMethod(functionObject, functionMethodName, functionArgs);
			if (method.getName().equals(methodName)) {				
				method2.invoke(functionObject.newInstance(), functionArgs);
			}
		}
		returnObject = method.invoke(beProxiedObject, args);
		return returnObject;
	}


	@Override
	public Object intercept(Object proxyObject, Method method, Object[] args,
			MethodProxy arg3) throws Throwable {
		
		return invoke(proxyObject, method, args);
	}
	
}

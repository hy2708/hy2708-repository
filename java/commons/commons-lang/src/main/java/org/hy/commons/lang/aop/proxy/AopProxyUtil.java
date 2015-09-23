package org.hy.commons.lang.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.util.List;

import org.hy.commons.lang.reflect.ProxyUtil;

@Deprecated
public class AopProxyUtil extends ProxyUtil{

	public static <T>T getProxy(Object beProxiedObject,List<Advice> advices) {
		return (T)getProxy(beProxiedObject, advices.toArray(new Advice[advices.size()]));
	}
	public static <T>T getProxy(Object beProxiedObject,Advice[] advices) {
		InvocationHandler handler = new AopInvocationHandler(beProxiedObject,advices);
		
		return (T)getProxy(beProxiedObject, handler);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-1-5；时间：下午2:56:18</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param beProxiedObject 被代理对象
	 * @param methodName     该被代理对象的方法名
	 * @param functionObject  
	 * @param functionMethodName
	 * @param functionArgs
	 * @return
	 */
	public static Object getProxy(Object beProxiedObject,String methodName,Class functionObject,
			String functionMethodName, Object[] functionArgs) {
		InvocationHandler handler = null;//new MyInvocationHandler(beProxiedObject,methodName,functionObject,functionMethodName,functionArgs);
		return getProxy(beProxiedObject, handler);
	}
	

	

}

/*class MyInvocationHandler implements InvocationHandler{

	public MyInvocationHandler(Object beProxiedObject,String methodName, Class functionObject,
			String functionMethodName, Object[] functionArgs) {
		super();
		this.beProxiedObject = beProxiedObject;
		this.methodName = methodName;
		this.functionObject = functionObject;
		this.functionMethodName = functionMethodName;
		this.functionArgs = functionArgs;
	}


	public MyInvocationHandler() {
		super();
	}

	Object beProxiedObject = null;
	String methodName =null;
	Class<?> functionObject = null;
	String functionMethodName = null;
	Object[] functionArgs = null;
	
	
	public MyInvocationHandler(Object beProxiedObject) {
		super();
		this.beProxiedObject = beProxiedObject;
	}


	@Override
	public Object invoke(Object proxyObject, Method method, Object[] args)
			throws Throwable {
		Object returnObject = null;

		if (functionObject!=null) {
			Method method2 = ClassUtil.findMethod(functionObject, functionMethodName, functionArgs);
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof JoinPoint) {
					throw new RuntimeException();
				}
			}
			if (method.getName().equals(methodName)) {				
				method2.invoke(functionObject.newInstance(), functionArgs);
			}
		}
		returnObject = method.invoke(beProxiedObject, args);
		return returnObject;
	}
	
}*/
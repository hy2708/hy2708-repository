package org.hy.commons.aop.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.hy.commons.aop.advice.Advice;
import org.hy.commons.aop.advice.AfterAdvice;
import org.hy.commons.aop.advice.AroundAdvice;
import org.hy.commons.aop.advice.BeforeAdvice;
import org.hy.commons.aop.advice.ExceptionAdvice;
import org.hy.commons.lang.ClassUtil;
import org.hy.commons.lang.reflect.ProxyUtil;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2015-2-11；时间：下午5:07:26</li>
 * <li>类型名称：AopProxyUtil</li>
 * <li>设计目的：产生目标对象（被代理对象）的代理对象，对目标对象的方法，进行增强<br/>
 * 有两种使用方式1、通过设置pointcut（aspectJ）和advice产生代理，pointcut（aspectJ）和advice成对配置。
 * 2、通过指定目标对象及其目标方法，和advice产生代理。
 * </li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */

public class AopProxyUtil extends ProxyUtil{

	/*
	List<AroundAdvice> aroundAdvices = new LinkedList<AroundAdvice>(); 
	List<BeforeAdvice> beforeAdvices = new LinkedList<BeforeAdvice>(); 
	List<AfterAdvice> afterAdvices = new LinkedList<AfterAdvice>(); 
	*/
	List<PointcutAndAdvice> befores = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> afters = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> arounds = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> exceptions = new LinkedList<PointcutAndAdvice>(); 

	public void addPointcutAndAdvice(PointcutAndAdvice paa) {
		if (paa.getAdvice() instanceof AroundAdvice) {
			arounds.add(paa);
			//((AroundAdvice)advice).aroundMethod((ProceedingJoinPoint)joinPoint);
		}else if (paa.getAdvice() instanceof BeforeAdvice) {
			befores.add(paa);
			//advice.beforeMethod(joinPoint);
			//returnObject = method.invoke(beProxiedObject, args);
		}else if (paa.getAdvice() instanceof AfterAdvice) {
			afters.add(paa);
			//advice.afterMethod(joinPoint);
			//returnObject = method.invoke(beProxiedObject, args);
		}else if (paa.getAdvice() instanceof ExceptionAdvice) {
			exceptions.add(paa);
			//advice.afterMethod(joinPoint);
			//returnObject = method.invoke(beProxiedObject, args);
		}

	}
	
	@Deprecated
	public void addAdvice(Advice advice) {
		if (advice instanceof AroundAdvice) {
			//aroundAdvices.add((AroundAdvice)advice);
			//((AroundAdvice)advice).aroundMethod((ProceedingJoinPoint)joinPoint);
		}else if (advice instanceof BeforeAdvice) {
			//beforeAdvices.add((BeforeAdvice)advice);
			//advice.beforeMethod(joinPoint);
			//returnObject = method.invoke(beProxiedObject, args);
		}else if (advice instanceof AfterAdvice) {
			//afterAdvices.add((AfterAdvice)advice);
			//advice.afterMethod(joinPoint);
			//returnObject = method.invoke(beProxiedObject, args);
		}

	}
	
	@Deprecated
	private void arrangeAdvices(List<AroundAdvice> aroundAdvices,
			List<BeforeAdvice> beforeAdvices, List<AfterAdvice> afterAdvices) {
		for (Advice advice : aroundAdvices) {
			if (advice instanceof AroundAdvice) {
				aroundAdvices.add((AroundAdvice)advice);
				//((AroundAdvice)advice).aroundMethod((ProceedingJoinPoint)joinPoint);
			}else if (advice instanceof BeforeAdvice) {
				beforeAdvices.add((BeforeAdvice)advice);
				//advice.beforeMethod(joinPoint);
				//returnObject = method.invoke(beProxiedObject, args);
			}else if (advice instanceof AfterAdvice) {
				afterAdvices.add((AfterAdvice)advice);
				//advice.afterMethod(joinPoint);
				//returnObject = method.invoke(beProxiedObject, args);
			}
			
		}
	}
	
	public  <T>T getAopProxy(Object beProxiedObject) {
		InvocationHandler handler = new AopInvocationHandler(beProxiedObject,befores,afters,arounds,exceptions);

		return (T)getProxy(beProxiedObject, handler);
	}
	
	public static <T>T getProxy(Object beProxiedObject,List<Advice> advices) {
		return getProxy(beProxiedObject, advices.toArray(new Advice[advices.size()]));
	}
	public static <T>T getProxy(Object beProxiedObject,Advice[] advices) {
		InvocationHandler handler = new AopInvocationHandler(beProxiedObject,advices);
		return (T)getProxy(beProxiedObject, handler);
	}
	
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
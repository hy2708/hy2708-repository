package org.hy.commons.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.lang.Aspects;
import org.aspectj.lang.annotation.Aspect;
import org.hy.commons.aop.advice.Advice;
import org.hy.commons.aop.advice.ExceptionAdvice;
import org.hy.commons.lang.CollectionUtil;

 class AopInvocationHandler implements InvocationHandler{

	List<PointcutAndAdvice> befores = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> afters = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> arounds = new LinkedList<PointcutAndAdvice>(); 
	List<PointcutAndAdvice> exceptions = new LinkedList<PointcutAndAdvice>(); 

	public AopInvocationHandler(Object beProxiedObject, Advice[] advices) {
		super();
		this.beProxiedObject = beProxiedObject;		
		this.advices = advices;
	}


	/*public AopInvocationHandler() {
		super();
	}*/

	Object beProxiedObject = null;
	//String methodName =null;
	//Class<?> functionObject = null;
	//String functionMethodName = null;
	Advice[] advices = null;
	
	
	public AopInvocationHandler(Object beProxiedObject) {
		super();
		this.beProxiedObject = beProxiedObject;
	}


	public AopInvocationHandler(Object beProxiedObject,
			List<PointcutAndAdvice> befores, List<PointcutAndAdvice> afters,
			List<PointcutAndAdvice> arounds,List<PointcutAndAdvice> exceptions) {
		this.beProxiedObject = beProxiedObject;
		this.befores=befores;
		this.afters=afters;
		this.arounds=arounds;
		this.exceptions=exceptions;
	}


	@Override
	public Object invoke(Object proxyObject, Method method, Object[] args)
			 {
		Object returnObject = null;
		
		//ProceedingJoinPoint joinPoint = new ProceedingJoinPointImpl(beProxiedObject,method,args);
		JoinPoint joinPoint = new JoinPointImpl(beProxiedObject,method,args);
		
		//List<AroundAdvice> aroundAdvices = new LinkedList<AroundAdvice>(); 
		//List<BeforeAdvice> beforeAdvices = new LinkedList<BeforeAdvice>(); 
		//List<AfterAdvice> afterAdvices = new LinkedList<AfterAdvice>(); 
		
		//arrangeAdvices(aroundAdvices, beforeAdvices, afterAdvices);
		/*
		 * 是否对目标对象的目标方法捕获异常
		 */
		Boolean isCatchException = false;
		for (PointcutAndAdvice exception : exceptions) {
			isCatchException =PointcutUtil.match(exception.getPointcut().getExpression(), beProxiedObject.getClass(), method);
			Boolean isMatch =PointcutUtil.match(exception.getPointcut().getExpression(), beProxiedObject.getClass(), method);
			if (isMatch) {
				isCatchException = true;
				break;
			}
			
		}
		
		//如果捕获异常
		if (isCatchException) {
			//System.out.println("yyyyyyyyyyyyyyy");
			try {					
				handleAdvices(method, args, returnObject, joinPoint);	
				;
			} catch (Throwable e) {
				for (PointcutAndAdvice exception : exceptions) {
					Boolean isMatch =PointcutUtil.match(exception.getPointcut().getExpression(), beProxiedObject.getClass(), method);		
					if (isMatch) {						
						((ExceptionAdvice)exception.getAdvice()).catchException(e);
						//System.out.println("eeeeeeeeeeeeeee");
					}
				}
			}finally{
				/**
				 * 已经加入，最终通知，的实现。
				 * 但是没有实现
				 */
			}

		//如果不捕获异常
		}else {
			//System.out.println("nnnnnnnnnnnnnn");
			try {
				handleAdvices(method, args, returnObject, joinPoint);
			} catch (Throwable e) {
				//System.out.println("eeeeeeeeeeeeeeeeeeeee");
				e.printStackTrace();
			}finally{
				/**
				 * 已经加入，最终通知，的实现。
				 */
			}
		}
				
		//returnObject = method.invoke(beProxiedObject, args);
		
		
		return returnObject;
	}


	
	
	private void handleAdvices(Method method, Object[] args,Object returnObject,JoinPoint joinPoint) throws Throwable {
		for (PointcutAndAdvice before : befores) {
			Boolean boolean1 =PointcutUtil.match(before.getPointcut().getExpression(), beProxiedObject.getClass(), method);
			if (boolean1) {				
				before.getAdvice().beforeMethod(joinPoint);
			}
		}
		
		if (CollectionUtil.isNotEmpty(arounds)) {
			/*Iterator<PointcutAndAdvice> iterator = arounds.iterator();
			if(iterator.hasNext()){
				PointcutAndAdvice around = iterator.next();
				Boolean boolean1 =PointcutUtil.match(around.getPointcut().getExpression(), beProxiedObject.getClass(), method);
				if (boolean1) {				
					((AroundAdvice)around.getAdvice()).aroundMethod((ProceedingJoinPoint)joinPoint);
				}
				
			}*/
				//ProceedingJoinPoint joinPoint2 =(ProceedingJoinPoint)joinPoint;
				
			//类似责任链
				ProceedingJoinPoint pjp = new ProceedingJoinPointImpl(arounds,beProxiedObject,method,args);
				pjp.proceed();
				
		}else {
			returnObject = method.invoke(beProxiedObject, args);
			joinPoint.setReturnObject(returnObject);
		}
		
		for (PointcutAndAdvice after : afters) {
			if (PointcutUtil.match(after.getPointcut().getExpression(), beProxiedObject.getClass(), method)) {
				
				after.getAdvice().afterMethod(joinPoint);
			}
		}

	}


	public static void name(Advice advice,JoinPoint joinPoint) {

			
		/*if (advice instanceof AroundAdvice) {
			
			((AroundAdvice)advice).aroundMethod((ProceedingJoinPoint)joinPoint);
		}else if (advice instanceof BeforeAdvice) {
			advice.beforeMethod(joinPoint);
			returnObject = method.invoke(beProxiedObject, args);
		}else if (advice instanceof AfterAdvice) {
			advice.afterMethod(joinPoint);
			returnObject = method.invoke(beProxiedObject, args);

		}
			
		
		
		
		for (int i = advices.length-1; i >(0-1); i--) {
			
		}
		 */
	}
	
}

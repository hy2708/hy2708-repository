package org.hy.commons.lang.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.lang.Aspects;
import org.aspectj.lang.annotation.Aspect;
import org.hy.commons.lang.CollectionUtil;

public class AopInvocationHandler implements InvocationHandler{

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


	@Override
	public Object invoke(Object proxyObject, Method method, Object[] args)
			throws Throwable {
		Object returnObject = null;
		
		//ProceedingJoinPoint joinPoint = new ProceedingJoinPointImpl(beProxiedObject,method,args);
		JoinPoint joinPoint = new JoinPointImpl(beProxiedObject,method,args);
		
		List<AroundAdvice> aroundAdvices = new LinkedList<AroundAdvice>(); 
		List<BeforeAdvice> beforeAdvices = new LinkedList<BeforeAdvice>(); 
		List<AfterAdvice> afterAdvices = new LinkedList<AfterAdvice>(); 
		
		arrangeAdvices(aroundAdvices, beforeAdvices, afterAdvices);
		
		for (BeforeAdvice beforeAdvice : beforeAdvices) {
			beforeAdvice.beforeMethod(joinPoint);
		}
		
		if (CollectionUtil.isNotEmpty(aroundAdvices)) {
			//for (AroundAdvice aroundAdvice : aroundAdvices) {
			//}
				//ProceedingJoinPoint joinPoint2 =(ProceedingJoinPoint)joinPoint;
				ProceedingJoinPoint pjp = new ProceedingJoinPointImpl(aroundAdvices,beProxiedObject,method,args);
				pjp.proceed();
				
		}else {
			returnObject = method.invoke(beProxiedObject, args);
		}
		
		for (AfterAdvice afterAdvice : afterAdvices) {
			afterAdvice.afterMethod(joinPoint);
		}
		
		
		//returnObject = method.invoke(beProxiedObject, args);
		
		
		return returnObject;
	}


	private void arrangeAdvices(List<AroundAdvice> aroundAdvices,
			List<BeforeAdvice> beforeAdvices, List<AfterAdvice> afterAdvices) {
		for (Advice advice : advices) {
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

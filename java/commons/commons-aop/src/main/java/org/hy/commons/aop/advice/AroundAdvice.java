package org.hy.commons.aop.advice;

import org.hy.commons.aop.proxy.ProceedingJoinPoint;



/*
 * 一次，只能使用一个AroundAdvice
 * 否则，多个AroundAdvice之间，ProceedingJoinPoint.proceed()会造成 被代理对象的重复执行
 */
public interface AroundAdvice extends Advice{

	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable ;
}

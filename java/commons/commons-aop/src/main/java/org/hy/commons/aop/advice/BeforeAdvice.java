package org.hy.commons.aop.advice;

import org.hy.commons.aop.proxy.JoinPoint;



public interface BeforeAdvice extends Advice{

	public void beforeMethod(JoinPoint joinPoint) ;
	public void afterMethod(JoinPoint joinPoint) ;
}

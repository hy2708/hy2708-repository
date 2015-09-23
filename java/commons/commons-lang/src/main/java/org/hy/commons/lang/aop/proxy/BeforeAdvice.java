package org.hy.commons.lang.aop.proxy;



public interface BeforeAdvice extends Advice{

	public void beforeMethod(JoinPoint joinPoint) ;
	public void afterMethod(JoinPoint joinPoint) ;
}

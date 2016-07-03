package org.hy.commons.lang.aop.proxy;



public interface Advice {

	public void beforeMethod(JoinPoint joinPoint) ;
	public void afterMethod(JoinPoint joinPoint) ;
	public Pointcut getPointcut() ;
	public void setPointcut(Pointcut pointcut) ;
}

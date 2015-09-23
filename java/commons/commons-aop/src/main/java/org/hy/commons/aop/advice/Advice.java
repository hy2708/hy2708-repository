package org.hy.commons.aop.advice;

import org.hy.commons.aop.proxy.JoinPoint;
import org.hy.commons.aop.proxy.Pointcut;



public interface Advice {

	public void beforeMethod(JoinPoint joinPoint) ;
	public void afterMethod(JoinPoint joinPoint) ;
	public Pointcut getPointcut() ;
	public void setPointcut(Pointcut pointcut) ;
}

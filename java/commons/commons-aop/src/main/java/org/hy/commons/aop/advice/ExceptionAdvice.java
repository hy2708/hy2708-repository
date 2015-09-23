package org.hy.commons.aop.advice;

import org.hy.commons.aop.proxy.JoinPoint;



public interface ExceptionAdvice extends Advice{

	public void catchException(JoinPoint joinPoint);
	public void catchException(Throwable e);
}

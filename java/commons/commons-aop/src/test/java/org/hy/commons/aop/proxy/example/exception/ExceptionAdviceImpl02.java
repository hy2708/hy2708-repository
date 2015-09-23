package org.hy.commons.aop.proxy.example.exception;

import org.hy.commons.aop.advice.ExceptionAdvice;
import org.hy.commons.aop.proxy.JoinPoint;
import org.hy.commons.aop.proxy.Pointcut;

public class ExceptionAdviceImpl02 implements ExceptionAdvice {

	@Override
	public void beforeMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pointcut getPointcut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPointcut(Pointcut pointcut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void catchException(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void catchException(Throwable e) {
		//e.printStackTrace();
		System.out.println("22"+this.toString()+e.getMessage());
	}

}

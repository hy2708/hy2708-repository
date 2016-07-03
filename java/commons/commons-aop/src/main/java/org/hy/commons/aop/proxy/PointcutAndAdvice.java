package org.hy.commons.aop.proxy;

import org.hy.commons.aop.advice.Advice;

public class PointcutAndAdvice {
	private Pointcut pointcut =null;
	private Advice advice = null;
	
	
	
	public PointcutAndAdvice(Pointcut pointcut, Advice advice) {
		super();
		this.pointcut = pointcut;
		this.advice = advice;
	}
	public Pointcut getPointcut() {
		return pointcut;
	}
	public void setPointcut(Pointcut pointcut) {
		this.pointcut = pointcut;
	}
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	
}

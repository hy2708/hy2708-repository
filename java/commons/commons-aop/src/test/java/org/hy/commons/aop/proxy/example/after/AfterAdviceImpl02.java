package org.hy.commons.aop.proxy.example.after;

import org.hy.commons.aop.advice.AfterAdvice;
import org.hy.commons.aop.proxy.JoinPoint;
import org.hy.commons.aop.proxy.Pointcut;
import org.hy.commons.aop.proxy.example.before.BeforeAdviceImpl01;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 一次
 */
public class AfterAdviceImpl02 implements AfterAdvice {

	private static Logger logger = LoggerFactory
			.getLogger(AfterAdviceImpl02.class);
	
	@Override
	public void afterMethod(JoinPoint joinPoint) {
		logger.info("正在执行【AfterAdviceImpl02.afterMethod(args)】方法");
		logger.info("被代理对象【{}】",joinPoint.getTarget().getClass().getName());
		logger.info("被代理方法【{}】",joinPoint.getMethod().getName());
		if (joinPoint.getArgs()==null) {
			
			logger.info("方法参数是空");
		}else {
			
			logger.info("方法参数【{}】",joinPoint.getArgs().toString());
		}
		
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
	public void beforeMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void aroundMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub
		
	}

	

}

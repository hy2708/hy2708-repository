package org.hy.commons.aop.proxy.example.before;

import org.hy.commons.aop.advice.BeforeAdvice;
import org.hy.commons.aop.proxy.JoinPoint;
import org.hy.commons.aop.proxy.Pointcut;
import org.hy.commons.aop.proxy.example.before.BeforeAdviceImpl02;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 一次
 */
public class BeforeAdviceImpl02 implements BeforeAdvice {

	private static Logger logger = LoggerFactory
			.getLogger(BeforeAdviceImpl02.class);
	
	@Override
	public void beforeMethod(JoinPoint joinPoint) {
		logger.info("正在执行【BeforeAdviceImpl02.beforeMethod(args)】方法");
		logger.info("被代理对象【{}】",joinPoint.getTarget().getClass().getName());
		logger.info("被代理方法【{}】",joinPoint.getMethod().getName());
		if (joinPoint.getArgs()==null) {
			
			logger.info("方法参数是空");
		}else {
			
			logger.info("方法参数【{}】",joinPoint.getArgs().toString());
		}
	}

	
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

	

}

package org.hy.commons.aop.proxy.example.around;

import org.hy.commons.aop.advice.AroundAdvice;
import org.hy.commons.aop.proxy.JoinPoint;
import org.hy.commons.aop.proxy.Pointcut;
import org.hy.commons.aop.proxy.ProceedingJoinPoint;
import org.hy.commons.aop.proxy.example.around.AroundAdviceImpl01;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 一次
 */
public class AroundAdviceImpl01 implements AroundAdvice {
	private static Logger logger = LoggerFactory
			.getLogger(AroundAdviceImpl01.class);
	

	@Override
	public void beforeMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterMethod(JoinPoint joinPoint) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable  {
		logger.info("正在执行【AroundAdviceImpl01.aroundMethod(args)】方法");
		logger.info("---被代理对象【{}】",joinPoint.getTarget().getClass().getName());
		logger.info("---被代理方法【{}】",joinPoint.getMethod().getName());
		if (joinPoint.getArgs()==null) {
			
			logger.info("---方法参数 为空");
		}else {
			
			logger.info("---方法参数【{}】",joinPoint.getArgs().toString());
		}
		Object object = null;
		
			object = joinPoint.proceed();
		
		logger.info("back01---------正在执行【AroundAdviceImpl01.aroundMethod(args)】方法");

		return object;
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

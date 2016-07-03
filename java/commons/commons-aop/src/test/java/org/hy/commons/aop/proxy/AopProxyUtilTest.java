package org.hy.commons.aop.proxy;

import org.hy.commons.aop.advice.AfterAdvice;
import org.hy.commons.aop.advice.AroundAdvice;
import org.hy.commons.aop.advice.BeforeAdvice;
import org.hy.commons.aop.advice.ExceptionAdvice;
import org.hy.commons.aop.proxy.example.after.AfterAdviceImpl01;
import org.hy.commons.aop.proxy.example.after.AfterAdviceImpl02;
import org.hy.commons.aop.proxy.example.around.AroundAdviceImpl01;
import org.hy.commons.aop.proxy.example.around.AroundAdviceImpl02;
import org.hy.commons.aop.proxy.example.before.BeforeAdviceImpl01;
import org.hy.commons.aop.proxy.example.before.BeforeAdviceImpl02;
import org.hy.commons.aop.proxy.example.exception.ExceptionAdviceImpl01;
import org.hy.commons.aop.proxy.example.exception.ExceptionAdviceImpl02;
import org.hy.commons.example.service.UserService;
import org.hy.commons.example.service.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AopProxyUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAopProxy_before() throws Exception {
		AopProxyUtil aopProxyUtil = new AopProxyUtil();
		BeforeAdvice beforeAdvice = new BeforeAdviceImpl01();
		Pointcut pointcut = new Pointcut();
		pointcut.setName("xx");
		pointcut.setExpression("execution(* *.find*(..))");
		PointcutAndAdvice paa = new PointcutAndAdvice(pointcut, beforeAdvice);
		BeforeAdvice beforeAdvice2 = new BeforeAdviceImpl02();
		Pointcut pointcut2 = new Pointcut();
		pointcut2.setName("yy");
		pointcut2.setExpression("execution(* *.add*(..))");
		
		PointcutAndAdvice paa2 = new PointcutAndAdvice(pointcut2, beforeAdvice2);
		aopProxyUtil.addPointcutAndAdvice(paa);
		aopProxyUtil.addPointcutAndAdvice(paa2);
		UserService student = new UserServiceImpl();
		UserService proxy = aopProxyUtil.getAopProxy(student);
		proxy.add();
		proxy.find();
	}

	
	@Test
	public void testGetAopProxy2() throws Exception {
		AopProxyUtil aopProxyUtil = new AopProxyUtil();
		AfterAdvice afterAdvice = new AfterAdviceImpl01();
		Pointcut pointcut = new Pointcut();
		pointcut.setName("xx");
		pointcut.setExpression("execution(* *.add*(..))");
		PointcutAndAdvice paa = new PointcutAndAdvice(pointcut, afterAdvice);
		AfterAdvice afterAdvice2 = new AfterAdviceImpl02();
		Pointcut pointcut2 = new Pointcut();
		pointcut2.setName("yy");
		pointcut2.setExpression("execution(* *.add*(..))");
		
		PointcutAndAdvice paa2 = new PointcutAndAdvice(pointcut2, afterAdvice2);
		aopProxyUtil.addPointcutAndAdvice(paa);
		aopProxyUtil.addPointcutAndAdvice(paa2);
		UserService student = new UserServiceImpl();
		UserService proxy = aopProxyUtil.getAopProxy(student);
		proxy.add();
		proxy.find();
	}
	
	@Test
	public void testGetAopProxy3() throws Exception {
		AopProxyUtil aopProxyUtil = new AopProxyUtil();
		AroundAdvice aroundAdvice = new AroundAdviceImpl01();
		Pointcut pointcut = new Pointcut();
		pointcut.setName("xx");
		pointcut.setExpression("execution(* *.add*(..))");
		PointcutAndAdvice paa = new PointcutAndAdvice(pointcut, aroundAdvice);
		AroundAdvice aroundAdvice2 = new AroundAdviceImpl02();
		Pointcut pointcut2 = new Pointcut();
		pointcut2.setName("yy");
		pointcut2.setExpression("execution(* *.add*(..))");
		
		PointcutAndAdvice paa2 = new PointcutAndAdvice(pointcut2, aroundAdvice2);
		aopProxyUtil.addPointcutAndAdvice(paa);
		aopProxyUtil.addPointcutAndAdvice(paa2);
		UserService student = new UserServiceImpl();
		UserService proxy = aopProxyUtil.getAopProxy(student);
		proxy.add();
		proxy.find();
	}
	
	@Test
	public void testGetAopProxy4() throws Exception {
		AopProxyUtil aopProxyUtil = new AopProxyUtil();
		BeforeAdvice beforeAdvice = new BeforeAdviceImpl01();
		Pointcut pointcut = new Pointcut();
		pointcut.setName("xx");
		pointcut.setExpression("execution(* *.*(..))");
		PointcutAndAdvice paa = new PointcutAndAdvice(pointcut, beforeAdvice);
		AroundAdvice aroundAdvice2 = new AroundAdviceImpl02();
		Pointcut pointcut2 = new Pointcut();
		pointcut2.setName("yy");
		pointcut2.setExpression("execution(* *.*(..))");
		
		PointcutAndAdvice paa2 = new PointcutAndAdvice(pointcut2, aroundAdvice2);
		
		ExceptionAdvice exceptionAdvice = new ExceptionAdviceImpl01();
		Pointcut pointcut3 = new Pointcut();
		pointcut3.setName("2yy");
		pointcut3.setExpression("execution(* *.*(..))");		
		PointcutAndAdvice paa3 = new PointcutAndAdvice(pointcut3, exceptionAdvice);
		
		ExceptionAdvice exceptionAdvice2 = new ExceptionAdviceImpl02();
		Pointcut pointcut4 = new Pointcut();
		pointcut4.setName("4yy");
		pointcut4.setExpression("execution(* *.*(..))");		
		PointcutAndAdvice paa4 = new PointcutAndAdvice(pointcut4, exceptionAdvice2);
		
		aopProxyUtil.addPointcutAndAdvice(paa);
		aopProxyUtil.addPointcutAndAdvice(paa2);
		aopProxyUtil.addPointcutAndAdvice(paa3);
		aopProxyUtil.addPointcutAndAdvice(paa4);
		UserService student = new UserServiceImpl();
		UserService proxy = aopProxyUtil.getAopProxy(student);
		//proxy.add();
		//proxy.find();
		proxy.delete();
	}
}

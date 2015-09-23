package org.hy.commons.aop.proxy;

import java.awt.Point;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hy.commons.aop.advice.AroundAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProceedingJoinPointImpl extends JoinPointImpl implements
		ProceedingJoinPoint {

	
	private static Logger logger = LoggerFactory
			.getLogger(ProceedingJoinPointImpl.class);
	
	//LinkedList<AroundAdvice> aroundAdvices = new LinkedList<AroundAdvice>();
	//Iterator<AroundAdvice> aroundAdvices = null;
	List<PointcutAndAdvice> arounds = null;
	Iterator<PointcutAndAdvice> iterator = null;

	

	public ProceedingJoinPointImpl(List<PointcutAndAdvice> arounds,Object target, Method method, Object[] args) {
		super(target, method, args);
		this.arounds=arounds;
		iterator=arounds.iterator();
		
	}
	
	@Override
	public Object proceed() throws Throwable {
		return proceed(this.args);
	}

	@Override
	public Object proceed(Object[] args) throws Throwable {
		
		if (iterator.hasNext()) {
			PointcutAndAdvice around = iterator.next();
			Boolean boolean1 =PointcutUtil.match(around.getPointcut().getExpression(), target.getClass(), method);
			if (boolean1) {				
				((AroundAdvice)around.getAdvice()).aroundMethod(this);
			}
			
		}else {
			logger.debug("All BeforeAdvice 已经执行完毕");
			method.invoke(target, args);
		}
		return null;
	}

}

package org.hy.commons.lang.aop.proxy;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProceedingJoinPointImpl extends JoinPointImpl implements
		ProceedingJoinPoint {

	
	private static Logger logger = LoggerFactory
			.getLogger(ProceedingJoinPointImpl.class);
	
	//LinkedList<AroundAdvice> aroundAdvices = new LinkedList<AroundAdvice>();
	Iterator<AroundAdvice> aroundAdvices = null;
	public ProceedingJoinPointImpl(List<AroundAdvice> aroundAdvices,Object target, Method method, Object[] args) {
		super(target, method, args);
		this.aroundAdvices = aroundAdvices.iterator();
		
	}

	@Override
	public Object proceed() throws Throwable {
		return proceed(this.args);
	}

	@Override
	public Object proceed(Object[] args) throws Throwable {
		if (aroundAdvices.hasNext()) {
			aroundAdvices.next().aroundMethod(this);
		}else {
			logger.info("eeeeeeeeeeeeeeeeeee");
			method.invoke(target, args);
		}
		return null;
	}

}

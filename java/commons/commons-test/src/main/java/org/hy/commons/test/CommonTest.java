package org.hy.commons.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CommonTest {

	@SuppressWarnings("unused")
	private Logger  orginalLogger= LoggerFactory.getLogger(getClass());
	protected Logger  logger= orginalLogger;
	public Logger name() {
		//orginalLogger.infoo(marker, format, arg1, arg2)
		Object proxyObject =Proxy.newProxyInstance(orginalLogger.getClass().getClassLoader(), orginalLogger.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object beproxyedObject, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		});
		return null;
	}
}

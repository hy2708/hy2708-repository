package org.hy.commons.log.slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class T {

	static Logger logger = LoggerFactory.getLogger(T.class);
	public static void main(String[] args) {
		
		final Logger original = logger;
		//Class[] c =new Class[]{aa.class};
		InvocationHandler invocationHandler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.err.println("xxxxxxxxxxxxxxxxx");
				return method.invoke(original, args);
			
			}
		};
		Object proxy = Proxy.newProxyInstance(Logger.class.getClassLoader(),original.getClass().getInterfaces() , invocationHandler);
		
		Logger aa = (Logger)proxy;
		//System.out.println(aa.getClass());
		aa.info("xxxxxxxxxx");
	}
	
	@Test
	public void name() {
		logger.info("a");
		System.err.println(1);
		//System.out.println(2);
		logger.info("b");
		System.err.println(3);
		//System.out.println(4);
		logger.info("c");
		System.err.println(5);
		//System.out.println(6);
	}
}

interface aa{}

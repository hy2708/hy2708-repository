package com.hy.designpatern.dynamicproxy.jdkproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2012-6-2；时间：上午09:09:49</li>
 * <li>类型名称：LogHandler</li>
 * <li>设计目的：LogHandler对象，含有被代理对象proxyed的实例，进行封装</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class LogHandler2 implements InvocationHandler {
	
	public LogHandler2(Object proxyed) {
		super();
		this.proxyed = proxyed;
		logger = LogFactory.getLog(this.proxyed.getClass());
	}

	Object proxyed;
	public Object getProxyed() {
		return proxyed;
	}

	public void setProxyed(Object proxyed) {
		this.proxyed = proxyed;
	}

	Log logger ;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		logger.info(proxy.getClass().getSimpleName()+" begin business ...");
		//////////////////////////////////////////////////////////////
		//System.out.println(proxy.getClass().getName());//���׻����////
		///////////////////////////////////////////////////////////////
		Object o = method.invoke(proxyed, args);
		
		logger.info(proxy.getClass().getSimpleName()+" end business ....");
		return  o;
		
	}

}

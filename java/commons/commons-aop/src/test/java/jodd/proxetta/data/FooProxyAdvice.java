// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.data;

import jodd.proxetta.ProxyAdvice;
import jodd.proxetta.ProxyTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooProxyAdvice implements ProxyAdvice {

	static int count;

	private static Logger logger = LoggerFactory
			.getLogger(FooProxyAdvice.class);
	
	public static int getCount() {
		logger.debug("正在执行【FooProxyAdvice.getCount(args)】方法");
		
		return count++;
	}

	public Object execute() {
		logger.debug("正在执行【FooProxyAdvice.execute(args)】方法");
		
		return ProxyTarget.invoke();
	}
}
// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.data;

import jodd.proxetta.ProxyAdvice;
import jodd.proxetta.ProxyTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatCounterAdvice implements ProxyAdvice {

	private static Logger logger = LoggerFactory
			.getLogger(StatCounterAdvice.class);
	
	static {
		StatCounter.counter++;
	}

	public Object execute() {
		
		System.out.println(">>正在执行【StatCounterAdvice.execute(args)】方法");
		logger.info("00正在执行【StatCounterAdvice.execute(args)】方法");
		logger.debug("正在执行【StatCounterAdvice.execute(args)】方法");
		
		StatCounter.counter++;
		System.out.println(">>" + ProxyTarget.targetMethodName());
		return ProxyTarget.invoke();
	}
}

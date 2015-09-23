// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.data;

import java.util.ArrayList;
import java.util.List;

import jodd.proxetta.ProxyAdvice;
import jodd.proxetta.ProxyTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectorAdvice implements ProxyAdvice {

	protected List<String> methods = new ArrayList<String>();
	private static Logger logger = LoggerFactory
			.getLogger(CollectorAdvice.class);
	
	public Object execute() throws Exception {
		addMethod(ProxyTarget.targetMethodName());
		logger.debug("正在执行【CollectorAdvice.execute(args)】方法");
		
		return ProxyTarget.invoke();
	}

	private void addMethod(String methodName) {
		logger.debug("正在执行【CollectorAdvice.addMethod(args)】方法");
		
		methods.add(methodName);
	}
}

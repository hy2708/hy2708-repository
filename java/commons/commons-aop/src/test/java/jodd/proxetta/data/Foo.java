// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {

	private static Logger logger = LoggerFactory.getLogger(Foo.class);
	
	public void m1() {
		logger.debug("正在执行【Foo.m1(args)】方法");
		
		System.out.println("Foo.m1");
	}

	protected void m2() {
		logger.debug("正在执行【Foo.m2(args)】方法");
		
		System.out.println("Foo.m2");
	}

	protected String a1;

	public String a2;

}

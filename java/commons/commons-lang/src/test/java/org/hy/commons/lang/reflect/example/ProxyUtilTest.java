package org.hy.commons.lang.reflect.example;

import static org.junit.Assert.*;

import org.hy.commons.lang.aop.proxy.AopProxyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProxyUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProxyObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProxyObjectStringClassStringObjectArray() {
		Object object = new SimpleObject();
		
		SimpleInterface simpleInterface =(SimpleInterface) AopProxyUtil.getProxy(object, "work", AddLog.class, "printLog", new Object[]{"llllllll"});
		simpleInterface.work("wwwwwwww");
	}

	@Test
	public void testGetProxyObjectInvocationHandler() {
		fail("Not yet implemented");
	}

}

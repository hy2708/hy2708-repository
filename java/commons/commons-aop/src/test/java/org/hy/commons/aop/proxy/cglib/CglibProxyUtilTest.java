package org.hy.commons.aop.proxy.cglib;

import org.hy.commons.aop.proxy.example.SimpleInterface;
import org.hy.commons.aop.proxy.example.SimpleObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CglibProxyUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProxy() {
Object object = new SimpleObject();
		
		//SimpleInterface simpleInterface =(SimpleInterface) CglibProxyUtil.getProxy(object, "work", AddLog.class, "printLog", new Object[]{"llllllll"});
		//simpleInterface.work("wwwwwwww");
	}

}

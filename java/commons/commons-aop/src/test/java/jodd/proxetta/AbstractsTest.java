// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.proxetta;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import jodd.proxetta.data.Abstra;
import jodd.proxetta.data.Abstra2;
import jodd.proxetta.data.FooProxyAdvice;
import jodd.proxetta.data.Inter;
import jodd.proxetta.impl.ProxyProxetta;

import org.hy.commons.aop.proxy.PointcutUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractsTest {

	
	@Test
	public void testAbstract1() throws Exception {
		ProxyAspect proxyAspect = new ProxyAspect(FooProxyAdvice.class, new ProxyPointcut() {
			private  Logger logger = LoggerFactory.getLogger(ProxyPointcut.class);
			public boolean apply(MethodInfo methodInfo) {
				System.err.println("sss"+methodInfo.getSignature());
				//System.err.println(methodInfo.getRawSignature());
				
				String nString = methodInfo.getClassInfo().getPackage()+"."+methodInfo.getClassInfo().getClassname();
				System.err.println(nString);
				Method method = ReflectionUtil.findDeclaredMethod(nString, methodInfo.getMethodName());
				System.err.println("mmm"+method);
				logger.debug("正在执行【AbstractsTest.testAbstract1().new ProxyPointcut() {...}.apply(args)】方法");
				
				return true;
			}
		});

		Abstra aaa = (Abstra) ProxyProxetta.withAspects(proxyAspect).builder(Abstra.class).newInstance();
		assertNotNull(aaa);
		aaa.foo2("555555555555");
		aaa.foo3(null);
	}

	@Test
	public void testAbstract2() {
		ProxyAspect proxyAspect = new ProxyAspect(FooProxyAdvice.class, new ProxyPointcut() {
			public boolean apply(MethodInfo methodInfo) {
				return true;
			}
		});

		try {
			ProxyProxetta.withAspects(proxyAspect).builder(Abstra2.class).newInstance();
			fail();
		} catch (ProxettaException ignore) {
		}
	}

	@Test
	public void testInterface() {
		ProxyAspect proxyAspect = new ProxyAspect(FooProxyAdvice.class, new ProxyPointcut() {
			public boolean apply(MethodInfo methodInfo) {
				return true;
			}
		});

		try {
			ProxyProxetta.withAspects(proxyAspect).builder(Inter.class).newInstance();
			fail();
		} catch (ProxettaException ignore) {
		}

	}
}

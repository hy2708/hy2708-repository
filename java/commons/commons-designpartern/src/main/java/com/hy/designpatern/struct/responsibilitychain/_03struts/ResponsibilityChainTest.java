package com.hy.designpatern.struct.responsibilitychain._03struts;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResponsibilityChainTest {

	private List<InterceptorMapping> interceptorsTree;
	private Action action;
	private ActionInvocation actionInvocation;
	
	//初始化拦截器，Action，ActionInvocation，相当于容器工作
	@Before	
	public void setUp(){
		
		interceptorsTree = new ArrayList<InterceptorMapping>();
		Interceptor one = new SelfOneInterceptor();
		Interceptor two = new SelfTwoInterceptor();
		InterceptorMapping oneIntercepror = new InterceptorMapping("one", one);
		InterceptorMapping twoIntercepror = new InterceptorMapping("two", two);
		interceptorsTree.add(oneIntercepror);
		interceptorsTree.add(twoIntercepror);
		
		action = new SelfAction();
		
		actionInvocation = new DefaultActionInvocation(interceptorsTree, action);
	}
	
	@Test
	public void test() throws Exception{
		actionInvocation.invoke();
		Assert.
		assertEquals(Action.SUCCESS,actionInvocation.getResultCode());
	}
}
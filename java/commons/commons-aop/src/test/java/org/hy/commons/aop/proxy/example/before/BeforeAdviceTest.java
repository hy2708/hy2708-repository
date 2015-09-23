package org.hy.commons.aop.proxy.example.before;

import java.util.LinkedList;
import java.util.List;

import org.hy.commons.aop.advice.Advice;
import org.hy.commons.aop.proxy.example.SimpleObject;

public class BeforeAdviceTest {
	
	public static void main(String[] args) {
		Object beProxiedObject = new SimpleObject();
		List< Advice> advices  = new LinkedList<Advice>();
		advices.add(new BeforeAdviceImpl01());
		advices.add(new BeforeAdviceImpl02());
		//SimpleInterface simpleInterface = AopProxyUtil.getProxy(beProxiedObject, advices);
		//simpleInterface.work("wwwwww");
	}

}

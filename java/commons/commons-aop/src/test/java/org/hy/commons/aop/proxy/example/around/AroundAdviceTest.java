package org.hy.commons.aop.proxy.example.around;

import java.util.LinkedList;
import java.util.List;

import org.hy.commons.aop.advice.Advice;
import org.hy.commons.aop.proxy.example.SimpleObject;
import org.junit.Test;


public class AroundAdviceTest {
	
	public static void main(String[] args) {
		Object beProxiedObject = new SimpleObject();
		List< Advice> advices  = new LinkedList<Advice>();
		advices.add(new AroundAdviceImpl01());
		//advices.add(new AroundAdviceImpl02());
		//SimpleInterface simpleInterface = AopProxyUtil.getProxy(beProxiedObject, advices);
		//simpleInterface.work("wwwwww");

	}
	
	@Test
	public void name() {
		Object beProxiedObject = new SimpleObject();
		List< Advice> advices  = new LinkedList<Advice>();
		advices.add(new AroundAdviceImpl01());
		advices.add(new AroundAdviceImpl02());
		advices.add(new AroundAdviceImpl03());
		//SimpleInterface simpleInterface = AopProxyUtil.getProxy(beProxiedObject, advices);
		//simpleInterface.work("wwwwww");

	}

}

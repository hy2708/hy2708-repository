package com.hy.designpatern.dynamicproxy.jdkproxy;

import java.lang.reflect.Proxy;

import com.hy.designpatern.dynamicproxy.jdkproxy.proxy.LogHandler;
import com.hy.designpatern.dynamicproxy.jdkproxy.proxy.LogHandler2;
import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessInterface;
import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessObject;
import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessObject2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		m2();
	}

	private static void m2() {
		BusinessObject bo = new BusinessObject();
		BusinessObject2 bo2 = new BusinessObject2();
		//bo.doBusiness();
		
		LogHandler2 lh = new LogHandler2(bo);
		lh.setProxyed(bo2);
		////////////////////////////////////////////////////////////////
		/*
		 * Proxy.newProxyInstance产生的BusinessInterface，
		 * 实际上，含有的是一个invocationHandler
		 * 
		 * 
		 * bi.doBusiness()时候，实际执行的loggerHandler的invoke方法
		 * loggerHandler的invoke方法，类似Method类的invoke方法
		 */
		BusinessInterface bi = (BusinessInterface)Proxy.newProxyInstance(bo.getClass().getClassLoader(),
				bo.getClass().getInterfaces(), lh);
		//////////////////////////////////////////////////////////////////////
		//bi.doBusiness()时候，实际执行的loggerHandler的invoke方法
		bi.doBusiness();
		/*
		 * 表：Proxy.newProxyInstance产生的对象，用于显示，暴露出来的方法
		 * 里：new LogHandler(bo)，负责方法的，实际调用过程
		 */
		
	}

	private static void m1() {
		BusinessObject bo = new BusinessObject();
		//bo.doBusiness();
		
		LogHandler lh = new LogHandler(bo);
		
		////////////////////////////////////////////////////////////////
		/*
		 * Proxy.newProxyInstance产生的BusinessInterface，
		 * 实际上，含有的是一个invocationHandler
		 * 
		 * 
		 * bi.doBusiness()时候，实际执行的loggerHandler的invoke方法
		 * loggerHandler的invoke方法，类似Method类的invoke方法
		 */
		BusinessInterface bi = (BusinessInterface)Proxy.newProxyInstance(bo.getClass().getClassLoader(),
				bo.getClass().getInterfaces(), lh);
		//////////////////////////////////////////////////////////////////////
		//bi.doBusiness()时候，实际执行的loggerHandler的invoke方法
		bi.doBusiness();
		/*
		 * 表：Proxy.newProxyInstance产生的对象，用于显示，暴露出来的方法
		 * 里：new LogHandler(bo)，负责方法的，实际调用过程
		 */
		
	}
	

}

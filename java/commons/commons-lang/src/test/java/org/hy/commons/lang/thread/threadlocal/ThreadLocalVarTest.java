package org.hy.commons.lang.thread.threadlocal;

import org.junit.Test;

public class ThreadLocalVarTest {

	public static void main(String[] args) {
		
		new ThreadLocalVarTest().name();
	}
	public void name() {
		ThreadLocal<Object> tl = new ThreadLocal<Object>();
		System.err.println(Thread.currentThread().getName());
		System.err.println(new T().getTl());;
		System.err.println(new T2().getTl());;

	}
	
	@Test
	public void testManyThreadLocalVars() {
		ThreadLocalVar01 threadLocalVar01 = new ThreadLocalVar01();
		System.err.println(threadLocalVar01.getTl());
		
		ThreadLocalVar02 threadLocalVar02 = new ThreadLocalVar02();
		System.err.println(threadLocalVar02.getTl());
		
		System.err.println(threadLocalVar01.getTl());

	}
}

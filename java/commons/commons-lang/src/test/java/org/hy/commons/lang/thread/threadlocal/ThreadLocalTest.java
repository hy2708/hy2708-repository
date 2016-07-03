package org.hy.commons.lang.thread.threadlocal;

public class ThreadLocalTest {

	public static void main(String[] args) {
		
		new ThreadLocalTest().name();
	}
	public void name() {
		ThreadLocal<Object> tl = new ThreadLocal<Object>();
		System.err.println(Thread.currentThread().getName());
		System.err.println(new T().getTl());;
		System.err.println(new T2().getTl());;

	}
}
class T{
	ThreadLocal<Object> tl = new ThreadLocal<Object>();
	public Object getTl() {
		System.err.println("nn"+Thread.currentThread().getName());
		tl.set("first set");
		//System.err.println(tl.get());
		tl.set("second set");
		System.err.println("value T" +tl.get());
		return tl.get();
	}
}

class T2{
	ThreadLocal<Object> tl = new ThreadLocal<Object>();
	public Object getTl() {
		System.err.println("nn"+Thread.currentThread().getName());
		System.err.println("value T2 "+tl.get());

		return tl.get();
	}
}

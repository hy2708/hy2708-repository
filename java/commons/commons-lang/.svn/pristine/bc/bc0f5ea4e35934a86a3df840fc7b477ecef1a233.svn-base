package org.hy.commons.lang.thread.example;

/*
 * 调用多个类运行，也是在一个线程中
 */
public class ThreadShareTest {
	public static void main(String[] args) {
		System.err.println(ThreadShareTest.class+" "+Thread.currentThread().toString());
		new Thread(new ThreadShareTest01()).start();
		new ThreadShareTest01().m(new Object());
	}
}

class ThreadShareTest01 implements Runnable{

	@Override
	public void run() {
		System.err.println(Thread.currentThread());		
	}
	
	public void m(Object object) {
		System.err.println(object.getClass()+" "+Thread.currentThread().toString());

	}
	
}

class ThreadShareTest02 implements Runnable{

	@Override
	public void run() {
		System.err.println(Thread.currentThread());		
	}
	
	public void m(Object object) {
		System.err.println(object.getClass()+" "+Thread.currentThread().toString());

	}
	
}
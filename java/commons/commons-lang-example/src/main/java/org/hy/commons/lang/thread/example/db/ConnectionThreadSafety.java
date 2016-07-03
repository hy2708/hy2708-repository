package org.hy.commons.lang.thread.example.db;

import java.sql.Connection;


public class ConnectionThreadSafety implements Runnable{

	public ConnectionThreadSafety() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * 线程，不安全
	 */
	MyConnection connection =new MyConnection();
	String str ="aaaaaaaaa";
	Integer num = new Integer(12345);
	int num2 =100;
	public void name() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.err.println(Thread.currentThread().getName());
		System.err.println(Thread.currentThread().getName()+connection);
		System.err.println(Thread.currentThread().getName()+str.hashCode());
		System.err.println(Thread.currentThread().getName()+num.hashCode());
		System.err.println(Thread.currentThread().getName()+num2--);
	}
	public static void main(String[] args) {
		/*
		 * 开启的是多进程
		 * new Thread(new ConnectionThreadSafety(),"A").start();
		new Thread(new ConnectionThreadSafety(),"B").start();
		new Thread(new ConnectionThreadSafety(),"C").start();

		 */
		
		/*
		 * 开启的是多线程
		 */
		ConnectionThreadSafety connectionThreadSafety=new ConnectionThreadSafety();
		new Thread(connectionThreadSafety,"A").start();
		new Thread(connectionThreadSafety,"B").start();
		new Thread(connectionThreadSafety,"C").start();
	}

	@Override
	public void run() {
		name();
		
	}
}

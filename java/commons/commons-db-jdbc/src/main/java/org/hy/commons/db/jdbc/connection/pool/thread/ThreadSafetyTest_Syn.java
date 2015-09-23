package org.hy.commons.db.jdbc.connection.pool.thread;

import java.sql.Connection;

public class ThreadSafetyTest_Syn implements Runnable{

	/*
	 * 这是所有线程共享的，类成员变量
	 */
	Connection connection = null;

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-9；时间：下午2:29:51</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//Class.forName(ConnUtils2.class.getName());
		 ThreadSafetyTest_Syn connUtils2= new ThreadSafetyTest_Syn();
		new Thread(connUtils2,"A").start();
		new Thread(connUtils2,"B").start();
		new Thread(connUtils2,"C").start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();

	}
	
	public void name() {
		connection = ThreadSafetyConnUtils.getCon();
		System.err.println("线程"
				+Thread.currentThread().getName() +"最初获得的Con连接  "+connection);
		if ("A".equals(Thread.currentThread().getName())) {
			try {
				Thread.currentThread().sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("线程"
					+Thread.currentThread().getName() +"休眠之后，最后使用的Con连接被被其他线程改变了，变成  "+connection);
		}else {
			System.err.println("线程"
					+Thread.currentThread().getName() +"最后使用的Con连接  "+connection);
			
		}

	}
	@Override
	public void run() {
		name();
	}
}

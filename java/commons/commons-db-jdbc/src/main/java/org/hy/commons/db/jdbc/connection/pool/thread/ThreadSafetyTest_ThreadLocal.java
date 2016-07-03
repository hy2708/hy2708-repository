package org.hy.commons.db.jdbc.connection.pool.thread;

import java.sql.Connection;

public class ThreadSafetyTest_ThreadLocal implements Runnable{

	/*
	 * 这是所有线程共享的，类成员变量
	 */
	Connection connection = null;

	/*
	 * 代替上面的变量
	 */
	static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
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
		 ThreadSafetyTest_ThreadLocal connUtils2= new ThreadSafetyTest_ThreadLocal();
		new Thread(connUtils2,"A").start();
		new Thread(connUtils2,"B").start();
		new Thread(connUtils2,"C").start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();
		//new Thread(new ConnUtils2()).start();

	}
	
	public void name() {
		if (tl.get()==null) {
			tl.set(ThreadSafetyConnUtils.getCon());
			//connection = ThreadSafetyConnUtils.getCon();
		}
		System.err.println("线程"
				+Thread.currentThread().getName() +"最初获得的Con连接  "+tl.get());
		if ("A".equals(Thread.currentThread().getName())) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("线程"
					+Thread.currentThread().getName() +"休眠之后，最后使用的Con连接被被其他线程改变了，变成  "+tl.get());
		}else {
			System.err.println("线程"
					+Thread.currentThread().getName() +"最后使用的Con连接  "+tl.get());
			
		}

	}
	@Override
	public void run() {
		name();
	}
}

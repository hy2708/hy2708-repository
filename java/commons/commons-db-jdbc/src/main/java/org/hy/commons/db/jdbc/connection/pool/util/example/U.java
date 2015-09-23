package org.hy.commons.db.jdbc.connection.pool.util.example;

import java.sql.Connection;

public class U  implements Runnable{

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-8；时间：上午1:50:09</li>
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
	public static void main(String[] args) {
		new Thread(new U()).start();
		new Thread(new U()).start();
		new Thread(new U()).start();


	}
	
	public Connection name() {
		Connection connection = ConnUtils2.getCon();
		return connection;
	}

	@Override
	public void run() {
		
		Connection connection = name();
		System.err.println(Thread.currentThread().getName() +"  "+connection);
	}

}

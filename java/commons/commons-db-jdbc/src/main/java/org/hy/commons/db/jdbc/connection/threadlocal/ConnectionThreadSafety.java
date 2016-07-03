package org.hy.commons.db.jdbc.connection.threadlocal;

import java.sql.Connection;

import org.hy.commons.db.jdbc.connection.JDBCUtils;

public class ConnectionThreadSafety implements Runnable{

	/*
	 * 线程，安全
	 */
	static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	//Connection connection = JDBCUtils.getConnection();
	
	public void name() {
		if (tl.get()==null) {
			Connection connection = JDBCUtils.getConnection();
			tl.set(connection);
		}
		System.err.println(tl.get());
	}
	public static void main(String[] args) {
		ConnectionThreadSafety connectionThreadSafety=new ConnectionThreadSafety();
		new Thread(connectionThreadSafety).start();
		new Thread(connectionThreadSafety).start();
		new Thread(connectionThreadSafety).start();
	}

	@Override
	public void run() {
		name();
		
	}
}

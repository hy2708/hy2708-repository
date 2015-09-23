package org.hy.commons.db.jdbc.connection.threadlocal;

import java.sql.Connection;

import org.hy.commons.db.jdbc.connection.JDBCUtils;

public class ConnectionThreadUnSafety implements Runnable{

	/*
	 * 线程，不安全
	 */
	Connection connection = JDBCUtils.getConnection();
	
	public void name() {
		System.err.println(connection);
	}
	public static void main(String[] args) {
		ConnectionThreadUnSafety connectionThreadSafety=new ConnectionThreadUnSafety();
		new Thread(connectionThreadSafety).start();
		new Thread(connectionThreadSafety).start();
		new Thread(connectionThreadSafety).start();
	}

	@Override
	public void run() {
		name();
		
	}
}

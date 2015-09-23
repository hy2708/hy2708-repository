package org.hy.commons.db.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;



/**
 * Unit test for simple App.
 */
public class AppTest  {
	
	@org.junit.Test
	public void testCon() {
		Driver driver = new com.mysql.jdbc.Driver();
        Connection con = driver.connect(url, info);
        con.close();
	}
	
	/*
	 * DriverManager
	 */
	@org.junit.Test
	public void testCon2() {
		/*
		 * 由于(new com.mysql.jdbc.Driver()的内部，有个静态代码块
		 * 已经执行了DriverManager.registerDriver(new com.mysql.jdbc.Driver())
		 * 所以。这个方法，重复了
		 * 只需要用类加载器，加载com.mysql.jdbc.Driver，就可以直接执行静态代码块
		 */
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "root", "root");
    }
	
	@org.junit.Test
	public void testCon3() {
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,  "root", "root");
    }
}

package org.hy.commons.db.jdbc.connection.pool.util.example;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
/**
 * 用静态工厂方法管理一个唯一的可重用的连接
 */
public class ConnUtils {
	private static Connection con;
	//在静态代码块中创建与数据库的连接
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///test?characterEncoding=UTf8";
			/*
			 * 因为只创建了一个连接，一定会出现问题
			 */
			con = DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	//使用一个静态方法－静态工厂方法，返回connection实例
	public static Connection getCon(){
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = getCon();
		Connection connection2 = getCon();
		System.err.println(connection);
		System.err.println(connection2.getClass().getClassLoader());
		System.err.println(String.class.getClassLoader());
		connection.close();
		connection2.close();
	}
}

package cn.itcast.mysql.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 用statement实现DDL,DML DDL:创建一个表 DML: insert update delete
 * 
 * @author Administrator
 * 
 */
/*
 * 1 注册驱动
 */

/*
 * 2 得到连接对象
 */

/*
 * 3 得到能执行sql语句的Statement对象
 */

/*
 * 4 执行sql语句
 */

/*
 * 5 处理返回的结果
 */

/*
 * 6 关闭资源
 */
public class TestStatement {

	@Test
	public void testCreateTable() {
		Connection conn = null;
		Statement stmt = null;

		/*
		 * 1 注册驱动
		 * 在com.mysql.jdbc.Driver这个类里有静态代码块
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */
		
		try {
			//加载类字节码，使静态代码块被执行
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * 2 得到连接对象
		 */
		try {
			/*
			 * jdbc url = "jdbc:mysql://localhost:3306/dbjdbc"
			 * 	1 jdbc 代表总协议是jdbc协议　不变
			 * 　2 mysql 代表当前的实现协议是mysql,不同的数据库服务器不一样
			 * 　3 localhost:3306/dbjdbc
			 * 		* localhost 主机/IP
			 * 		* 3306 代表数据库服务器监听的端口号
			 * 		* dbjdbc: 要连接到的数据库名称
			 */
			String url = "jdbc:mysql://localhost:3306/dbjdbc";
			//登陆数据库的用户名
			String user = "root";
			//登陆数据库的密码
			String password = "root";
			//通过DriverManager得到连接对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 3 得到能执行sql语句的Statement对象
		 */
		try {
			//通过Connection对象得到能执行sql语句的Statement对象
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * 4 执行sql语句
		 */
		int result = -1;
		try {
			String sql = "CREATE TABLE s_user(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),PASSWORD VARCHAR(15))";
			//通过statement对象执行sql语句（DDL）
			//executeUpdate: 如果执行的DDL语句返回的结果为0
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 5 处理返回的结果
		 */
		System.out.println("create table result="+result);
		/*
		 * 6 关闭资源
		 * 	后开先关
		 */
		try {
			if(stmt!=null) {//关闭statement对象所占用的资源
				stmt.close();
			}
			if(conn!=null) {//关闭connection对象所占用的资源
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试使用Statement执行DML操作
	 */
	@Test
	public void testDML() {
		Connection conn = null;
		Statement stmt = null;

		/*
		 * 1 注册驱动
		 * 在com.mysql.jdbc.Driver这个类里有静态代码块
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */
		
		try {
			//加载类字节码，使静态代码块被执行
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * 2 得到连接对象
		 */
		try {
			/*
			 * jdbc url = "jdbc:mysql://localhost:3306/dbjdbc"
			 * 	1 jdbc 代表总协议是jdbc协议　不变
			 * 　2 mysql 代表当前的实现协议是mysql,不同的数据库服务器不一样
			 * 　3 localhost:3306/dbjdbc
			 * 		* localhost 主机/IP
			 * 		* 3306 代表数据库服务器监听的端口号
			 * 		* dbjdbc: 要连接到的数据库名称
			 */
			String url = "jdbc:mysql://localhost:3306/dbjdbc";
			//登陆数据库的用户名
			String user = "root";
			//登陆数据库的密码
			String password = "root";
			//通过DriverManager得到连接对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 3 得到能执行sql语句的Statement对象
		 */
		try {
			//通过Connection对象得到能执行sql语句的Statement对象
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * 4 执行sql语句
		 */
		int result = -1;
		try {
			//String sql = "CREATE TABLE s_user(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),PASSWORD VARCHAR(15))";
			//插入数据
			String sql = "INSERT INTO s_user(NAME,PASSWORD) VALUES('小强','9527');";
			//更新数据
			sql = "UPDATE s_user SET NAME='黄宏强',password='250' WHERE NAME='大黄'";
			//删除数据
			sql = "delete from s_user";
			//通过statement对象执行sql语句（DML）
			//executeUpdate: 如果执行的DML语句返回的结果为更新的记录数
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * 5 处理返回的结果
		 */
		System.out.println("create table result="+result);
		/*
		 * 6 关闭资源
		 * 	后开先关
		 */
		try {
			if(stmt!=null) {//关闭statement对象所占用的资源
				stmt.close();
			}
			if(conn!=null) {//关闭connection对象所占用的资源
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}























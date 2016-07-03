package cn.itcast.mysql.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

/**
 * 实现得到代表与数据库连接的Connection实现类对象  三种方式
 * 
 * 三种方式
 * 		1 创建Driver接口的实现类对象去得到连接：需要记key:user password
 * 		2 DriverManager注册Driver接口的实现类对象，并获得连接
 * 		3 通过Class.for("Driver接口的实现类的全类")来注册
 * 
 * 	加入mysql的驱动jar包
 * @author Administrator
 *
 */
public class TestConnection {

	/**
	 * 编写测试方法
	 * 		加入junit测试包
	 * 		@Test
	 * 		定义方法　public void methodName()
	 * 		outline中 run as Junit
	 */
	@Test
	public void testgetConnection() {
		try {
			//创建mysql的Driver对象
			Driver driver = new com.mysql.jdbc.Driver();
			//jdbc url   定位到一个数据库
			String url = "jdbc:mysql://localhost:3306/dbjdbc"; //定位到一个数据库
			//用于存储用户名和密码的对象（Map）
			Properties info = new Properties();
			info.put("user", "root"); //key固定
			info.put("password", "root");
			//通过Driver对象得到连接对象
			Connection connection = driver.connect(url, info);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DriverManager.registerDriver(driver) 
	 */
	@Test
	public void testGetConnection2() {
		
		try {
			//使用DriverManager注册驱动对象
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/dbjdbc";
			String user = "root";
			String password = "root";
			//使用DriverManager得到连接对象
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 采用class.forName的方式
	 */
	@Test
	public void testGetConnection() {
		
		/*static {
			try {
				java.sql.DriverManager.registerDriver(new Driver());
			} catch (SQLException E) {
				throw new RuntimeException("Can't register driver!");
			}
		}*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String url = "jdbc:mysql://localhost:3306/dbjdbc";
			String user = "root";
			String password = "root";
			//使用DriverManager得到连接对象
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





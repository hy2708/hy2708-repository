package org.hy.commons.db.jdbc.connection.pool.util.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ConnPoolUtil implements DataSource{
	private static Logger logger = LoggerFactory.getLogger(ConnPoolUtil.class);
	//第一步：声明连接池维护所有的连接
	private static List<Connection> pool = new ArrayList<Connection>();
	//第二步：静态代码块中创建多个连接
	static{
		try{
			
			//声明资源器类　－　
			Properties prop = new Properties();
			//获取这个文件的路径
			URL url = ConnUtils3.class.getClassLoader().getResource("jdbc.properties");
			String path = url.getPath();
			//为了防止URL中，有中文或是空格，需要进行解码
			path = URLDecoder.decode(path,"UTf-8");
			File file = new File(path);
			//加载jdbc.properties这个文件
			prop.load(new FileInputStream(file));
			//获取信息
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			String jdbcurl = prop.getProperty("url");
			System.err.println(jdbcurl);
			String username = prop.getProperty("name");
			String pwd = prop.getProperty("pwd");
			//创建三个原生的连接，都将它们代理
			String poolSize = prop.getProperty("poolSize");
			int size = Integer.parseInt(poolSize);
			if (size<1) {
				size = 3;
			}
			//Class.forName("com.mysql.jdbc.Driver");
			//String url = "jdbc:mysql:///db909?characterEncoding=UTF8";
			logger.debug("读取配置文件【jdbc.properties】，所在路径为【" +
					path+"】");
			logger.debug("【driver】是"+driver);
			logger.debug("数据库的【url】是"+url);
			logger.debug("【username】是"+username);
			logger.debug("【password】是"+pwd);
			logger.debug("【poolSize】是"+poolSize);
			for(int i=0;i<size;i++){
				final Connection con = DriverManager.getConnection(jdbcurl,username,pwd);//com.mysql.jdbc.Jdbc4Connection@
				//对con对象进行动态代理
				Object proxyedCon = 
						Proxy.newProxyInstance(
								ConnPoolUtil.class.getClassLoader(),
								new Class[]{Connection.class},
								//声明执行句柄，只对close方法设置拦截
								new InvocationHandler() {
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										if(method.getName().equals("close")){
											//System.err.println("有人想关闭连接，不能关，还连接");
											//将proxy再加到pool中,这个proxy就是proxyedCon
											logger.debug("重写了【close()】方法");
											synchronized (pool) {
												pool.add((Connection) proxy);
												pool.notify();
											}
											return null;
										}else{
											//System.err.println("放行"+method.getName());
											return method.invoke(con, args);
										}
									}
								});
				//一定要将代理对象添加到池中去。
				pool.add((Connection) proxyedCon);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	/**
	 * 提供一个静态工厂方法返回一个连接
	 */
	public static Connection getCon(){
		synchronized (pool) {
			if(pool.size()==0){
				try {
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return getCon();
			}
			Connection con = pool.remove(0);//返回一个代理的connection对象
			logger.debug("连接池中，还有连接数目是【" +
					pool.size()+"】");
			return con;
		}
	}
	
	/**
	 * 关闭指定的资源
	 */
	public static void closeResource(Connection connection, Statement stmt, ResultSet rs) {
		logger.info("执行【closeResource()】方法！");
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		return getCon();
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}

package org.hy.commons.db.jdbc.connection.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import jodd.util.StringUtil;

import org.hy.commons.db.jdbc.connection.pool.util.example.ConnPoolUtil;
import org.hy.commons.db.jdbc.connection.pool.util.example.ConnUtils3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDataSource implements DataSource{
	
	

	private  Logger logger = LoggerFactory.getLogger(getClass());
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	private static MyDataSource dataSource = null;
	public static MyDataSource getInstance() {
		if (dataSource==null) {
			dataSource = new MyDataSource();
		}
		return dataSource;
	}

	public MyDataSource() {
		initDataSource("jdbc.properties");
	}

	
	public MyDataSource(String jdbcProperties) {
		initDataSource(jdbcProperties);
	}
	
	private void initDataSource(String jdbcProperties) {
		//声明资源器类　－　
				Properties prop = new Properties();
				//获取这个文件的路径
				URL url = ConnUtils3.class.getClassLoader().getResource("jdbc.properties");
				String path = url.getPath();
				//为了防止URL中，有中文或是空格，需要进行解码
				try {
					path = URLDecoder.decode(path,"UTf-8");
					File file = new File(path);
					//加载jdbc.properties这个文件
					prop.load(new FileInputStream(file));
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//获取信息
				String driver = prop.getProperty("driver");
				String jdbcurl = prop.getProperty("url");
				System.err.println(jdbcurl);
				String username = prop.getProperty("name");
				if (StringUtil.isEmpty(username)) {
					username = prop.getProperty("username");					
				}
				String pwd = prop.getProperty("pwd");
				if (StringUtil.isEmpty(pwd)) {
					pwd = prop.getProperty("password");					
				}
				//创建三个原生的连接，都将它们代理
				String poolSize = prop.getProperty("poolSize");
				int size = 1;
				if (!StringUtil.isEmpty(poolSize)) {
					size = Integer.parseInt(poolSize);					
				}
				if (size<1) {
					size = 1;
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
				try {
					Class.forName(driver);
					for(int i=0;i<size;i++){
						Connection con = DriverManager.getConnection(jdbcurl,username,pwd);//com.mysql.jdbc.Jdbc4Connection@
						//对con对象进行动态代理
						
						//原生的对象放入
						pool.add(con);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

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
	public Connection getConnection() throws SQLException {
		synchronized (pool) {
			if(pool.size()==0){
				try {
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//Connection con = pool.remove(0);//返回一个代理的connection对象
			final Connection originalConnection = pool.removeFirst();
			logger.debug("连接池中，还有连接数目是【" +
					pool.size()+"】");
			
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
										//关闭，Connection的时候，将原生的Connection再加到pool中,而不是proxyedCon
										logger.debug("重写了【close()】方法");
										synchronized (pool) {
											pool.add(originalConnection);											
											logger.debug("pool中，还有【" +
													pool.size()+"】个连接");
											pool.notify();
										}
										return null;
									}else if (method.getName().equals("commit")) {
										logger.debug("提交事务了");
										return method.invoke(originalConnection, args);
									}else if (method.getName().equals("rollback")) {										
										logger.debug("回滚了");
										return method.invoke(originalConnection, args);
									}else{
										//System.err.println("放行"+method.getName());
										return method.invoke(originalConnection, args);
									}
								}
							});
			//取出Connection时，才进行增强
			return (Connection)proxyedCon;
		}
		
		
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

package org.hy.commons.db.jdbc.connection.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceUtil {

	private DataSourceUtil(DataSource dataSource) {
		super();
		this.dataSource=dataSource;
		hasInited = true;
	}

	@Deprecated
	public DataSourceUtil() {
		super();
	}
	
	public static DataSourceUtil getInstance(DataSource dataSource) {
		if (dataSourceUtil==null) {
			dataSourceUtil = new DataSourceUtil(dataSource);
		}
		return dataSourceUtil;
	}
	
	/*
	 * 保证Connection变量的线程安全
	 */
	static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	protected static DataSourceUtil dataSourceUtil =null;
	protected DataSource dataSource = null;
	private boolean hasInited = false;
	private static Logger logger = LoggerFactory.getLogger(DataSourceUtil.class);
	static{
		//dataSource = MyDataSource.getInstance();
	}
	
	protected  void init() {
		if (!hasInited) {			
			initDataSource();
			hasInited = true;
		}
	}
	
	protected  void initDataSource() {
		//dataSource = MyDataSource.getInstance();
		
	}
	
	public  DataSource getDataSource() {
		init();
		
		return dataSource;
	}
	
	/*
	 * 方法错误
	 */
	@Deprecated
	public  Connection getCurrentConnection2() throws SQLException {
		
		init();
		Connection connection = null;//dataSource.getConnection();
		if (null==connection) {			
			try {
				//tl.set(dataSource.getConnection());
				connection = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获得当前线程中的当前链接</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-1-8；时间：下午8:30:09</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 */
	public  Connection getCurrentConnection() {
		
		init();
		Connection connection = tl.get();
		if (null==connection) {			
			try {
				tl.set(dataSource.getConnection());
				connection = tl.get();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	
	
	public  Connection getConnection() {
		if (!hasInited) {
			init();
		}
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	public static void removeCurrentConnection() {
		Connection connection = tl.get();
		tl.remove();
		closeResource(connection, null, null);
	}
	
	public static void main(String[] args) throws SQLException {
		//System.err.println(DataSourceUtil.getInstance().getDataSource().getClass());
		Connection connection =new DataSourceUtil().getConnection();
		System.err.println(connection);
		System.err.println(connection.getClass());
		connection.close();
	}
	
	
}

package org.hy.commons.db.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.hy.commons.lang.string.StringUtil;

/**
 * mysql数据库服务的数据库jdbc操作的帮助类
 * @author Administrator
 *
 */
public  class ConnectionUtil {

	//private   String url = null;//"jdbc:mysql://localhost:3306/test?characterEncoding=UTf8";
	private   String url ="jdbc:mysql://localhost:3306/test?characterEncoding=UTf8";
	//private   String username = null;//"root";
	private   String username = "root";
	//private   String password = null;//"root";
	private   String password = "root";
	//private   String driver = null;//"com.mysql.jdbc.Driver";
	private   String driver = "com.mysql.jdbc.Driver";
	Connection conn = null;
	static ConnectionUtil util = null;
	
	

	public void setDatabaseName(String databaseName) {
		//StringBuffer buffer=new StringBuffer();
		
		//StringUtil.replaceAllOccurances(string, from, to)
	//	url=
	}
	
	
	/*static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public static ConnectionUtil getInstance() {
		if (util==null) {
			util = new ConnectionUtil();
		}
		return util;
	}
	
	/**
	 * 得到连接对象
	 */
	public  Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 正确的方法
	 * 关闭指定的资源
	 */
	public static void closeResource(Connection conn, Statement stmt, ResultSet rs) {
		
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
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	/**
	 * 关闭指定的资源
	 */
	private static void closeResource2(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(conn!=null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 关闭指定的资源
	 * 
	 * 必须严重不行
	 */
	private static void closeResource3(Connection conn, Statement stmt, ResultSet rs) {
		
			if(rs!=null) {//rs=null
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(stmt!=null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							try {
								if(conn!=null) {
									conn.close();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
	}
}

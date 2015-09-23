package org.hy.commons.db.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**无状态的类<br/>
 * mysql数据库服务的数据库jdbc操作的帮助类
 * @author Administrator
 *
 */
public final class JDBCUtils {

	private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTf8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到连接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
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
		
			if(rs!=null) {//rs=null,stmt和connection就不能被关闭了
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

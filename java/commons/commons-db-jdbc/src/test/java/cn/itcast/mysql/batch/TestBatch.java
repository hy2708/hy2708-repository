package cn.itcast.mysql.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 测试批量保存　
 * 　statement
 * 
 * 	 PreparedStatement
 * 
 * @author Administrator
 *
 */
public class TestBatch {

	/**
	 * 用Statement批量保存5000条记录
	 * mysql statement batch time=3047
	 */
	@Test
	public void testStatementBatch() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			for(int i=0;i<5000;i++) {
				String sql = "INSERT INTO b_user(id,NAME,PASSWORD,age) VALUES(1,'t','t',1)";
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			System.out.println("mysql statement batch time="+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, null);
		}
	}
	
	/**
	 * 用PreparedStatement批量保存5000条记录
	 * mysql preparedstatement batch time=3094
	 */
	@Test
	public void testPreparedStatementBatch() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO b_user(id,NAME,PASSWORD,age) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<5000;i++) {
				pstmt.setInt(1, 1);
				pstmt.setString(2, "t");
				pstmt.setString(3, "t");
				pstmt.setInt(4, 1);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("mysql preparedstatement batch time="+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}
	
	/**
	 * mysql Statement time2984
	 */
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConnection();
		
		try {
			stmt = conn.createStatement();
			for(int i=0;i<5000;i++) {
				String sql = "INSERT INTO b_user(id,NAME,PASSWORD,age) VALUES(1,'t','t',1)";
				stmt.executeUpdate(sql);
			}
			System.out.println("mysql Statement time"+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, null);
		}
		
		
	}
}











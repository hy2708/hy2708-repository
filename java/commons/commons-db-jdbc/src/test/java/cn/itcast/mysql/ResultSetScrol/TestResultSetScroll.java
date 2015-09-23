package cn.itcast.mysql.ResultSetScrol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

public class TestResultSetScroll {

	@Test
	public void testScroll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = JDBCUtils.getConnection();

		try {
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from rs_user";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("name="+rs.getString("name"));
			}
			
			if(rs.next()) {
				System.out.println("name="+rs.getString("name"));
			}
			
			if(rs.previous()) {
				System.out.println("name="+rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}

	}
	
	@Test
	public void testResultSetMethod() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = JDBCUtils.getConnection();

		try {
			//stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from rs_user";
			rs = stmt.executeQuery(sql);
			
			rs.next();
			System.out.println("next="+rs.getString("id"));
			
			rs.next();
			System.out.println("next="+rs.getString("id"));
			
			rs.previous();
			System.out.println("previous="+rs.getString("id"));
			
			rs.first();
			System.out.println("first="+rs.getString("id"));
			
			rs.last();
			System.out.println("last="+rs.getString("id"));
			
			//第几条数据
			rs.absolute(2);
			System.out.println("absolute="+rs.getString("id"));
			//保光标移动多少位(正代表forword 负代表回滚)
			rs.relative(2);
			System.out.println("relative="+rs.getString("id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}

	}
}

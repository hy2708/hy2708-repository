package cn.itcast.oracle.ResultSetScrol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.oracle.util.OracleJDBCUtils;

public class TestResultSetScroll {

	@Test
	public void testScroll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = OracleJDBCUtils.getConnection();

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
			//抛出异常
			if(rs.previous()) {
				System.out.println("name="+rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, rs);
		}

	}
}

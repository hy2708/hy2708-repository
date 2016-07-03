package cn.itcast.oracle.vs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.oracle.util.OracleJDBCUtils;

/**
 * oracle
 * @author Administrator
 *
 */
public class TestPreparedStatement {

	/**
	 * 循环保存5000条数据
	 * mysql preparedStatement time=3062ms
	 * oracle preparedStatement time2328
	 * oracle preparedStatement time2125
	 * oracle preparedStatement time2344
	 */
	@Test
	public void testEff() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		long time = System.currentTimeMillis();
		conn = OracleJDBCUtils.getConnection();
		String sql = "INSERT INTO vs_user(id,NAME,PASSWORD,age) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < 5000; i++) {
				pstmt.setInt(1, 1);
				pstmt.setString(2, "t");
				pstmt.setString(3, "1");
				pstmt.setInt(4, 1);
				pstmt.executeUpdate();
			}
			System.out.println("oracle preparedStatement time"+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, pstmt, null);
		}
	}
}

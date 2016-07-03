package cn.itcast.mysql.vs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

public class TestPreparedStatement {

	/**
	 * PreparedStatement能解决sql注入问题
	 */
	@Test
	public void testSqlInject() {
		// 准备数据
		String name = "a' or 1=1 or 1='";
		String password = "123";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = JDBCUtils.getConnection();
		String sql = "SELECT NAME,PASSWORD FROM p_user WHERE NAME=? AND PASSWORD=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("登陆成功啦！");
				System.out.println("用户名=" + rs.getString("name") + " 密码="
						+ rs.getString("password"));
			} else {
				System.out.println("用户名或密码不匹配！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, rs);
		}
	}

	/**
	 * 循环保存5000条数据
	 * mysql preparedStatement time=3062ms
	 */
	@Test
	public void testEff() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConnection();
		String sql = "INSERT INTO p_user(NAME,PASSWORD,age) VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < 5000; i++) {
				pstmt.setString(1, "t");
				pstmt.setString(2, "1");
				pstmt.setInt(3, 1);
				pstmt.executeUpdate();
			}
			System.out.println(System.currentTimeMillis()-time);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}
}

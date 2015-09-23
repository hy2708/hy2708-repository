package cn.itcast.mysql.vs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;
/**
 * 对mysql Statement和preparedSatement效率没有什么差异
 * @author Administrator
 *
 */
public class TestStatement {

	/**
	 * 测试sql注入怎么产生
	 * 
	 * 模拟登陆
	 */
	@Test
	public void testSqlInject() {
		// 准备数据
		String name = "a' or 1=1 or 1='";
		String password = "123";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT NAME,PASSWORD FROM p_user WHERE NAME='" + name + "' AND PASSWORD="
					+ password;
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("登陆成功啦！");
				System.out.println("用户名="+rs.getString("name")+" 密码="+rs.getString("password"));
			} else {
				System.out.println("用户名或密码不匹配！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
	}
	
	/**
	 * 循环保存5000条数据
	 *  msql Statement 2984ms
	 */
	@Test
	public void testEff() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = JDBCUtils.getConnection();
		
		try {
			stmt = conn.createStatement();
			for(int i=0;i<5000;i++) {
				String sql = "INSERT INTO p_user(NAME,PASSWORD,age) VALUES('t','1',1)";
				stmt.executeUpdate(sql);
			}
			System.out.println(System.currentTimeMillis()-time);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, null);
		}
		
		
	}
}









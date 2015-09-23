package cn.itcast.mysql.prearedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 用PreparedStatement进行表的CRUD操作
 * 预编译的作用
 * 	1 sql语句中可变的数据用?代替
 * 　2 执行sql语句之前一定将数据设置到对应?上
 * 
 * @author Administrator
 * 
 */
public class TestPreparedStatement {

	@Test
	public void testSaveUpdateDelete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 准备数据
		String name = "tt";
		String password = "123";
		int age = 12;
		conn = JDBCUtils.getConnection();
		//sql语句中不定值用?代替
		String sql = "INSERT INTO p_user(NAME,PASSWORD,age) VALUES(?,?,?)";
		//更新
		sql = "UPDATE p_user SET NAME=?,PASSWORD=?,age=? WHERE id=?";
		//删除
		sql = "DELETE FROM p_user WHERE id=?";
		try {
			//调用prepareStatement(sql)得到PreparedStatement的实现类对象
			//预编译
			pstmt = conn.prepareStatement(sql);
			
			/*pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setInt(3, age);*/
			
			/*pstmt.setString(1, name+"2");
			pstmt.setString(2, password+"2");
			pstmt.setInt(3, age+2);
			pstmt.setInt(4, 1);*/
			
			//在执行sql之前必须把数据设置进去
			pstmt.setInt(1, 1);
			
			int result = pstmt.executeUpdate();
			System.out.println("udpate result="+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDQL() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from p_user where id=?";
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("name="+rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, rs);
		}
	}
}

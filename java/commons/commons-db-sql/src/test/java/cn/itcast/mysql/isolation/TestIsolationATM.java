package cn.itcast.mysql.isolation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

public class TestIsolationATM {

	@Test
	public void testATM() {
		
		
		
		
		 
		
		 
		 
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			/*t1:空闲*/
			System.out.println("t1 ATM空闲");
			
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			/* t2: 
			  BEGIN;
			  UPDATE bankaccount SET balance=balance-100 WHERE id='9555500100071120';*/
			String sql = "UPDATE bankaccount SET balance=balance-100 WHERE id='9555500100071120'";
			stmt.executeUpdate(sql);
			
			/* t3:空闲*/
			System.out.println("t3 ATM空闲");
			
			/*t4: 
			  COMMIT;*/
			conn.commit();
			
			 /*t5:空闲 
			 t6:空闲
			 t7:空闲*/
			System.out.println("t5,t6,t7 ATM空闲");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, null);
		}
	}
}












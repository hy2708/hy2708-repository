package cn.itcast.mysql.isolation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 测试在repeatableRead下的情况
 * @author Administrator
 *
 */
public class TestIsolationPhone {

	@Test
	public void testPhone() {
		
		
		
		
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = JDBCUtils.getConnection();
		
		try {
			/*t1:
			  BEGIN;
			  SELECT * FROM bankaccount WHERE id='9555500100071120';*/
			conn.setAutoCommit(false);
			stmt = conn.createStatement();	
			stmt.executeUpdate("SET TRANSACTION ISOLATION LEVEL REPEATABLE READ");
			
			String sql = "SELECT * FROM bankaccount WHERE id='9555500100071120'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("t1 余额为"+rs.getDouble("balance"));
			}
			
			/*	 t2: 空闲*/
			System.out.println("t2 phone 空闲");
			/*	 t3:
				  SELECT * FROM bankaccount WHERE id='9555500100071120';#不会脏读　*/
			sql = "SELECT * FROM bankaccount WHERE id='9555500100071120'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("t3 余额为"+rs.getDouble("balance"));
			}
			
			/*
			 t4: 空闲*/
			System.out.println("t4 phone 空闲");
			
			/*
			 t5:
			  SELECT * FROM bankaccount WHERE id='9555500100071120';#可重复读　没有真正的去表里拿数据*/
			sql = "SELECT * FROM bankaccount WHERE id='9555500100071120'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("t5 余额为"+rs.getDouble("balance"));
			}
			
			/* t6:
			  UPDATE bankaccount SET balance=balance-200 WHERE id='9555500100071120'; //看表中的数据*/		
			sql = "UPDATE bankaccount SET balance=balance-200 WHERE id='9555500100071120'";
			stmt.executeUpdate(sql);
			
			/* t7
			  SELECT * FROM bankaccount;  #幻读*/
			sql = "SELECT * FROM bankaccount WHERE id='9555500100071120'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("t7 余额为"+rs.getDouble("balance"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}
		
		
	}
}












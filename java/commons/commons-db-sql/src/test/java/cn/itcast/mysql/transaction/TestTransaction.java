package cn.itcast.mysql.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * #账户基本信息表 create table account ( accountid varchar(18) , #账号 balance
 * double(10,2) #余额 ) #存款表 create table inaccount ( accountid varchar(18) , #账号
 * inbalance double(10,2) #存入余额 ) #办卡完成，初始化数据 INSERT INTO
 * account(accountid,balance) VALUES('123456789',0)
 * 
 * #向账户中存入100元：
 * INSERT INTO inaccount(accountid,inbalance) VALUES('123456789',100) UPDATE
 * account SET balance=balance+100 WHERE accountid='123456789'
 * 
 * @author Administrator
 * 
 */
public class TestTransaction {

	@Test
	public void testSaveMoney() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 准备数据
		String accountId = "123456789";
		double money = 100;

		try {
			conn = JDBCUtils.getConnection();
			
/*****************************************************/			
			//设置事务为手动提交
			System.out.println("默认事务为"+conn.getAutoCommit());//true代表自动提交,false手动提交
			conn.setAutoCommit(false);
			System.out.println("事务为"+conn.getAutoCommit());
/*****************************************************/		
			
			// 向inaccount表中插入一条记录
			// sql: INSERT INTO inaccount(accountid,inbalance)
			// VALUES('123456789',100)
			String sql = "INSERT INTO inaccount(accountid,inbalance) VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setDouble(2, money);
			pstmt.executeUpdate();//数据马上同步到数据库

			// 更新account表，将指定账号的余额加上100
			// UPDATE account SET balance=balance+100 WHERE
			// accountid='123456789'
			sql = "UPDATE account SET balance=balance+? WHERE accountid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, money);
			pstmt.setString(2, accountId);
			
			//模拟因网络或不明原因出异常
			boolean flag = true;
			if(flag) {
				throw new SQLException("因网络或不明原因出异常!");
			}
			pstmt.executeUpdate();
			
/*****************************************************/			
			//提交事务
			conn.commit();
/*****************************************************/	
			
		} catch (SQLException e) {
			
/*****************************************************/			
			//回滚事务
			try {
				if(conn!=null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
/*****************************************************/
			
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, pstmt, null);
		}
	}
}

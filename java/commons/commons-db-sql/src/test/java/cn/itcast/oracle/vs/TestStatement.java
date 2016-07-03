package cn.itcast.oracle.vs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.oracle.util.OracleJDBCUtils;
/**
 * 对oracle Statement和preparedSatement效率没有什么差异
 * 
 * oracle的效率比mysql强大
 * 对于循环处理来说，statement与preparedStatement差距不大
 * @author Administrator
 *
 */
public class TestStatement {
	/**
	 * 循环保存5000条数据
	 *  msql Statement 2984ms
	 *  oracle Statement time2500
	 *  oracle Statement time2500
	 *  oracle Statement time2438
	 *  
	 *  mysql preparedStatement time=3062ms
	 * oracle preparedStatement time2328
	 * oracle preparedStatement time2125
	 * oracle preparedStatement time2344
	 */
	@Test
	public void testEff() {
		Connection conn = null;
		Statement stmt = null;
		long time = System.currentTimeMillis();
		conn = OracleJDBCUtils.getConnection();
		
		try {
			stmt = conn.createStatement();
			for(int i=0;i<5000;i++) {
				String sql = "INSERT INTO vs_user(id,NAME,PASSWORD,age) VALUES(1,'t','1',1)";
				stmt.executeUpdate(sql);
			}
			System.out.println("oracle Statement time"+(System.currentTimeMillis()-time));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleJDBCUtils.closeResource(conn, stmt, null);
		}
		
		
	}
}









package cn.itcast.mysql.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.mysql.util.JDBCUtils;

/**
 * 测试jdbc中用到的元数据对象 1 DataBaseMetaData 2 ResultSetMetaData
 * 
 * @author Administrator
 * 
 */
public class TestMetaData {

	@Test
	public void testDatabaseMetaData() {
		Connection conn = null;

		conn = JDBCUtils.getConnection();
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			String url = metaData.getURL();
			String productName = metaData.getDatabaseProductName();
			String productVersion = metaData.getDatabaseProductVersion();
			String driverName = metaData.getDriverName();
			String driverVersion = metaData.getDriverVersion();
			System.out.println("url=" + url + " productName=" + productName + " productVersion="
					+ productVersion);
			System.out.println("driverName=" + driverName + " driverVersion=" + driverVersion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testResultSetMetaData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,name,password from m_user");
			/*while (rs.next()) {
				System.out.println("id=" + rs.getInt(1) + " name=" + rs.getString("name")
						+ " password=" + rs.getString("password"));
			}*/
			ResultSetMetaData metaData = rs.getMetaData();
			
			while(rs.next()) {
				for(int i=0;i<metaData.getColumnCount();i++) {
					String columnName = metaData.getColumnName(i+1);
					Object value = rs.getObject(columnName);
					System.out.print(" "+columnName+"="+value);
				}
				System.out.println();
			}
			
			System.out.println("rs中的字段数"+metaData.getColumnCount());
			String columnName = metaData.getColumnName(2);
			System.out.println("第２个字段名称为"+columnName);
			
			String columnType = metaData.getColumnClassName(1);
			System.out.println("第3个字段ClassName为"+columnType);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, stmt, rs);
		}

	}
}

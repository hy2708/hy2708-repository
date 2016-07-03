package org.hy.commons.db.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;


public class DBMetaData {
	
	
	private DBMetaData(Connection connection) {
		super();
		this.connection = connection;
	}

	//	Connection connection = DataSourceUtil.getConnection();
	Connection connection = null;
	
	public static DBMetaData getInstance(Connection connection) {
		return new DBMetaData(connection);
	}
	//@Test
	public void name() throws SQLException {
		DatabaseMetaData dbMetaData = connection.getMetaData();
		ResultSet rs = dbMetaData.getCatalogs();
		while (rs.next()) {
			System.err.println(rs.getString("TABLE_CAT"));
			
		}
		
		dbMetaData.getTables(null, null, null, new String[]{"TABLE","VIEW"});
	}
	
	//@Test
	public void name2() throws SQLException {
		DatabaseMetaData dbMetaData = connection.getMetaData();
		ResultSet rs = dbMetaData.getTables(null, null, null, new String[]{"TABLE","VIEW"});
		while (rs.next()) {
			System.err.println(rs.getString("TABLE_NAME"));
			
		}		
		
	}
	
	//@Test
	public void name3() throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from t_user");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columns = rsMetaData.getColumnCount();
		for (int i = 0; i < columns; i++) {
			System.err.print(rsMetaData.getColumnName(i+1)+"\t");;
		}
		System.err.println();	
		
	}

}

package org.hy.commons.db.metadata.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryRunner {
	

	public QueryRunner(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	DataSource dataSource = null;
	//Connection connection= null;
	private static Logger logger = LoggerFactory.getLogger(QueryRunner.class);

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T>T query(String sql,ResultSetHandler<T> handler,Object... params) {
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		T returnObjecT=null;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setString(1, tableName);
			StringBuilder sb= new StringBuilder();

			for (int i = 0; i < params.length; i++) {				
				stmt.setObject(i+1, params[i]);
				sb.append(params[i]+",");
			}
			if (sb.length()>0) {
				sb.deleteCharAt(sb.length()-1);
			}
			rs = stmt.executeQuery();
			
			returnObjecT =handler.handler(rs);	
			logger.debug("执行的SQL语句是【" +
					sql+"】，参数是【" +
							sb.toString()+"】");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return returnObjecT;		
	}
	
	public <T> void  update(UpdateHandler<T> handler ) {
		
		Connection connection = getConnection();
		//PreparedStatement stmt=null;
		
		try {
			connection.setAutoCommit(false);
			
			handler.handler(connection);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{			
			DataSourceUtil.closeResource(connection, null, null);
		}
				
	}

	
	public void  update(String sql,Object... params) {
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(sql);
			StringBuilder sb= new StringBuilder();
			for (int i = 0; i < params.length; i++) {				
				stmt.setObject(i+1,   params[i]);
				sb.append(params[i]+",");
			}
			if (sb.length()>0) {
				sb.deleteCharAt(sb.length()-1);
			}
			stmt.executeUpdate();					
			connection.commit();
			logger.debug("执行的SQL语句是【" +
					sql+"】，参数是【" +
							sb.toString()+"】");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
				
	}
	
	public void  updateWithoutTransation(Connection connection,String sql,Object... params) throws SQLException {		
		//Connection connection = connection;
		PreparedStatement stmt=null;
		
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {				
				stmt.setObject(i+1, params[i]);
			}
			stmt.executeUpdate();							
				
	}
}

package org.hy.commons.db.jdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.hy.commons.db.jdbc.connection.pool.util.example.ConnPoolUtil;

public class JdbcCrudUtil {
	
	private JdbcCrudUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public static JdbcCrudUtil getInstance(DataSource dataSource) {
		if (jdbcCrudUtil==null) {			
			jdbcCrudUtil = new JdbcCrudUtil(dataSource);
		}
		return jdbcCrudUtil;

	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static JdbcCrudUtil jdbcCrudUtil = null;
	//Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	DataSource dataSource = null;
	
	
	
	public void executeQuery(String sql,CallBack callBack) {
		Connection connection = null;
		connection = getConnection();
				
		try {
			//result = name();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();			
			callBack.doInConnection(rs);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnPoolUtil.closeResource(connection, stmt, rs);
			
		}
		//return (ResultSet) temp[0];
	}
	
	public void executeUpdate(String sql,CallBack callBack) {
		Connection connection = null;
		connection = getConnection();
		try {
			connection.setAutoCommit(false);		
			stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			
			callBack.doInConnection(rs);
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnPoolUtil.closeResource(connection, stmt, rs);
			
		}
		//return (ResultSet) temp[0];
	}
	
	public static void main(String[] args) {
		JdbcCrudUtil dao = new JdbcCrudUtil(new DataSourceUtil().getDataSource());
		dao.executeQuery("select * from t_user", new CallBack() {
			
			@Override
			public void doInConnection(ResultSet rs) {
				try {
					while (rs.next()) {
						System.err.println(rs.getObject("id"));
						System.err.println(rs.getObject("ID"));
						System.err.println(rs.getObject("NAME"));
						System.err.println(rs.getObject("NAME2"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}

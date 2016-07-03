package org.hy.commons.db.metadata.dbutil;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.hy.commons.db.jdbc.connection.datasource.MyDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryRunnerTest {
	QueryRunner queryRunner = null;


	@Before
	public void setUp() throws Exception {
		queryRunner = new QueryRunner(new DataSourceUtil().getDataSource());

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuery() {
		List<Map<String, Object>> list = queryRunner.query("select * from t_user where id=?", new MapListHandler(),1);;
		for (Map<String, Object> map : list) {
			System.err.println(map);
		}
	}

	@Test
	public void testUpdate() {
		
		queryRunner.update("insert into t_user  values (?,?,?,?);" ,103,"a","s",55 );
	}

	@Test
	public void testUpdateWithoutTransation()  {
		Connection connection =null;
		try {
			connection = new DataSourceUtil().getDataSource().getConnection();
			connection.setAutoCommit(false);
			queryRunner.updateWithoutTransation(connection,"insert into t_user  values (?,?,?,?);" ,111,"a","s",55 );
			queryRunner.updateWithoutTransation(connection,"insert into t_user  values (?,?,?,?);" ,107,"a","s","f" );
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

	
	@Test
	public void testUpdateWithoutTransation2()  {
		queryRunner.update(new UpdateHandler() {

			@Override
			public Object handler(Connection connection) throws SQLException {
				queryRunner.updateWithoutTransation(connection,"insert into t_user  values (?,?,?,?);" ,111,"a","s",55 );
				queryRunner.updateWithoutTransation(connection,"insert into t_user  values (?,?,?,?);" ,107,"a","s","f" );
				return null;
			}
			
		});
	}

	
}

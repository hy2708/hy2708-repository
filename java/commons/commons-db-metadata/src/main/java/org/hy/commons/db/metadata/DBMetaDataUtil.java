package org.hy.commons.db.metadata;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.hy.commons.db.metadata.dbutil.BeanListHandler;
import org.hy.commons.db.metadata.dbutil.MapListHandler;
import org.hy.commons.db.metadata.dbutil.ResultSetHandler;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBMetaDataUtil {
	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//	Connection connection = DataSourceUtil.getConnection();
	Connection connection = null;
	DataSource dataSource = null;
	private static DBMetaDataUtil dbMetaDataUtil = null;
	private static Logger logger = LoggerFactory.getLogger(DBMetaDataUtil.class);
	
	@Deprecated
	private DBMetaDataUtil(Connection connection) {
		super();
		this.connection = connection;
	}
	
	private DBMetaDataUtil(DataSource dataSource) {
		super();
		this.dataSource=dataSource;
		
	}
	
	public static DBMetaDataUtil getInstance(Connection connection) {
		if (dbMetaDataUtil==null) {
			dbMetaDataUtil = new DBMetaDataUtil(connection);
		}
		return dbMetaDataUtil;
	}
	public static DBMetaDataUtil getInstance(DataSource dataSource) {
		if (dbMetaDataUtil==null) {
			dbMetaDataUtil = new DBMetaDataUtil(dataSource);
		}
		return dbMetaDataUtil;
	}
	
	
	
	//@Test
	public List<String> getDatabases() {
		Connection connection = getConnection();
		DatabaseMetaData dbMetaData;
		ResultSet rs = null;
		List<String> databaseNames = new LinkedList<String>();
		try {
			dbMetaData = connection.getMetaData();
			rs = dbMetaData.getCatalogs();
			while (rs.next()) {
				databaseNames.add(rs.getString("TABLE_CAT"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeResource(connection, null, rs);

		}
		return databaseNames;
		
	}
	
	public List<String> getTablesNames(){
		return getTablesNames(null);
	}

	//@Test
	public List<String> getTablesNames(String databaseName){
		List<String> list = new ArrayList<String>();
		Connection connection = getConnection();

		DatabaseMetaData dbMetaData=null;
		ResultSet rs = null;
		try {
			
			dbMetaData = connection.getMetaData();
			rs = dbMetaData.getTables(databaseName, databaseName, null, new String[]{"TABLE"
					//,"VIEW"
			});
			while (rs.next()) {
				String tableName =rs.getString("TABLE_NAME");
				logger.debug("数据库表为【" +
						tableName+
						"】"
						);
				list.add(tableName);
				
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeResource(connection, null, rs);
		}
		return list;
		
	}
	
	
	
	//@Test
	public List<String> getTableColumnNames(String tableName) {
		List<String> list = new ArrayList<String>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("select * from "+tableName);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columns = rsMetaData.getColumnCount();
			StringBuffer sb= new StringBuffer();
			for (int i = 0; i < columns; i++) {
				list.add(rsMetaData.getColumnName(i+1));
				sb.append(rsMetaData.getColumnName(i+1)+"\t");;
			}
			logger.debug(sb.toString());	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return list;
		
	}
	
	public static List<String> getTableColumnNames(ResultSet rs) {
		List<String> list = new ArrayList<String>();
		
		try {			
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columns = rsMetaData.getColumnCount();
			StringBuffer sb= new StringBuffer();
			for (int i = 0; i < columns; i++) {
				list.add(rsMetaData.getColumnName(i+1));
				sb.append(rsMetaData.getColumnName(i+1)+"\t");;
			}
			logger.debug(sb.toString());	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	//@Test
	public Map<String,Integer> getTableColumnNamesAndTypes(String tableName) {
		//List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		Map<String, Integer> temp = null;
		try {
			stmt = connection.prepareStatement("select * from "+tableName);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columns = rsMetaData.getColumnCount();
			StringBuffer sb= new StringBuffer();
			for (int i = 0; i < columns; i++) {
				temp = new HashMap<String, Integer>();
				temp.put(rsMetaData.getColumnName(i+1), rsMetaData.getColumnType(i+1));
				
				sb.append(rsMetaData.getColumnName(i+1)+"\t");;
			}
			logger.debug(sb.toString());	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return temp;
		
	}
	
	public <T> List<T> query00(String tableName,Class T) throws Exception, IllegalAccessException, Exception {
		Map<String,Integer> tableColumnsMap = getTableColumnNamesAndTypes(tableName);
		List<T> list = new ArrayList<T>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("select * from "+tableName);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				//ReflectionUtil.
				System.err.println(T.getName());
				T object = (T) Class.forName(T.getName()).newInstance();
				//String paramType = rs.getMetaData().getColumnClassName(0);
				//Class<?> paramTypeClass00 = Class.forName(paramType);
				Method[] methods = ReflectionUtil.getDeclaredAllMethods(object);

				//遍历所有set方法
				String methodName = null;
				for (Method method : methods) {
					methodName =method.getName();
					if (methodName.startsWith("set")) {	
						
						//从set方法中，截取变量名称，
						String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
						//如果表中，有，与之对应的字段
						if (getTableColumnNames(tableName).contains(fieldName.toLowerCase())) {							
							//再重结果集中，获得数据
							//如果数据不是空
							//用反射调用set方法
							//Class<?> paramTypeClass = object.getClass().getMethod("g"+methodName.substring(1)).getReturnType();
							method.invoke(object, rs.getObject(fieldName));
						}
					}					
				}
				
				list.add(object);
			}
			System.err.println(list.size());	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return list;
		
	}

	
	public <T> List<T> query22(String sql,Class T) throws Exception, IllegalAccessException, Exception {
		String tableName = SQLUtil.getTableName(sql);
		List<T> list = new ArrayList<T>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				//ReflectionUtil.
				System.err.println(T.getName());
				T object = (T) Class.forName(T.getName()).newInstance();
				//String paramType = rs.getMetaData().getColumnClassName(0);
				//Class<?> paramTypeClass00 = Class.forName(paramType);
				Method[] methods = ReflectionUtil.getDeclaredAllMethods(object);

				//遍历所有set方法
				String methodName = null;
				for (Method method : methods) {
					methodName =method.getName();
					if (methodName.startsWith("set")) {	
						
						//从set方法中，截取变量名称，
						String fieldName = methodName.substring(3,4).toLowerCase()+methodName.substring(4);
						//如果表中，有，与之对应的字段
						if (getTableColumnNames(tableName).contains(fieldName.toLowerCase())) {							
							//再重结果集中，获得数据
							//如果数据不是空
							//用反射调用set方法
							//Class<?> paramTypeClass = object.getClass().getMethod("g"+methodName.substring(1)).getReturnType();
							method.invoke(object, rs.getObject(fieldName));
						}
					}					
				}
				
				list.add(object);
			}
			System.err.println(list.size());	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return list;
		
	}

	
	public <T> List<T> query33(String sql,BeanListHandler<T> handler) throws Exception, IllegalAccessException, Exception {
		String tableName = SQLUtil.getTableName(sql);
		List<T> list = new ArrayList<T>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			handler.handler(rs);				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return list;		
	}

	public <T>T query(String sql,ResultSetHandler<T> handler) throws Exception, IllegalAccessException, Exception {
		
		Connection connection = getConnection();
		System.err.println("11111111111111111");
		PreparedStatement stmt=null;
		ResultSet rs = null;
		T returnObjecT=null;
		try {
			stmt = connection.prepareStatement(sql);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			System.err.println("nnnnnnnnnnnnnnnnnnnnnnnnn");
			returnObjecT =handler.handler(rs);				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return returnObjecT;		
	}
	
	//@Test
	public List<Map<String, Object>> getRecordsFromTable(String tableName) {
		Map<String,Integer> tableColumnsMap = getTableColumnNamesAndTypes(tableName);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Connection connection = getConnection();
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement("select * from "+tableName);
			//stmt.setString(1, tableName);
			rs = stmt.executeQuery();
			Map<String, Object> temp = null;
			while (rs.next()) {
				temp = new HashMap<String, Object>();
				getRecord(rs, temp, tableColumnsMap);
				list.add(temp);
			}
			System.err.println(list.size());	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{			
			DataSourceUtil.closeResource(connection, stmt, rs);
		}
		return list;
		
	}
	
	private Map<String, Object> getRecord(ResultSet rs,Map<String, Object> tempRecord,Map<String, Integer> tableColumnsMap) throws SQLException {
		
		for (String tableColumn : tableColumnsMap.keySet()) {			
			int type = tableColumnsMap.get(tableColumn);
			Object value = null;
//			switch (type) {
//				case Types.INTEGER: 	
//					value =rs.getInt(tableColumn);							
//					break;
//				case Types.SMALLINT: 	
//					value =rs.getShort(tableColumn);							
//					break;
//				case Types.VARCHAR:
//					value =rs.getString(tableColumn);
//					break;
//					
//				default:
//					throw new RuntimeException("  "+type);
//					//break;
//			}
			tempRecord.put(tableColumn, rs.getObject(tableColumn));
			
		}
		return tempRecord;

	}
	
	
	
	public Map<String,String> matchTableColumnNamesAndEntityProperties(String tableName,Class<?> clazz) {
		//List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
//		Connection connection = getConnection();
//		PreparedStatement stmt=null;
//		ResultSet rs = null;
//		Map<String, Integer> temp = null;
//		List<String> propertyNames =EntityBeanUtil.getEntityPropertyNames();
//		try {
//			stmt = connection.prepareStatement("select * from "+tableName+" limit(0,1)");
//			//stmt.setString(1, tableName);
//			rs = stmt.executeQuery();
//			ResultSetMetaData rsMetaData = rs.getMetaData();
//			int columns = rsMetaData.getColumnCount();
//			StringBuffer sb= new StringBuffer();
//			for (int i = 0; i < columns; i++) {
//				temp = new HashMap<String, Integer>();
//				int index = contains(propertyNames, rsMetaData.getColumnName(i+1));
//				if (index!=-1) {
//					propertyNames.remove(index);
//				}
//				temp.put(rsMetaData.getColumnName(i+1), );
//				
//				sb.append(rsMetaData.getColumnName(i+1)+"\t");;
//			}
//			logger.debug(sb.toString());	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{			
//			DataSourceUtil.closeResource(connection, stmt, rs);
//		}
		return null;
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception, Exception {
		DBMetaDataUtil dbMetaDataUtil = DBMetaDataUtil.getInstance(new DataSourceUtil().getDataSource());
		
//		List<User> list =dbMetaDataUtil.query("select * from t_user",new BeanListHandler<User>(User.class));
//		EntityBeanUtil.printEntities(list);
		List list =dbMetaDataUtil.query("select * from t_user",new MapListHandler());
		System.err.println(list.size());
	}
	public void name() {
//		DBMetaDataUtil.getInstance(new DataSourceUtil().getConnection()).getTableColumnNames("t_user");
		DBMetaDataUtil.getInstance(new DataSourceUtil().getDataSource()).getDatabases();
//		DBMetaDataUtil.getInstance(new DataSourceUtil().getDataSource()).getTablesNames();
		DBMetaDataUtil.getInstance(new DataSourceUtil().getDataSource()).getRecordsFromTable("t_user");
	}

}

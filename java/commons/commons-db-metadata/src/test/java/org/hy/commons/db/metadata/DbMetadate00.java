package org.hy.commons.db.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hy.commons.db.jdbc.connection.datasource.DataSourceUtil;
import org.junit.Test;


public class DbMetadate00 {
	@Test
	public void dbm() throws Exception{
		Connection con = new  DataSourceUtil().getConnection();
		DatabaseMetaData dm= con.getMetaData();
//		ResultSet rs= dm.getCatalogs();//获取所有数据库名称
//		while(rs.next()){
//			String name = rs.getString("TABLE_CAT");
//			System.err.println(name);
//		}
//		System.err.println("======================");
		String dbName = dm.getDatabaseProductName();//数据库名称
		System.err.println(dbName);
		System.err.println("数据库中有多少表：");
		ResultSet rs2 = dm.getTables("test","test",null,new String[]{"TABLE"});
		while(rs2.next()){
			String tableName = rs2.getString("TABLE_NAME");
			System.err.println(tableName);
		}
	}
	@Test
	public void rs2() throws Exception{
		Connection con =new  DataSourceUtil().getConnection();
		//转到exam数据库中去
		Statement st = con.createStatement();
		st.execute("use exam");
		//查询
		String sql = "select * from dept";
		ResultSet rs = st.executeQuery(sql);
		//对rs结果集进行分析
	  	ResultSetMetaData rsmd=rs.getMetaData();
		//获取有几个列
	  	int cols = rsmd.getColumnCount();
	  	System.err.println(cols);
		//获取每一个字段名
	  	List<String> colNames = new ArrayList<String>();//保存所有的字段
	  	for(int i=0;i<cols;i++){
	  		String colName = rsmd.getColumnName(i+1);
	  		System.err.print(colName+"\t\t");
	  		colNames.add(colName);
	  	}
	  	System.err.println();
	  	//获取数据
	  	while(rs.next()){
	  		for(String nm:colNames){//遍历一行中的所列
	  			String val = rs.getString(nm);
	  			System.err.print(val+"\t\t");
	  		}
	  		System.err.println();
	  	}
	  	
		con.close();
	}
}

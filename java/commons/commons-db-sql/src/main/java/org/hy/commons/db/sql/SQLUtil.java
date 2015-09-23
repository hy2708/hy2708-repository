package org.hy.commons.db.sql;

public class SQLUtil {

	public static StringBuilder createDatabase(String databaseName) {
		//生成数据库字符串
		String db = "drop database if exists "+databaseName+"; " +
				"create database "+databaseName+"    character set utf8;" +
				"use  "+databaseName+" ;";
		return db;
	}
	
	public static StringBuilder createTable(Class<?> clazz){
		StringBuilder sb = new StringBuilder();
		//生成表字符串
		String table = "create table t_user( " +
						" id int not null,"+
						" name varchar(32),"+
						" password varchar(32),"+
						" age int ,"+
						" constraint pk primary key (id)"+
						");";
		sb.append(table);
		sb.append("\n");
	}
}

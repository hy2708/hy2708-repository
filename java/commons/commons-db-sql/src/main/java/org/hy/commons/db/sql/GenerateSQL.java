package org.hy.commons.db.sql;

import java.io.File;
import java.io.PrintWriter;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.EntityBeanUtil;
import org.hy.commons.lang.RandomUtil;

public class GenerateSQL {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-27；时间：上午9:59:05</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 * @return 
	 */
	public static void main(String[] args) {
		String databaseName = "test";
		//创建文件
		File initFile = FileUtil.createFile(ProjectPathUtil.getProjectResourcesDirPath()+File.separator+databaseName+"_init.sql");
		
		PrintWriter writer = IoUtil.getPrintWriter(initFile.getAbsolutePath(), false, "utf8");
		writer.write(createDatabase(databaseName));
		writer.write("\n");
		writer.write(initTableAndDatas().toString());
		writer.write(initTableAndDatas2().toString());
		writer.flush();
		writer.close();
	}
	
	public static String createDatabase(String databaseName){
		//生成数据库字符串
				String db = "drop database if exists "+databaseName+"; " +
						"create database "+databaseName+"    character set utf8;" +
						"use  "+databaseName+" ;";
		return db;
	}
	
	public static StringBuilder initTableAndDatas(){
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
		//生成初始化数据字符串
		String temp =null;
		for (int i = 1; i < 11; i++) {			
			temp = EntityBeanUtil.randomUsername();
					sb.append("insert into t_user values ( '" +
						i +	"' ," +
						"'" +
						temp+
						" '," +
							
						"'" +
						temp+
						" '," +
							
						"'" +
						EntityBeanUtil.randomPersonAge() +
						"' );");
					sb.append("\n");
		}
		return sb;
				
	}
	
	public static StringBuilder initTableAndDatas2(){
		StringBuilder sb = new StringBuilder();
		//生成表字符串
		String table = "create table t_contact( " +
						" id int not null,"+
						" name varchar(32),"+
						" sex varchar(10) ,"+
						" tel varchar(32) ,"+
						" email varchar(32) ,"+
						" user_id int ,"+
						" constraint pk primary key (id) ," +
						" constraint fk foreign key (user_id) references t_user(id) "+
						");";
		sb.append(table);
		sb.append("\n");
		//生成初始化数据字符串
		for (int i = 1; i < 21; i++) {			
					sb.append("insert into t_contact values ( '" +
							i +
							"' ," +
							
							"'" +
							EntityBeanUtil.randomPersonName()+
							" '," +
							

							"'" +
							EntityBeanUtil.randomSex()+
							" '," +

							"'" +
							RandomUtil.getRandomDigital(8)+
							" '," +
							
							"'" +
							EntityBeanUtil.randomEMail()+
							" '," +
							
							"'" +
							(EntityBeanUtil.randomInteger(10)+1)+
							
							"' );");
					sb.append("\n");
		}
		return sb;
				
	}

}

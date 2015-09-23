package org.hy.commons.db.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.EntityBeanUtil;
import org.hy.commons.lang.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GenerateSQL0 {
	static Logger logger = LoggerFactory.getLogger(GenerateSQL.class);
	static String[] firstName = new String[]{"张","刘","牛","李","吕","付"
			,"副","王","汪","赵","孔","谭","贪","夏侯","令狐","上官","欧阳"
			,"司马","诸葛","曹","关","孙","甘","花"};
	static String[] centerName = {"立","祝","共","都","高","陆","恶","人","达","玉","莫","靓","宇"};
	static String[] lastName = {"强","颖","备","亮","云","正","冲","兄弟","大","小","关"
			,"撒旦","立","玉","鱼","牛","泵","秒","米","个","鐜","惇","彦","另","琳","浩",
			"皓","永锋","明正","丽音","志峰","春"};
	static Random ran = new Random();
	static String begin = "1970-01-01";
	static String end = "1990-12-30";
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws IOException {
		String resourcesDirPath =ProjectPathUtil.getProjectResourcesDirPath();
		String databaseName = "test";
		String filepath = resourcesDirPath+"/" +databaseName"_init.sql";
				generateDatabase(filepath,databaseName);
				generate(filepath, true);
	}
	
	public static void generateDatabase(String filepath,String databaseName) throws IOException {
		String sql = null;
		PrintWriter out = null;
		try {
			//out = new PrintWriter(new File("d:/sql_script/stu/insert_stu.sql"));
			File sqlFile = FileUtil.createFile(filepath);
			out =IoUtil.getPrintWriter(filepath, false, "utf8");		
			out.println("create database " +
					databaseName +
					" character set " +
					"utf8" +
					" ;");
			out
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out!=null) out.close();
		}
	}
	
	public static void generate(String filepath,Boolean fileAppend) throws IOException {
		String sql = null;
		PrintWriter out = null;
		try {
			
			File sqlFile =  FileUtil.createFile(filepath);
			out =IoUtil.getPrintWriter(filepath, fileAppend, "utf-8");
			
			String tableSchema = "drop table if  exists `t_stu`;"
					+
					"create table `t_stu`(" +
					
					 "`id` int(10) primary key auto_increment , " +
					"`name` varchar(50)," +
					"`no` varchar(50)," +
					"`sex` varchar(10)," +
					"`born` datetime," +
					 
					"`cla_id` int(10)" + 
					// "`id` int(11) NOT NULL AUTO_INCREMENT" + 
					");"
					;
			out.println(tableSchema);
			for(int i=0;i<700;i++) {
				sql = "insert into t_stu values (null,'"+ranName()+"','"+i+"','"+ranSex()+"','"+ranBorn()+"',"+randomRange(1, 13)+");";
				out.println(sql);
				logger.debug(sql);
			}
			
			for(int i=0;i<50;i++) {
				sql = "insert into t_stu values (null,'"+ranName()+"','"+(701+i)+"','"+ranSex()+"','"+ranBorn()+"',null);";
				out.println(sql);
				logger.debug(sql);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out!=null) out.close();
		}
	}
	
	public static long randomRange(long start,long end) {
		return (long)(Math.random()*(end-start)+start);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：随机获得出生日期</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-8；时间：下午8:44:19</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	private static String ranBorn() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String begin = "1970-01-01";
		String end = "1990-12-30";
		
		String str = null;
		try {
			Date sd = sdf.parse(begin);
			Date ed = sdf.parse(end);
			long t = randomRange(sd.getTime(), ed.getTime());
			Date d = new Date(t);
			str = sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：随机获得性格</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-8；时间：下午8:42:02</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	private static String ranSex() {
		if(ran.nextInt(2)==0) {
			return "男";
		}
		return "女";
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获得随机的名字</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-8；时间：下午8:41:39</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	private static String ranName() {
		
		int num = ran.nextInt(5);
		if(num<2) {
			//三个字
			return firstName[ran.nextInt(firstName.length)]
			                 +centerName[ran.nextInt(centerName.length)]
			                 +lastName[ran.nextInt(lastName.length)];
		} else {
			//2个字
			return firstName[ran.nextInt(firstName.length)]
			                 +lastName[ran.nextInt(lastName.length)];
		}
	}
}

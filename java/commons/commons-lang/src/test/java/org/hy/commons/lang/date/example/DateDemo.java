package org.hy.commons.lang.date.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hy.commons.lang.example.entity.Employee;


public class DateDemo {
	public static void main(String[] args) throws Exception {

		// 从 1970 1,1 00:00
		System.out.println(System.currentTimeMillis());// 1343008846203
														// 1343008853015

		Date d = new Date();
		System.out.println(d);

		d = new Date(System.currentTimeMillis());// 根据你自己写的毫秒数来得到这个毫秒数表示的时间
		System.out.println(d);

		/**
		 * boolean after(Date when) 测试此日期是否在指定日期之后。 boolean before(Date when)
		 * 测试此日期是否在指定日期之前。
		 **/
		//Tue Jul 23 10:07:06 CST 2013
		// 2012-07-23 10:07:06 周一 
		
		//java.text.SimpleDateFormat用来格式化日期
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String pattern = "yyyy-M-d HH:mm:ss E";//时间的格式模板
		
		/*
		 * 把时间格式应用到  时间格式化对象上
		 * 	1.SimpleDateFormat(String pattern)   用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
		 * 		new SimpleDateFormat(pattern);
		 *  2. SimpleDateFormat sdf = new SimpleDateFormat();
		 *  	sdf.applyPattern(pattern);    将给定模式字符串应用于此日期格式。 
		 * */
		
		sdf.applyPattern(pattern);
		
		//格式化操作:
		
		// String format(Date date) 将一个 Date 格式化为日期/时间字符串。
		
		
		//Date  -->  String 时间
		String dd = sdf.format(new Date());//日期字符串
		
		System.out.println(dd);
		
		
		//2013-7-23 10:21:57 星期二得按照 "yyyy-M-d HH:mm:ss E"格式解析回来
		//解析日期字符串,  String时间  --> Date
		sdf  = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
		
		// Date parse(String source)      从给定字符串的开始解析文本，以生成一个日期。 
		
		Date ddd = sdf.parse(dd);
		System.out.println(ddd);

		
		//更新修改时间
		new  Employee().setUpdateDate(new Date());
	}
}

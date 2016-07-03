/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-9</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang.date ;
//24
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import jodd.datetime.TimeUtil;

import org.hy.commons.lang.string.StringUtil;
import org.hy.commons.log.lf4j.Slf4jLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.hy.enterprise.framework.util.logger.Slf4jLoggerUtil;

//import org.jboss.seam.log.LogProvider;
//import org.jboss.seam.log.Logging;
//import org.joda.time.DateTime;
//import org.joda.time.Days;

//import com.vsoft.libra.enterprise.framework.util.logger.SeamLoggerUtil;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-9</li>
 * <li>设计时间：下午04:13:27</li>
 * <li>设计目的：时间处理助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class DateUtil
{
	/**
	 * 日志记录器
	 */
//	private static LogProvider	logger	         =   Logging    .getLogProvider ( DateUtil.class ) ;
	private static Logger	logger	         =   LoggerFactory.getLogger( DateUtil.class ) ;

	public static final String	DATE_FORMAT	     =
	                                               "yyyy-MM-dd" ;

	public static final String	DATE_TIME_FORMAT	=
	                                                  "yyyy-MM-dd HH:mm:ss" ;

	public static final String	TIME_FORMAT	     =
	                                               "HH:mm:ss" ;

	public static final String	TIMESTAMP_FORMAT	=
	                                                  "yyyy-MM-dd HH:mm:ss.S" ;

	
	public static void main(String[] args) {
		System.err.println(getGMTTime());
	}
	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:26:12</li>
	 * <li>设计目的：为当前日期加上指定数量的季度</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @param quarterDelta
	 * @return
	 */
	public static Calendar addQuarter(Calendar calendar, int quarterDelta) {
		int month = calendar.get(Calendar.MONTH);
		int quarter = month / 3;

		Calendar startMonth = new GregorianCalendar(
				calendar.get(Calendar.YEAR), quarter * 3, 1);
		startMonth.add(Calendar.MONTH, quarterDelta * 3);

		return startMonth;
	}


	public static Calendar addTime(Calendar calendar,
			Integer day,Integer hour,Integer minute,Integer second) {
		// 日历
		Calendar cl = Calendar.getInstance();
		if (day !=null) {			
		// 日历上，加7天
			cl.add(Calendar.DATE, day);
		}
		if (hour !=null) {			
			cl.add(Calendar.HOUR, hour);
		}
		if (minute!=null) {			
			cl.add(Calendar.MINUTE, minute);
		}
		if (second!=null) {			
			cl.add(Calendar.SECOND, second);
		}
		
		return cl;
		
	}
	
	public static Calendar addTime(Date date,
			Integer day,Integer hour,Integer minute,Integer second) {
		return addTime(getCalendar(date), day, hour, minute, second);
	}

	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:53:15</li>
	 * <li>设计目的：以默认格式将指定日期转换为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return DateUtil.format(date, "yyyy-MM-dd");
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:05:23</li>
	 * <li>设计目的：将给定日期对象按照指定日期格式化方式格式化为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String format(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}
		DateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(date);
	}

	

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:54:01</li>
	 * <li>设计目的：以默认格式将时间戳格式化为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String formatTimestamp (
	                                       Date date )
	{
		return DateUtil
		               .formatTimestamp (
		                                  date ,
		                                  "yyyy-MM-dd H:m:s" ) ;

	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:56:34</li>
	 * <li>设计目的：以指定格式将时间戳格式化为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @param timestampFormat
	 * @return
	 */
	public static String formatTimestamp (
	                                       Date date ,
	                                       String timestampFormat )
	{
		SimpleDateFormat simpleDateFormat =
		                                    new SimpleDateFormat (
		                                                           timestampFormat ) ;
		return simpleDateFormat
		                       .format ( date ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:21:35</li>
	 * <li>设计目的：转换{@link java.util.Date}为{@link java.util.Calendar}类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar;
	}
	
	public static Calendar getCalendar(Long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);

		return calendar;
	}
	
	public static Calendar getCalendarInstance() {
		Calendar calendar = Calendar.getInstance();
		return calendar;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义： 从 1970 1,1 00:00开始到现在的毫秒</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-2；时间：下午2:57:03</li>
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
	public static long getCurrentTimeMillis() {    
		return System.currentTimeMillis();
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：把Date类型数据，转换成，Long类型数据</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-2；时间：上午11:51:39</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param date
	 * @return
	 * @return
	 */
	public static long getMilliseconds(Date date) {    
		
		return date.getTime();
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：把Calendar类型数据，转换成，Long类型数据</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-2；时间：上午11:52:23</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param calendar
	 * @return
	 * @return
	 */
	public static long getMilliseconds(Calendar calendar) {    
		return calendar.getTimeInMillis();
	}
	
	public static long getMilliseconds(Calendar from,Calendar to) {    
		return (to.getTimeInMillis()-from.getTimeInMillis());
	}
	
	public static long getSeconds(Calendar calendar) {    
		return calendar.getTimeInMillis()/1000;
	}
	
	public static long getSeconds(Date date) {    
		return getMilliseconds(date)/1000;
	}
	
	public static long getSeconds(Calendar from,Calendar to) {    
		return (to.getTimeInMillis()-from.getTimeInMillis())/1000;
	}
	
	
	
	public static long getSeconds(Date from,Date to) {    
		return (to.getTime()-from.getTime())/1000;
	}

	public static Date getDate(long l) {    
		return new Date(l);// 根据你自己写的毫秒数来得到这个毫秒数表示的时间
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-3；时间：下午6:37:51</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param calendar
	 * @return
	 * @return
	 */
	public static Date getDate(Calendar calendar) {    
		return calendar.getTime();
	}

	public static Calendar setCalendar(int year,int month,int  date,int hourOfDay,int minute,int second) {    
		Calendar calendar =  Calendar.getInstance();
		calendar.set(year, month, date, hourOfDay, minute, second);
		return calendar;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:22:47</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateEndForDisplay (
	                                          Date date )
	{
		Calendar calendar ;

		if ( date != null )
		{
			calendar =
			           new GregorianCalendar ( ) ;

			calendar
			        .setTime ( date ) ;
			calendar
			        .add (
			               Calendar.HOUR ,
			               - 12 ) ;

			return calendar
			               .getTime ( ) ;
		}
		else
		{
			return null ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:16:17</li>
	 * <li>设计目的：获取指定日期所在月的天数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @return
	 */
	public static int getDaysInMonth (
	                                   Calendar calendar )
	{
		Calendar cloneCendar ;

		cloneCendar =
		              ( Calendar ) calendar
		                                   .clone ( ) ;

		cloneCendar
		           .set (
		                  Calendar.DAY_OF_MONTH ,
		                  1 ) ;
		cloneCendar
		           .add (
		                  Calendar.MONTH ,
		                  1 ) ;
		cloneCendar
		           .add (
		                  Calendar.DAY_OF_MONTH ,
		                  - 1 ) ;

		return cloneCendar
		                  .get ( Calendar.DATE ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:17:38</li>
	 * <li>设计目的：获取指定日期所在月的天数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @return
	 */
	public static int getDaysInMonth ( Date calendar   //DateTime calendar 
			)
	{
		/*DateTime start =
		                 new DateTime (
		                                calendar
		                                        .getYear ( ) ,
		                                calendar
		                                        .getMonthOfYear ( ) ,
		                                1 ,
		                                0 ,
		                                0 ,
		                                0 ,
		                                0 ) ;
		DateTime end =
		               start
		                    .plusMonths ( 1 ) ;

		Days days =
		            Days
		                .daysBetween (
		                               start ,
		                               end ) ;

		return days
		           .getDays ( ) ;*/
		throw new RuntimeException();
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:18:54</li>
	 * <li>设计目的：将当前日期转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getDisplayDate ( )
	{
		return DateUtil
		               .getDisplayDate ( new Date ( ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:17:44</li>
	 * <li>设计目的：将指定日期转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @return
	 */
	public static String getDisplayDate (
	                                      Calendar calendar )
	{
		SimpleDateFormat simpleDateFormat =
		                                    new SimpleDateFormat (
		                                                           "yyyy-MM-dd" ) ;
		if ( calendar != null )
		{
			return simpleDateFormat
			                       .format ( calendar
			                                         .getTime ( ) ) ;
		}
		else
		{
			return "" ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:16:23</li>
	 * <li>设计目的：将指定日期转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @param dateFormat
	 * @return
	 */
	public static String getDisplayDate (
	                                      Calendar calendar ,
	                                      String dateFormat )
	{
		SimpleDateFormat simpleDateFormat =
		                                    new SimpleDateFormat (
		                                                           dateFormat ) ;
		if ( calendar != null )
		{
			return simpleDateFormat
			                       .format ( calendar
			                                         .getTime ( ) ) ;
		}
		else
		{
			return "" ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:18:39</li>
	 * <li>设计目的：将指定日期转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getDisplayDate (
	                                      Date date )
	{
		Calendar calendar =
		                    Calendar
		                            .getInstance ( ) ;
		calendar
		        .setTime ( date ) ;
		return DateUtil
		               .getDisplayDate (
		                                 calendar ,
		                                 "yyyy-MM-dd" ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:20:07</li>
	 * <li>设计目的：将当前日期时间转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getDisplayDateTime ( )
	{
		return DateUtil
		               .getDisplayDateTime ( new Date ( ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:19:51</li>
	 * <li>设计目的：将指定日期时间转换为显示用的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static String getDisplayDateTime (
	                                          java.util.Date date )
	{
		Calendar calendar =
		                    Calendar
		                            .getInstance ( ) ;
		calendar
		        .setTime ( date ) ;
		return DateUtil
		               .getDisplayDate (
		                                 calendar ,
		                                 "yyyy-MM-dd hh:mm:ss" ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午01:21:01</li>
	 * <li>设计目的：获取相隔天数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param beforedate
	 * @param afterdate
	 * @return
	 * @throws ParseException
	 */
	public static long getDistinceDay (
	                                    Date beforedate ,
	                                    Date afterdate )
	                                                    throws ParseException
	{
		long dayCount =
		                0 ;
		try
		{
			dayCount =
			           ( afterdate
			                      .getTime ( ) - beforedate
			                                               .getTime ( ) )
			                   / ( 24 * 60 * 60 * 1000 ) ;
		}
		catch ( Exception exception )
		{
			//SeamLoggerUtil .error (
				Slf4jLoggerUtil.error (
			                       DateUtil.logger ,
			                       "日期解析错误" ,
			                       exception ) ;
		}
		return dayCount ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午01:19:21</li>
	 * <li>设计目的：获取相隔天数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param beforedate
	 * @return
	 * @throws ParseException
	 */
	public static long getDistinceDay (
	                                    String beforedate )
	                                                       throws ParseException
	{
		return DateUtil
		               .getDistinceDay (
		                                 beforedate ,
		                                 DateUtil
		                                         .getDisplayDate ( ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午01:23:39</li>
	 * <li>设计目的：获取相隔天数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param beforedate
	 * @param afterdate
	 * @return
	 * @throws ParseException
	 */
	static public long getDistinceDay (
	                                    String beforedate ,
	                                    String afterdate )
	                                                      throws ParseException
	{
		SimpleDateFormat simpleDateFormat =
		                                    new SimpleDateFormat (
		                                                           "yyyy-MM-dd" ) ;
		long dayCount =
		                0 ;
		try
		{
			Date date1 =
			             simpleDateFormat
			                             .parse ( beforedate ) ;
			Date date2 =
			             simpleDateFormat
			                             .parse ( afterdate ) ;
			dayCount =
			           ( date2
			                  .getTime ( ) - date1
			                                      .getTime ( ) )
			                   / ( 24 * 60 * 60 * 1000 ) ;
		}
		catch ( ParseException parseException )
		{
			//SeamLoggerUtil
			Slf4jLoggerUtil
			.error (
			                       DateUtil.logger ,
			                       "日期解析错误" ,
			                       parseException ) ;
		}
		return dayCount ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午01:17:16</li>
	 * <li>设计目的：获取相隔时间数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param beforeDateTime
	 * @param afterDateTime
	 * @return
	 * @throws ParseException
	 */
	public static long getDistinceTime (
	                                     String beforeDateTime ,
	                                     String afterDateTime )
	                                                           throws ParseException
	{
		SimpleDateFormat simpleDateFormat =
		                                    new SimpleDateFormat (
		                                                           "yyyy-MM-dd hh:mm:ss" ) ;
		long timeCount =
		                 0 ;
		try
		{
			Date d1 =
			          simpleDateFormat
			                          .parse ( beforeDateTime ) ;
			Date d2 =
			          simpleDateFormat
			                          .parse ( afterDateTime ) ;

			timeCount =
			            ( d2
			                .getTime ( ) - d1
			                                 .getTime ( ) )
			                    / ( 60 * 60 * 1000 ) ;

		}
		catch ( ParseException parseException )
		{
			///SeamLoggerUtil
			Slf4jLoggerUtil              .error (
			                       DateUtil.logger ,
			                       "日期解析错误" ,
			                       parseException ) ;
			throw parseException ;
		}
		return timeCount ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:19:25</li>
	 * <li>设计目的：获取指定地区日期格式</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param dateLocale
	 * @return
	 */
	public static String getPatternForDateLocale (
	                                               Locale dateLocale )
	{
		Calendar calendar =
		                    new GregorianCalendar ( ) ;
		calendar
		        .set (
		               Calendar.MONTH ,
		               4 ) ;
		calendar
		        .set (
		               Calendar.DAY_OF_MONTH ,
		               30 ) ;
		calendar
		        .set (
		               Calendar.YEAR ,
		               2007 ) ;

		String formatted =
		                   DateFormat
		                             .getDateInstance (
		                                                DateFormat.SHORT ,
		                                                dateLocale )
		                             .format (
		                                       calendar
		                                               .getTime ( ) ) ;

		// 首先获取分隔符
		String format =
		                formatted
		                         .replaceAll (
		                                       "\\d" ,
		                                       "" ) ;
		char separator =
		                 format
		                       .charAt ( 0 ) ;

		String [ ] parts =
		                   formatted
		                            .split ( "\\"
		                                     + separator ) ;

		StringBuilder pattern =
		                        new StringBuilder ( ) ;

		for ( String part : parts )
		{
			int index =
			            Integer
			                   .parseInt ( part ) ;

			if ( index == calendar
			                      .get ( Calendar.DAY_OF_MONTH ) )
			{
				pattern
				       .append ( "dd" ) ;
			}
			else if ( index == 1 + calendar
			                               .get ( Calendar.MONTH ) )
			{
				pattern
				       .append ( "MM" ) ;
			}
			else
			{
				pattern
				       .append ( "yyyy" ) ;
			}

			pattern
			       .append ( separator ) ;
		}

		pattern
		       .deleteCharAt ( pattern
		                              .length ( ) - 1 ) ;

		return pattern
		              .toString ( ) ;
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-27；时间：下午1:24:31</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param ms 以微秒为单位的long整型
	 * @return
	 * @return
	 */
	public static String getTimeStr(long ms) {//将毫秒数换算成x天x时x分x秒x毫秒
		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		   long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		   String strDay = day < 10 ? "0" + day : "" + day;
		String strHour = hour < 10 ? "0" + hour : "" + hour;
		String strMinute = minute < 10 ? "0" + minute : "" + minute;
		String strSecond = second < 10 ? "0" + second : "" + second;
		String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
		strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;
		return strDay + "天 " + strHour + "小时:" + strMinute + "分:" + strSecond + "秒: " + strMilliSecond+"毫秒";
	}
	
	
	public static String getGMTTime() {
		//String dateStr = new Date().toLocaleString();
		//String subStr = dateStr.substring(0, dateStr.indexOf(" "));
		String subStr = new Date().toGMTString();
		//System.err.println(subStr);
		return subStr;
	}
	//@Test
	public static String getToday() {
		//String dateStr = new Date().toLocaleString();
		//String subStr = dateStr.substring(0, dateStr.indexOf(" "));
		String subStr = format(new Date());
		//System.err.println(subStr);
		return subStr;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:14:41</li>
	 * <li>设计目的：判断指定日期是否为周末（星期六或者星期日）</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 * @return
	 */
	public static boolean isWeekend (
	                                  Calendar calendar )
	{
		int dayInWeek =
		                calendar
		                        .get ( Calendar.DAY_OF_WEEK ) ;

		return ( dayInWeek == Calendar.SATURDAY )
		       || ( dayInWeek == Calendar.SUNDAY ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:24:16</li>
	 * <li>设计目的：将日期的时间部分设置为23:59:59.999</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 */
	public static void maximizeTime (
	                                  Calendar calendar )
	{
		calendar
		        .set (
		               Calendar.HOUR_OF_DAY ,
		               23 ) ;
		calendar
		        .set (
		               Calendar.MINUTE ,
		               59 ) ;
		calendar
		        .set (
		               Calendar.SECOND ,
		               59 ) ;
		calendar
		        .set (
		               Calendar.MILLISECOND ,
		               999 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:23:30</li>
	 * <li>设计目的：将日期的时间部分设置为23:59:59.999</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static Date maximizeTime (
	                                  Date date )
	{
		Calendar calendar =
		                    new GregorianCalendar ( ) ;
		calendar
		        .setTime ( date ) ;
		DateUtil
		        .maximizeTime ( calendar ) ;

		return calendar
		               .getTime ( ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:24:53</li>
	 * <li>设计目的：将日期的时间部分设置00:00.00</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param calendar
	 */
	public static void nullifyTime (
	                                 Calendar calendar )
	{
		calendar
		        .set (
		               Calendar.HOUR_OF_DAY ,
		               0 ) ;
		calendar
		        .set (
		               Calendar.MINUTE ,
		               0 ) ;
		calendar
		        .set (
		               Calendar.SECOND ,
		               0 ) ;
		calendar
		        .set (
		               Calendar.MILLISECOND ,
		               0 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:25:49</li>
	 * <li>设计目的：将日期的时间部分设置00:00.00</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param date
	 * @return
	 */
	public static Date nullifyTime (
	                                 Date date )
	{
		Calendar calendar =
		                    new GregorianCalendar ( ) ;
		calendar
		        .setTime ( date ) ;
		DateUtil
		        .nullifyTime ( calendar ) ;

		return calendar
		               .getTime ( ) ;
	}
	
	
	public static Date parse(String date) {
		return parse(date,DATE_TIME_FORMAT );
	}
	
	
	

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:08:35</li>
	 * <li>设计目的：按照给定格式解析指定日期字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param dateString
	 * @param dateFormat
	 * @return
	 */
	public static Date parse (
	                           String dateString ,
	                           String dateFormat )
	{
		return DateUtil
		               .parse (
		                        dateString ,
		                        dateFormat ,
		                        java.util.Date.class ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:08:01</li>
	 * <li>设计目的：按照给定格式解析指定日期字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param dateString
	 * @param dateFormat
	 * @param targetResultType
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static < T extends Date > T parse (
	                                           String dateString ,
	                                           String dateFormat ,
	                                           Class < T > targetResultType )
	{
		if ( StringUtil
		               .isEmpty ( dateString ) )
		{
			return null ;
		}
		DateFormat simpleDateFormat =
		                              new SimpleDateFormat (
		                                                     dateFormat ) ;
		try
		{
			long time =
			            simpleDateFormat
			                            .parse (
			                                     dateString )
			                            .getTime ( ) ;
			Date tempDate =
			                targetResultType
			                                .getConstructor (
			                                                  long.class )
			                                .newInstance (
			                                               time ) ;
			return ( T ) tempDate ;
		}
		catch ( ParseException parseException )
		{
			String errorInfo =
			                   "无法使用格式：["
			                           + dateFormat
			                           + "]解析日期字符串：["
			                           + dateString
			                           + "]" ;
			throw new IllegalArgumentException (
			                                     errorInfo ,
			                                     parseException ) ;
		}
		catch ( Exception exception )
		{
			throw new IllegalArgumentException (
			                                     "目标结果类型：["
			                                             + targetResultType
			                                                               .getName ( )
			                                             + "]错误" ,
			                                     exception ) ;
		}
	}

	
	
	public static String getTimeStr2(Long l) {
		String str = "";
		int hour = 0;
		int minute = 0;
		int second = 0;
		second = l.intValue() / 1000;
		if (second > 60) {
			minute = second / 60;
			second = second % 60;
		}

		if (minute > 60) {
			hour = minute / 60;
			minute = minute % 60;
		}
		String strtime = hour + "小时" + minute + "分钟" + second + "秒";
		return strtime;

	}

	public static String getTimeStr3(long mss) {
		long days = mss / (1000 * 60 * 60 * 24);
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		return days + "日" + hours + "小时" + minutes + "分" + seconds + "秒";
	}	
	
	public static Date setCalendar(long milliseconds) {
		return new Date(milliseconds);
	}
	
	public static Date setDate(long milliseconds) {
		return new Date(milliseconds);
	}	
	
	public static void updateCalendar(Calendar calendar,int field, int amount) {
		calendar.add(field, amount);
		;
	}
	
	
	/**
	 * 构造函数
	 */
	private DateUtil ( )
	{
		super ( ) ;
	}
	
	
}

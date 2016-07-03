/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-3</li>
 * <li>初始作者：刘川</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.log.lf4j ;

import org.slf4j.Logger;

//import org.jboss.seam.log.LogProvider;

/**
 * <ul>
 * <li>设计作者：刘川</li>
 * <li>设计日期：2009-8-3</li>
 * <li>设计时间：下午03:02:19</li>
 * <li>设计目的：Seam日志记录器操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class Slf4jLoggerUtil
{
	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Debug优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void debug(Logger logger, Object object) {
		if (logger.isDebugEnabled()) {
			logger.debug("\n" + object);
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Debug优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void debug (
	                           Logger logger ,
	                           Object object ,
	                           Throwable throwable )
	{
		if ( logger
		           .isDebugEnabled ( ) )
		{
			logger
			      .debug (
			               "\n"
			                       + object ,
			               throwable ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Error优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void error (
	                           Logger logger ,
	                           Object object )
	{
		if ( logger
		           .isErrorEnabled ( ) )
		{
			logger
			      .error ( "\n"
			               + object ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Error优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void error (
	                           Logger logger ,
	                           Object object ,
	                           Throwable throwable )
	{
		if ( logger
		           .isErrorEnabled ( ) )
		{
			logger
			      .error (
			               "\n"
			                       + object ,
			               throwable ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Fatal优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void fatal (
	                           Logger logger ,
	                           Object object )
	{
		//if (logger.isFatalEnabled()) {
		//	logger.fatal("\n" + object);
		//}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Fatal优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void fatal (
	                           Logger logger ,
	                           Object object ,
	                           Throwable throwable )
	{
		//if (logger.isFatalEnabled()) {
		//	logger.fatal("\n" + object, throwable);
		//}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Info优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void info (
	                          Logger logger ,
	                          Object object )
	{
		if ( logger
		           .isInfoEnabled ( ) )
		{
			logger
			      .info ( "\n"
			              + object ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Info优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void info (
	                          Logger logger ,
	                          Object object ,
	                          Throwable throwable )
	{
		if ( logger
		           .isInfoEnabled ( ) )
		{
			logger
			      .info (
			              "\n"
			                      + object ,
			              throwable ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Trace优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void trace (
	                           Logger logger ,
	                           Object object )
	{
		if ( logger
		           .isTraceEnabled ( ) )
		{
			logger
			      .trace ( "\n"
			               + object ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Trace优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void trace (
	                           Logger logger ,
	                           Object object ,
	                           Throwable throwable )
	{
		if ( logger
		           .isTraceEnabled ( ) )
		{
			logger
			      .trace (
			               "\n"
			                       + object ,
			               throwable ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:41</li>
	 * <li>设计目的：以Warn优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 */
	public static void warn (
	                          Logger logger ,
	                          Object object )
	{
		if ( logger
		           .isWarnEnabled ( ) )
		{
			logger
			      .warn ( "\n"
			              + object ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-7-23</li>
	 * <li>设计时间：下午12:25:07</li>
	 * <li>设计目的：以Warn优先级输出调试信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param logger
	 * @param object
	 * @param throwable
	 */
	public static void warn (
	                          Logger logger ,
	                          Object object ,
	                          Throwable throwable )
	{
		if ( logger
		           .isWarnEnabled ( ) )
		{
			logger
			      .warn (
			              "\n"
			                      + object ,
			              throwable ) ;
		}
	}

	/**
	 * 构造函数
	 */
	private Slf4jLoggerUtil ( )
	{
		super ( ) ;
	}
}

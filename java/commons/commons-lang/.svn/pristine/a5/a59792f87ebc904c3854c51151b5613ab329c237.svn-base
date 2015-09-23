package org.hy.commons.lang.exception;


import java.io.PrintStream ;
import java.io.PrintWriter ;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-4-30</li>
 * <li>设计时间：上午06:46:14</li>
 * <li>设计目的：平台运行时异常基类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class CommonRuntimeException extends RuntimeException
{
	private static final long	serialVersionUID	=
	                                                  - 312476846739721232L ;
	private Throwable	      nested	         =
	                                               null ;

	/**
	 * 构造函数
	 */
	public CommonRuntimeException ( )
	{
		super ( ) ;
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 */
	public CommonRuntimeException (
	                               String message )
	{
		super (
		        message ) ;
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 * @param nested
	 */
	public CommonRuntimeException (
	                               String message ,
	                               Throwable nested )
	{
		super (
		        message ) ;
		this.nested =
		              nested ;
	}

	/**
	 * 构造函数
	 * 
	 * @param nested
	 */
	public CommonRuntimeException (
	                               Throwable nested )
	{
		super ( ) ;
		this.nested =
		              nested ;
	}

	/**
	 * 返回包括嵌套异常信息在内的异常详细信息
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@ Override
	public String getMessage ( )
	{
		if ( this.nested != null )
		{
			return super
			            .getMessage ( )
			       + " ("
			       + this.nested
			                    .getMessage ( )
			       + ")" ;
		}
		else
		{
			return super
			            .getMessage ( ) ;
		}
	}

	/**
	 * @return the nested
	 */
	public Throwable getNested ( )
	{
		return this.nested ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-4-30</li>
	 * <li>设计时间：上午09:56:44</li>
	 * <li>设计目的：返回不包括嵌套异常信息在内的异常信息</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public String getNonNestedMessage ( )
	{
		return super
		            .getMessage ( ) ;
	}

	/**
	 * @see java.lang.Throwable#printStackTrace()
	 */
	@ Override
	public void printStackTrace ( )
	{
		super
		     .printStackTrace ( ) ;
		if ( this.nested != null )
		{
			this.nested
			           .printStackTrace ( ) ;
		}
	}

	/**
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	@ Override
	public void printStackTrace (
	                              PrintStream printStream )
	{
		super
		     .printStackTrace ( printStream ) ;
		if ( this.nested != null )
		{
			this.nested
			           .printStackTrace ( printStream ) ;
		}
	}

	/**
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	@ Override
	public void printStackTrace (
	                              PrintWriter printWriter )
	{
		super
		     .printStackTrace ( printWriter ) ;
		if ( this.nested != null )
		{
			this.nested
			           .printStackTrace ( printWriter ) ;
		}
	}
}

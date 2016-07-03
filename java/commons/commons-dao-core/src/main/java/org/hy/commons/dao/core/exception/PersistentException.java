
package org.hy.commons.dao.core.exception ;

import org.hy.commons.lang.exception.CommonRuntimeException;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-2-13；时间：下午3:46:04</li>
 * <li>类型名称：PersistentException</li>
 * <li>设计目的：</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class PersistentException extends CommonRuntimeException
{
	private static final long	serialVersionUID	=
	                                                  - 5822183742227928644L ;

	/**
	 * 构造函数
	 */
	public PersistentException ( )
	{
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 */
	public PersistentException(String message) {
		super(message);
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 * @param nested
	 */
	public PersistentException(String message, Throwable nested) {
		super(message, nested);
	}

	/**
	 * 构造函数
	 * 
	 * @param nested
	 */
	public PersistentException(Throwable nested) {
		super(nested);
	}
}

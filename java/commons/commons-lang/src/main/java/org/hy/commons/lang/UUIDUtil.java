/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-4</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang ;

import java.util.UUID ;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午02:12:07</li>
 * <li>设计目的：Libra平台用于操作UUID的助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class UUIDUtil
{
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:12:41</li>
	 * <li>设计目的：随机生成UUID字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String randomUUID ( )
	{
		return UUID
		           .randomUUID ( )
		           .toString ( )
		           .replace("-","")
		           .toUpperCase ( ) ;
	}

	/**
	 * 构造函数
	 */
	private UUIDUtil ( )
	{
		super ( ) ;
	}
}

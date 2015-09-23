/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-4</li>
 * <li>初始作者：刘川</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.xml ;

import java.io.Serializable;

/**
 * <ul>
 * <li>设计作者：刘川</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午05:54:34</li>
 * <li>设计目的：表现具有操作标识符能力的接口</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public interface Identifierable < T extends Serializable > extends Serializable
{
	/**
	 * 标识符属性名称
	 */
	public static String	PROPERTY_IDENTIFIER	=
	                                              "identifier" ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午05:55:45</li>
	 * <li>设计目的：获取标识符</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public T getIdentifier ( ) ;
	public T getId( ) ;

	/**
	 * <ul>
	 * <li>设计作者：刘川</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午05:55:37</li>
	 * <li>设计目的：设置标识符</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param identifier
	 */
	public void setIdentifier (T identifier ) ;
	public void setId (T identifier ) ;
}

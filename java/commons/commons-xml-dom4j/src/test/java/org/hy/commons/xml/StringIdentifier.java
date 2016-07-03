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

import javax.persistence.Column ;
import javax.persistence.Id ;
import javax.persistence.MappedSuperclass ;
import javax.persistence.Transient;

/**
 * <ul>
 * <li>设计作者：刘川</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午05:56:22</li>
 * <li>设计目的：字符串标识符抽象实现类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
@ MappedSuperclass
public abstract class StringIdentifier implements Identifierable < String >
{
	private static final long	serialVersionUID	=
	                                                  - 8200144472070383437L ;
	/**
	 * 标识符
	 */
	private String	          identifier ;

	/**
	 * 构造函数
	 */
	public StringIdentifier ( )
	{
		super ( ) ;
	}

	/**
	 * 构造函数
	 * 
	 * @param identifier
	 */
	public StringIdentifier (
	                          String identifier )
	{
		super ( ) ;
		this
		    .setId ( identifier ) ;
	}

	/**
	 * @see com.hy.mydesktop.shared.persistence.domain.util.Identifierable#getIdentifier()
	 */
	@ Column ( name = "id" ,length=36)//identifier
	@ Id
	@ Override
	public String getId ( )
	{
		return this.identifier ;
	}
	
	@Transient
	public String getIdentifier(){
		return this.getId();
	}

	/**
	 * @see com.hy.mydesktop.shared.persistence.domain.util.Identifierable#setIdentifier(java.io.Serializable)
	 */
	@ Override
	public void setId (
	                            String identifier )
	{
		this.identifier =
		                  identifier ;
	}
	public void setIdentifier(String identifier){
		setId(identifier);
	}
}

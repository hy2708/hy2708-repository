package org.hy.commons.lang.string;

import jodd.util.Wildcard;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-9-16；时间：下午4:07:16</li>
 * <li>类型名称：WildcardUtil</li>
 * <li>设计目的：用于匹配字符串或者文件查找的工具类</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class WildcardUtil extends Wildcard{

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：是否含有通配符</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-9-16；时间：下午4:09:01</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param string
	 * @return
	 */
	public static Boolean hasWildcard(String string) {
		if (StringUtil.contains(string, "*")) {
			return true;
		}
		if (StringUtil.contains(string, "?")) {
			return true;
		}
		return false;
	}
}

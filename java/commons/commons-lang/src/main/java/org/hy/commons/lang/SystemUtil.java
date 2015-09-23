/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-12</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang ;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-12</li>
 * <li>设计时间：下午10:05:07</li>
 * <li>设计目的：系统操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class SystemUtil extends jodd.util.SystemUtil
{
	
	
	
	public static String getToday() {
		String dateStr = new Date().toLocaleString();
		String subStr = dateStr.substring(0, dateStr.indexOf(" "));
		return subStr;
	}
	
	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午10:06:04</li>
	 * <li>设计目的：获取Java环境目录</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getJavaHome ( )
	{
		/*String javaHome = System.getProperty("java.home");
		javaHome = javaHome.replaceAll("\\\\", "/");
		return javaHome;*/
		return jodd.util.SystemUtil.getJavaHome();
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午10:06:20</li>
	 * <li>设计目的：获取Java环境Lib库目录</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getJavaHomeLib ( )
	{
		return SystemUtil
		                 .getJavaHome ( )
		       + "/lib" ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午10:06:41</li>
	 * <li>设计目的：获取用户目录</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static String getUserHome ( )
	{
		return System
		             .getProperty ( "user.home" ) ;
	}
	
	public static Properties getProperties() {
		
		Properties p = System.getProperties();
		//p.list(System.out);//输出系统的属性
		return p;
	}
	
	
	public static String getSystemProperty(String propertyName) {
		return System.getenv(propertyName);
	}

	public static Map<String, String> getSystemPropertise(String propertyName) {
		return System.getenv();
	}
	

	public static void main(String[] args) throws IOException {
		Long begin = System.currentTimeMillis();
		System.out.println(SystemUtil.getProperties());
		System.out.println(SystemUtil.getJavaHome());
		System.out.println(SystemUtil.getJavaHomeLib());
		System.out.println(SystemUtil.getUserHome());
		Long end = System.currentTimeMillis();
		System.err.println(end-begin);
		Runtime.getRuntime().exec("notepad");
	}

	public static void runJavap(Class<?> clazz) {
		
		
	}
	
	static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length){
		System.arraycopy(src, srcPos, dest, destPos, length);
	}
	/**
	 * 构造函数
	 */
	private SystemUtil ( )
	{
		super ( ) ;
	}
}

package org.hy.commons.lang;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jodd.bean.BeanCopy;
import jodd.typeconverter.TypeConverterManager;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-2-3；时间：下午1:05:17</li>
 * <li>类型名称：BeanUtil</li>
 * <li>设计目的：
 * the fastest bean manipulation utility
 * works with both attributes and properties
 * nested properties can be arrays, lists and maps
 * missing inner properties may be created
 * can work silently
 * offers few populate methods
 * has strong type conversion library
 * </li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class BeanUtil extends 
//BeanUtils
jodd.bean.BeanUtil
{

	
//	public static void setProperty(Object bean, String name, Object value)
//			//throws IllegalAccessException, InvocationTargetException
//			{
//		
//		
//		setProperty(bean, name, value);
//	}
//	
	private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	
	
	public static Object getProperty(Object bean, String name)
    {
		return jodd.bean.BeanUtil.getProperty(bean, name);
    }
	
	public static boolean hasProperty(Object bean, String name) {
		return jodd.bean.BeanUtil.hasProperty(bean, name);
	}

	public static boolean hasDeclaredProperty(Object bean, String name) {
		return jodd.bean.BeanUtil.hasDeclaredProperty(bean, name);
	}


	
	public static Boolean hasPropertyValue(Object bean, String name)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException 
			{	
		Object value = jodd.bean.BeanUtil.getProperty(bean, name);
		if (null==value) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：通过JavaBean的set方法或者get方法，得到属性名<br>
	 * 如果传入的set方法，或者get方法不正确，那么返回NULL</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-10；时间：下午4:39:47</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param method
	 * @return
	 * @return
	 */
	public static String getFieldNameFromMethodName( Method method) {
		return getFieldNameFromMethodName(method.getName());
	}
	
	public static String getFieldNameFromMethodName( String methodName) {
		if (methodName.startsWith("set")||methodName.startsWith("get")) {
			String tempPropertyName = methodName.substring(3);
			String propertyName = tempPropertyName.substring(0, 1)
					.toLowerCase() + tempPropertyName.substring(1);
			if (propertyName==null||propertyName.trim().length()==0) {
				return null;
			}
			return propertyName;
		}
		return null;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：设置对象的属性值<br/
	 * <b>该属性值，并没有对应的set方法</b></li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-3；时间：下午12:27:59</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static void setDeclaredProperty(Object bean, String name, Object value) {
		jodd.bean.BeanUtil.setDeclaredProperty(bean, name, value);
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：可以设置属性值<br>
	 * 可以设置嵌套的属性值，也支持List 和Map<br/>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-3；时间：下午12:33:19</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static void setProperty(Object bean, String name, Object value)
    {
		
		jodd.bean.BeanUtil.setProperty(bean, name, value);

    }
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：可以<b>强制</b>设置属性值<br>
	 * 可以<b>强制</b>设置嵌套的属性值，也支持List 和Map<br/>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-3；时间：下午12:36:17</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static void setPropertyForced(Object bean, String name, Object value) {
		jodd.bean.BeanUtil.setPropertyForced(bean, name, value);
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：可以<b>强制</b>设置属性值，<b>并且不抛出异常</b><br>
	 * 可以<b>强制</b>设置嵌套的属性值，也支持List 和Map<br/>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-3；时间：下午12:36:17</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param bean
	 * @param name
	 * @param value
	 * @return
	 */
	public static boolean setPropertyForcedSilent(Object bean, String name, Object value) {
		return jodd.bean.BeanUtil.setPropertyForcedSilent(bean, name, value);
	}
	
	public static void setPropertyByType(Object bean, String name, Object value)
    { 
		Class classType = BeanUtil.getPropertyType(bean, name);
		BeanUtil.setPropertyForced(bean, name,
				TypeConverterManager.convertType(name, classType));

    }
	public static Map<String, Object>  populateToMap(Object object,List<String> properties){
		Map<String, Object> map = new HashMap<String, Object>();
		for (int j = 0; j < properties.size(); j++) {			
			map.put( properties.get(j), getProperty(object, properties.get(j)));
			
			
		}
		return map;
	}
	
	public static List< Object>  populateToList(Object object,List<String> properties){
		List< Object> map = new LinkedList< Object>();
		for (int j = 0; j < properties.size(); j++) {			
			map.add( getProperty(object, properties.get(j)));
			
		}
		return map;
	}
	
	public static Map<String, Object>  populateToMap(Object object)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(object);
		for (int j = 0; j < properties.length; j++) {
			if ("class".equals(properties[j].getName())) {
				
			}else {				
				map.put( properties[j].getName(), getProperty(object, properties[j].getName()));
			}
			
			
		}
		return map;
		
	}
	
	public static void copyBean(Object source,Object destination) {
		BeanCopy.beans(source, destination);
	}

}

/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-5</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang.reflect ;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hy.commons.log.lf4j.Slf4jLoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.hy.enterprise.framework.util.logger.Slf4jLoggerUtil;
//import org.jboss.seam.log.LogProvider;
//import org.jboss.seam.log.Logging;


//import com.vsoft.libra.enterprise.framework.util.LibraUtil;
//import com.vsoft.libra.enterprise.framework.util.logger.SeamLoggerUtil;

/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2013-5-25；时间：下午4:16:46</li>
 * <li>类型名称：ReflectionUtil</li>
 * <li>设计目的：反射的Utils函数集合，供访问私有变量，获取泛型类型Class，提取集合中元素的属性等辅助方法函数。</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class ReflectionUtil extends jodd.util.ReflectUtil
{
	/**
	 * 日志记录器
	 */
//	private static LogProvider	logger	=  Logging     .getLogProvider ( ReflectionUtil.class ) ;
	private static Logger logger	=  LoggerFactory.getLogger( ReflectionUtil.class ) ;

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:54:46</li>
	 * <li>设计目的：将反射时的checked exception转换为unchecked exception</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param exception
	 * @return
	 */
	public static IllegalArgumentException convertToUncheckedException (
	                                                                     Exception exception )
	{
		if ( ( exception instanceof IllegalAccessException )
		     || ( exception instanceof IllegalArgumentException )
		     || ( exception instanceof NoSuchMethodException ) )
		{
			return new IllegalArgumentException (
			                                      "反射异常" ,
			                                      exception ) ;
		}
		else
		{
			return new IllegalArgumentException (
			                                      exception ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:52:07</li>
	 * <li>设计目的：提取集合中的对象的属性(通过getter函数)，组合成List</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @param propertyName
	 * @return
	 */
	public static List < Object > fetchElementPropertyToList (
	                                                           final Collection < Object > collection ,
	                                                           final String propertyName )
	{
		List < Object > list =
		                       new ArrayList < Object > ( ) ;

		try
		{
			for ( Object object : collection )
			{
				list
				    .add ( PropertyUtils
				                        .getProperty (
				                                       object ,
				                                       propertyName ) ) ;
			}
		}
		catch ( Exception exception )
		{
			ReflectionUtil
			              .convertToUncheckedException ( exception ) ;
		}

		return list ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:53:19</li>
	 * <li>设计目的：提取集合中的对象的属性(通过getter函数)，组合成由分割符分隔的字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @param propertyName
	 * @param separator
	 * @return
	 */
	public static String fetchElementPropertyToString (
	                                                    final Collection < Object > collection ,
	                                                    final String propertyName ,
	                                                    final String separator )
	{
		List < Object > list =
		                       ReflectionUtil
		                                     .fetchElementPropertyToList (
		                                                                   collection ,
		                                                                   propertyName ) ;
		return StringUtils
		                  .join (
		                          list ,
		                          separator ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:42:54</li>
	 * <li>设计目的：循环向上转型，获取对象的DeclaredField</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Field getDeclaredField (
	                                       final Object object ,
	                                       final String fieldName )
	{
		if ( ( null == object )
		     || ( null == fieldName )
		     || ( fieldName
		                   .trim ( )
		                   .length ( ) == 0 ) )
		{
			return null ;
		}
		for ( Class < ? > superClass =
		                               object
		                                     .getClass ( ) ; superClass != Object.class ; superClass =
		                                                                                               superClass
		                                                                                                         .getSuperclass ( ) )
		{
			try
			{
				return superClass
				                 .getDeclaredField ( fieldName ) ;
			}
			catch ( NoSuchFieldException noSuchFieldException )
			{
				// Field不在当前类定义，继续向上转型
			}
		}
		return null ;
	}
	public static Method[] getDeclaredAllMethods(Class<?> clazz) {
		return clazz.getDeclaredMethods();
	}
	
	public static Method[] getDeclaredAllMethods(Object target) {
		return getDeclaredAllMethods(target.getClass());
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午12:26:57</li>
	 * <li>设计目的：查找指定类型中指定名称和参数列表的方法<br/>
	 * <b>注：如果目标类，不存在要查找的方法，则向父类查找</b></li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static Method getDeclaredMethod(Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		if ((null == clazz) || (null == methodName)
				|| (methodName.trim().length() == 0)) {
			return null;
		}
		//clazz = LibraUtil.getImplementClass(clazz);
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException noSuchMethodException) {
				// Method不在当前类定义,继续向上转型
			}
		}
		return null;
	}
	public static Method getDeclaredMethod(Class<?> clazz, String methodName){
		return getDeclaredMethod(clazz, methodName, new Class<?>[]{});
	}
	
	public static Method findDeclaredMethod(String clazz, String methodName){
		Class<?> class1 = null;
		try {
			class1 = Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findDeclaredMethod(class1, methodName);
	}
	public static Method findDeclaredMethod(Class<?> clazz, String methodName){
		List<Method> list = findDeclaredMethod(clazz, methodName, false);
		if (list.size()>0) {			
			return list.get(0);
			
		}
		return null;
	}
	public static List<Method> findAllDeclaredMethod(Class<?> clazz, String methodName){
		return findDeclaredMethod(clazz, methodName, true);
	}
	
	private static List<Method> findDeclaredMethod(Class<?> clazz, String methodName,Boolean isAll){
		Method[] methods =getAccessibleMethods(clazz);
		List<Method> list = new LinkedList<Method>();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				list.add(method);
				if (!isAll) {	
					return list;
				}
			}
		}
		return list;
	}

	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:45:40</li>
	 * <li>设计目的：循环向上转型，获取对象的DeclaredMethod</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static Method getDeclaredMethod(Object object, String methodName,
			Class<?>[] parameterTypes) {
		if ((null == object) || (null == methodName)
				|| (methodName.trim().length() == 0)) {
			return null;
		} else {
			return ReflectionUtil.getDeclaredMethod(object.getClass(),
					methodName, parameterTypes);
		}
	}
	
	public static Class getDeclaredMethodReturnType(Class clazz, String methodName) {
		
		Method method =ReflectionUtil.getDeclaredMethod(clazz, methodName);
		return method.getReturnType();
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:38:29</li>
	 * <li>设计目的：直接读取对象属性值，无视private/protected修饰符，不经过getter函数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue (
	                                     final Object object ,
	                                     final String fieldName )
	{
		Field field =
		              ReflectionUtil
		                            .getDeclaredField (
		                                                object ,
		                                                fieldName ) ;

		if ( field == null )
		{
			throw new IllegalArgumentException (
			                                     "无法在目标对象：["
			                                             + object
			                                             + "]中获取字段["
			                                             + fieldName
			                                             + "]" ) ;
		}

		ReflectionUtil
		              .makeAccessible ( field ) ;

		Object result =
		                null ;
		try
		{
			result =
			         field
			              .get ( object ) ;
		}
		catch ( IllegalAccessException illegalAccessException )
		{
			//SeamLoggerUtil
			 Slf4jLoggerUtil            .error (
			                       ReflectionUtil.logger ,
			                       "不可能抛出的异常：["
			                               + illegalAccessException
			                                                       .getMessage ( )
			                               + "]" ) ;
		}
		return result ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:46:10</li>
	 * <li>设计目的：通过反射，获得Class定义中声明的父类的泛型参数的类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static < T > Class < T > getSuperClassGenricType (
	                                                          final Class < ? > clazz )
	{
		return ( Class < T > ) ReflectionUtil
		                                     .getSuperClassGenricType (
		                                                                clazz ,
		                                                                0 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:47:22</li>
	 * <li>设计目的：通过反射，获得定义Class时声明的父类的泛型参数的类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class < ? > getSuperClassGenricType (
	                                                    final Class < ? > clazz ,
	                                                    final int index )
	{

		Type genType =
		               clazz
		                    .getGenericSuperclass ( ) ;

		if ( ! ( genType instanceof ParameterizedType ) )
		{
			//SeamLoggerUtil
			Slf4jLoggerUtil             .warn (
			                      ReflectionUtil.logger ,
			                      "类型["
			                              + clazz
			                                     .getSimpleName ( )
			                              + "]的超类不存在泛型化参数" ) ;
			return Object.class ;
		}

		Type [ ] parameters =
		                      ( ( ParameterizedType ) genType )
		                                                       .getActualTypeArguments ( ) ;

		if ( ( index >= parameters.length )
		     || ( index < 0 ) )
		{
			//SeamLoggerUtil
			Slf4jLoggerUtil              .warn (
			                      ReflectionUtil.logger ,
			                      "Index: "
			                              + index
			                              + ", Size of "
			                              + clazz
			                                     .getSimpleName ( )
			                              + "'s Parameterized Type: "
			                              + parameters.length ) ;
			return Object.class ;
		}
		if ( ! ( parameters [ index ] instanceof Class ) )
		{
			//SeamLoggerUtil
			Slf4jLoggerUtil              .warn (
			                      ReflectionUtil.logger ,
			                      clazz
			                           .getSimpleName ( )
			                              + " not set the actual class on superclass generic parameter" ) ;
			return Object.class ;
		}
		return ( Class < ? > ) parameters [ index ] ;
	}

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-27；时间：上午10:51:19</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @param parameters
	 * @return
	 * @throws InvocationTargetException
	 */
	public static Object invokeMethod(final Object object,
			final String methodName, final Class<?>[] parameterTypes,
			final Object[] parameters) throws InvocationTargetException {
		Method method = ReflectionUtil.getDeclaredMethod(object, methodName,
				parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("无法在目标对象：[" + object + "]中获取方法["
					+ methodName + "]");
		}

		method.setAccessible(true);

		try {
			logger.debug("调用方法【{}】，参数为【{}】",method,parameters);
			return method.invoke(object, parameters);
		} catch (IllegalAccessException illegalAccessException) {
			// SeamLoggerUtil
			Slf4jLoggerUtil.error(ReflectionUtil.logger, "不可能抛出的异常：["
					+ illegalAccessException.getMessage() + "]");
		}

		return null;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:30:06</li>
	 * <li>设计目的：判断指定对象是否为公用、静态、最终的</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param field
	 * @return
	 */
	public static boolean isPublicStaticFinal (
	                                            Field field )
	{
		int modifiers =
		                field
		                     .getModifiers ( ) ;
		return ( Modifier
		                 .isPublic ( modifiers )
		         && Modifier
		                    .isStatic ( modifiers ) && Modifier
		                                                       .isFinal ( modifiers ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:44:19</li>
	 * <li>设计目的：循环向上转型，获取对象的DeclaredField</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param field
	 */
	public static void makeAccessible (
	                                    final Field field )
	{
		if ( ! Modifier
		               .isPublic ( field
		                                .getModifiers ( ) )
		     || ! Modifier
		                  .isPublic ( field
		                                   .getDeclaringClass ( )
		                                   .getModifiers ( ) ) )
		{
			field
			     .setAccessible ( true ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午05:40:58</li>
	 * <li>设计目的：直接设置对象属性值，无视private/protected修饰符，不经过setter函数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @param fieldName
	 * @param value
	 */
	public static void setFieldValue (
	                                   final Object object ,
	                                   final String fieldName ,
	                                   final Object value )
	{
		Field field =
		              ReflectionUtil
		                            .getDeclaredField (
		                                                object ,
		                                                fieldName ) ;

		if ( field == null )
		{
			throw new IllegalArgumentException (
			                                     "无法在目标对象：["
			                                             + object
			                                             + "]中获取字段["
			                                             + fieldName
			                                             + "]" ) ;
		}

		ReflectionUtil
		              .makeAccessible ( field ) ;

		try
		{
			field
			     .set (
			            object ,
			            value ) ;
		}
		catch ( IllegalAccessException illegalAccessException )
		{
			//SeamLoggerUtil
			Slf4jLoggerUtil             .error (
			                       ReflectionUtil.logger ,
			                       "不可能抛出的异常：["
			                               + illegalAccessException
			                                                       .getMessage ( )
			                               + "]" ) ;
		}
	}

	/**
	 * 构造函数
	 */
	private ReflectionUtil ( )
	{
		super ( ) ;
	}
}

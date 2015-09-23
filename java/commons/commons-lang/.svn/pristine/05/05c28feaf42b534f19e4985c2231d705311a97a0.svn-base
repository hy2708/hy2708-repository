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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hy.commons.lang.string.StringUtil;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午01:27:42</li>
 * <li>设计目的：Libra平台类操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class ClassUtil
{
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:51:24</li>
	 * <li>设计目的：判断是否可为方法调用进行转换</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param value
	 * @param targetType
	 * @return
	 */
	protected static boolean canConvertForMethodInvocation (
	                                                         Object value ,
	                                                         Type targetType )
	{
		if ( value == null )
		{
			return true ;
		}

		Class < ? > valueClass =
		                         value
		                              .getClass ( ) ;
		if ( valueClass == targetType )
		{
			return true ;
		}

		Class < ? > targetClass =
		                          ClassUtil
		                                   .classOfType ( targetType ) ;
		if ( targetClass
		                .isAssignableFrom ( valueClass ) )
		{
			return true ;
		}
		if ( targetClass
		                .isPrimitive ( ) )
		{
			if ( ( ( valueClass == Integer.class ) && ( ( targetClass == Integer.TYPE )
			                                            || ( targetClass == Long.TYPE )
			                                            || ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) )
			     || ( ( valueClass == Boolean.class ) && ( targetClass == Boolean.TYPE ) )
			     || ( ( valueClass == Long.class ) && ( ( targetClass == Long.TYPE )
			                                            || ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) )
			     || ( ( valueClass == Float.class ) && ( ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) )
			     || ( ( valueClass == Byte.class ) && ( ( targetClass == Byte.TYPE )
			                                            || ( targetClass == Short.TYPE )
			                                            || ( targetClass == Integer.TYPE )
			                                            || ( targetClass == Long.TYPE )
			                                            || ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) )
			     || ( ( valueClass == Short.class ) && ( ( targetClass == Short.TYPE )
			                                             || ( targetClass == Integer.TYPE )
			                                             || ( targetClass == Long.TYPE )
			                                             || ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) )
			     || ( ( valueClass == Character.class ) && ( ( targetClass == Character.TYPE )
			                                                 || ( targetClass == Integer.TYPE )
			                                                 || ( targetClass == Long.TYPE )
			                                                 || ( targetClass == Float.TYPE ) || ( targetClass == Double.TYPE ) ) ) )
			{
				return true ;
			}
		}
		else if ( Number.class
		                      .isAssignableFrom ( targetClass ) )
		{
			if ( ( ( valueClass == Integer.class ) && ( ( targetClass == Long.class )
			                                            || ( targetClass == Float.class )
			                                            || ( targetClass == Double.class )
			                                            || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Long.class ) && ( ( targetClass == Float.class )
			                                            || ( targetClass == Double.class )
			                                            || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Float.class ) && ( ( targetClass == Double.class )
			                                             || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Byte.class ) && ( ( targetClass == Short.class )
			                                            || ( targetClass == Integer.class )
			                                            || ( targetClass == Long.class )
			                                            || ( targetClass == Float.class )
			                                            || ( targetClass == Double.class )
			                                            || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Short.class ) && ( ( targetClass == Integer.class )
			                                             || ( targetClass == Long.class )
			                                             || ( targetClass == Float.class )
			                                             || ( targetClass == Double.class )
			                                             || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Character.class ) && ( ( targetClass == Integer.class )
			                                                 || ( targetClass == Long.class )
			                                                 || ( targetClass == Float.class )
			                                                 || ( targetClass == Double.class )
			                                                 || ( targetClass == BigDecimal.class ) || ( targetClass == BigInteger.class ) ) )
			     || ( ( valueClass == Double.class ) && ( targetClass == BigDecimal.class ) ) )
			{
				return true ;
			}
		}
		else if ( valueClass
		                    .isArray ( )
		          && List.class
		                       .isAssignableFrom ( targetClass ) )
		{
			// List (非泛型化)
			if ( targetType instanceof Class < ? > )
			{
				return true ;
			}
			// List<...> (泛型化)
			if ( targetType instanceof ParameterizedType )
			{
				Type [ ] listParameterizedTypes =
				                                  ( ( ParameterizedType ) targetType )
				                                                                      .getActualTypeArguments ( ) ;
				if ( listParameterizedTypes.length == 1 )
				{
					Class < ? > listClassType =
					                            ClassUtil
					                                     .classOfType ( listParameterizedTypes [ 0 ] ) ;
					if ( listClassType
					                  .isAssignableFrom ( valueClass
					                                                .getComponentType ( ) ) )
					{
						return true ;
					}
				}
			}
		}

		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:53:27</li>
	 * <li>设计目的：判断是否可为方法调用进行转换</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param values
	 * @param targetTypes
	 * @return
	 */
	protected static boolean canConvertForMethodInvocation (
	                                                         Object [ ] values ,
	                                                         Type [ ] targetTypes )
	{
		boolean canConvert =
		                     true ;
		for ( int index =
		                  0 ; ( index < targetTypes.length )
		                      && canConvert ; index ++ )
		{
			canConvert =
			             ClassUtil
			                      .canConvertForMethodInvocation (
			                                                       values [ index ] ,
			                                                       targetTypes [ index ] ) ;
		}
		return canConvert ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:48:30</li>
	 * <li>设计目的：获取指定类型的类类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Class<?> classOfType(Type type) {
		if (type instanceof Class<?>) {
			if ("int".equalsIgnoreCase(((Class) type).getName())) {
				return Integer.class;
			}
			return (Class<?>) type;
		}
		if (type instanceof ParameterizedType) {
			return (Class<?>) ((ParameterizedType) type).getRawType();
		}
		if (type instanceof WildcardType) {
			Type[] upperBounds = ((WildcardType) type).getUpperBounds();
			if (upperBounds.length > 0) {
				return ClassUtil.classOfType(upperBounds[0]);
			}
		}
		if (type instanceof GenericArrayType) {
			Class<?> classType = ClassUtil
					.classOfType(((GenericArrayType) type)
							.getGenericComponentType());
			return (classType != null ? Array.newInstance(classType, 0)
					.getClass() : Object[].class);
		}
		if (type instanceof TypeVariable) {
			// 仅处理答谢边界
			Type[] bounds = ((TypeVariable<?>) type).getBounds();
			if (bounds.length > 0) {
				return ClassUtil.classOfType(bounds[0]);
			}
		}
		// 永远不会发生
		return Object.class;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:35:27</li>
	 * <li>设计目的：获取指定名称属性的获取器方法名称</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param propertyName
	 * @return
	 */
	public static String composeGetter (
	                                     String propertyName )
	{
		StringBuffer stringBuffer =
		                            new StringBuffer ( ) ;
		stringBuffer
		            .append (
		                      "get" )
		            .append (
		                      propertyName
		                                  .substring (
		                                               0 ,
		                                               1 )
		                                  .toUpperCase ( ) )
		            .append (
		                      propertyName
		                                  .substring (
		                                               1 ,
		                                               propertyName
		                                                           .length ( ) )
		                                  .toLowerCase ( ) ) ;
		return stringBuffer
		                   .toString ( ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:06:30</li>
	 * <li>设计目的：获取一个空的{@link java.util.List}类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static < T > List < T > emptyList (
	                                           Class < T > type )
	{
		return Collections.EMPTY_LIST ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:05:22</li>
	 * <li>设计目的：获取一个空的{@link java.util.Map}类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param <U>
	 * @param keyType
	 * @param valueType
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static < T , U > Map < T , U > emptyMap (
	                                                 Class < T > keyType ,
	                                                 Class < U > valueType )
	{
		return Collections.EMPTY_MAP ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:05:58</li>
	 * <li>设计目的：获取一个空的{@link java.util.Set}类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static < T > Set < T > emptySet (
	                                         Class < T > type )
	{
		return Collections.EMPTY_SET ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:56:26</li>
	 * <li>设计目的：获取指定类型指定名称和调用参数数组的方法</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param objectClass
	 * @param methodName
	 * @param parameters
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static Method findMethod(final Class<?> objectClass,
			final String methodName, final Object[] parameters)
			throws NoSuchMethodException {
		Method serviceMethod = null;
		if ((parameters == null) || (parameters.length == 0)) {
			serviceMethod = objectClass.getMethod(methodName, (Class[]) null);
		} else {
			for (Method method : objectClass.getMethods()) {

				if (!methodName.equals(method.getName())) {
					continue;
				}

				Type[] paramTypes = method.getGenericParameterTypes();
				if (paramTypes.length != parameters.length) {
					continue;
				}

				if (ClassUtil.canConvertForMethodInvocation(parameters,
						paramTypes)) {
					serviceMethod = method;
					break;
				}
			}
		}

		if (serviceMethod == null) {
			throw new NoSuchMethodException(objectClass.getName() + '.'
					+ methodName + StringUtil.toString(parameters));
		}

		return serviceMethod;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:08:27</li>
	 * <li>设计目的：通过指定名称获取该类型类的对象</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static Class<?> forName(String type) throws ClassNotFoundException {
		return Thread.currentThread().getContextClassLoader().loadClass(type);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:08:23</li>
	 * <li>设计目的：通过指定名称获取该类型类的对象，并强制转换为指定类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type
	 * @param cast
	 * @return
	 * @throws ClassNotFoundException
	 */
	@ SuppressWarnings ( "unchecked" )
	@Deprecated
	public static <T> Class<T> forName(String type, Class<T> cast)
			throws ClassNotFoundException {
		return (Class<T>) Thread.currentThread().getContextClassLoader()
				.loadClass(type);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:08:00</li>
	 * <li>设计目的：获取指定类型指定参数列表的构造函数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type
	 * @param parameterTypes
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static < T > Constructor < T > getConstructor (
	                                                       Class < T > type ,
	                                                       Class < ? > [ ] parameterTypes )
	                                                                                       throws NoSuchMethodException
	{
		return type
		           .getConstructor ( parameterTypes ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:07:41</li>
	 * <li>设计目的：获取指定类型指定参数列表的构造函数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param parameterTypes
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 */
	public static Constructor < ? > getConstructor (
	                                                 String type ,
	                                                 Class < ? > [ ] parameterTypes )
	                                                                                 throws ClassNotFoundException ,
	                                                                                 NoSuchMethodException
	{
		return ClassUtil
		                .getConstructor (
		                                  ClassUtil
		                                           .forName ( type ) ,
		                                  parameterTypes ) ;
	}
	
	public static boolean isBasicDataType(Class<?> clazz) {
		if (String.class.equals(clazz)) {
			return true;
		}
		if (Date.class.equals(clazz)) {
			return true;
		}
		if (Integer.class.equals(clazz)) {
			return true;
		}
		if ("int".equals(clazz.getName())) {
			return true;
		}
		if (Long.class.equals(clazz)) {
			return true;
		}
		if (Short.class.equals(clazz)) {
			return true;
		}
		if (Double.class.equals(clazz)) {
			return true;
		}
		if (Float.class.equals(clazz)) {
			return true;
		}
		if (Byte.class.equals(clazz)) {
			return true;
		}
		if (Boolean.class.equals(clazz)) {
			return true;
		}
		if (Character.class.equals(clazz)) {
			return true;
		}
		
		
		
		return false;
	}
	
	public static boolean isCollectionDataType(Class<?> clazz) {
		if (List.class.equals(clazz)) {
			return true;
		}
		if (LinkedList.class.equals(clazz)) {
			return true;
		}
		if (ArrayList.class.equals(clazz)) {
			return true;
		}
		if (Set.class.equals(clazz)) {
			return true;
		}
		if (HashSet.class.equals(clazz)) {
			return true;
		}
		if (Collections.class.equals(clazz)) {
			return true;
		}
		return false;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:10:40</li>
	 * <li>设计目的：创建指定类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type 将要被实例化的Clas01s类
	 * @param argumentsClasses 将要被实例化的Class01类的构造方法的参数对象，对应的Class02类型
	 * @param argsValues 构造方法的参数的Class02类型的对象
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T newInstance(Class<T> type, Class<?>[] argumentsClasses,
			Object[] argsValues) throws InstantiationException,
			IllegalAccessException {
		T instance = null;
		try {
			Constructor<T> constructorDef = type
					.getConstructor(argumentsClasses);
			instance = constructorDef.newInstance(argsValues);
		} catch (SecurityException securityException) {
			throw new InstantiationException(securityException.getMessage());
		} catch (NoSuchMethodException noSuchMethodException) {
			throw new InstantiationException(noSuchMethodException.getMessage());
		} catch (IllegalArgumentException illegalArgumentException) {
			throw new InstantiationException(
					illegalArgumentException.getMessage());
		} catch (InvocationTargetException invocationTargetException) {
			throw new InstantiationException(
					invocationTargetException.getMessage());
		}
		return instance;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:11:25</li>
	 * <li>设计目的：创建指定类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object newInstance(String type)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		return ClassUtil.forName(type).newInstance();
	}

	/** 
	 * @see #newInstance(Class, Class[], Object[])
	 */
	public static Object newInstance(String type, Class<?>[] argumentsClasses,
			Object[] argsValues) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		return ClassUtil.newInstance(ClassUtil.forName(type), argumentsClasses,
				argsValues);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:11:14</li>
	 * <li>设计目的：创建指定类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <T>
	 * @param type
	 * @param cast
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@Deprecated
	public static <T> T newInstance(String type, Class<T> cast)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		return ClassUtil.forName(type, cast).newInstance();
	}

	/**
	 * 构造函数
	 */
	private ClassUtil ( )
	{
		super ( ) ;
	}
}

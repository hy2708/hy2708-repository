/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-8</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang ;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-8</li>
 * <li>设计时间：下午05:09:55</li>
 * <li>设计目的：集合操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
@ SuppressWarnings ( {"unchecked","rawtypes"} )
public class CollectionUtil extends CollectionUtils
{
	
	private static Logger logger = LoggerFactory
			.getLogger(CollectionUtil.class);
	
	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:37:45</li>
	 * <li>设计目的：将给定数组转换为{@link java.util.List<Object>}类型实例</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param source
	 * @return
	 */
	public static List<Object> arrayToList(Object source) {
		if (null == source) {
			// throw new LibraRuntimeException ( "指定源对象不允许为空" ) ;
			throw new RuntimeException("指定源对象不允许为空");
		}
		if (!source.getClass().isArray()) {
			throw new IllegalArgumentException("给定源对象：[" + source + "]不允许为空");
		}
		boolean primitive = source.getClass().getComponentType().isPrimitive();
		Object[] array = (primitive ? CollectionUtil.toObjectArray(source)
				: (Object[]) source);
		return Arrays.asList(array);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:14:45</li>
	 * <li>设计目的：将{@link java.util.Collection}类型对象转换为{@link java.util.ArrayList}
	 * 对象</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static ArrayList asArrayList (
	                                      Collection collection )
	{
		return ( ArrayList ) CollectionUtil
		                                   .asTargetTypeCollection (
		                                                             collection ,
		                                                             ArrayList.class ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:19:37</li>
	 * <li>设计目的：将{@link java.util.Collection}类型对象转换为{@link java.util.HashSet}</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static HashSet asHashSet (
	                                  Collection < ? > collection )
	{
		return ( HashSet ) CollectionUtil
		                                 .asTargetTypeCollection (
		                                                           collection ,
		                                                           HashSet.class ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:20:59</li>
	 * <li>设计目的：将{@link java.util.Collection}类型对象转换为
	 * {@link java.util.LinkedHashSet}</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static LinkedHashSet asLinkedHashSet (
	                                              Collection collection )
	{
		return ( LinkedHashSet ) CollectionUtil
		                                       .asTargetTypeCollection (
		                                                                 collection ,
		                                                                 LinkedHashSet.class ) ;
	}

	@ SuppressWarnings (
	{
		"unchecked"
	} )
	public static < E > List < E > asList (
	                                        E ... elements )
	{
		if ( ( elements == null )
		     || ( elements.length == 0 ) )
		{
			return Collections.EMPTY_LIST ;
		}
		int capacity =
		               CollectionUtil
		                             .computeListCapacity ( elements.length ) ;
		ArrayList < E > list =
		                       new ArrayList < E > (
		                                             capacity ) ;
		Collections
		           .addAll (
		                     list ,
		                     elements ) ;
		return list ;
	}

	@ SuppressWarnings (
	{
		"unchecked"
	} )
	public static < E > Set < E > asSet (
	                                      E ... elements )
	{
		if ( ( elements == null )
		     || ( elements.length == 0 ) )
		{
			return Collections.EMPTY_SET ;
		}
		LinkedHashSet < E > set =
		                          new LinkedHashSet < E > (
		                                                    elements.length * 4 / 3 + 1 ) ;
		Collections
		           .addAll (
		                     set ,
		                     elements ) ;
		return set ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:16:51</li>
	 * <li>设计目的：将指定的集合{@link java.util.Collection<?>}对象转换为元素类型为：
	 * <code>targetCollectionClass</code>的结合对象</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @param targetCollectionClass
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static Collection asTargetTypeCollection (
	                                                  Collection collection ,
	                                                  Class targetCollectionClass )
	{
		if ( targetCollectionClass == null )
		{
			throw new IllegalArgumentException (
			                                     "'targetCollectionClass'不允许为空" ) ;
		}
		if ( collection == null )
		{
			return null ;
		}
		if ( targetCollectionClass
		                          .isInstance ( collection ) )
		{
			return collection ;
		}
		Collection < ? > resultCollection =
		                                    null ;

		try
		{
			resultCollection =
			                   ( Collection ) targetCollectionClass
			                                                       .newInstance ( ) ;
		}
		catch ( Exception exception )
		{
			throw new IllegalArgumentException (
			                                     "targetCollectionClass=["
			                                             + targetCollectionClass
			                                                                    .getName ( )
			                                             + "]不正确" ,
			                                     exception ) ;
		}

		resultCollection
		                .addAll ( collection ) ;
		return resultCollection ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:22:35</li>
	 * <li>设计目的：计算集合元素的平均值</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param objects
	 * @param propertyName
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static double avg (
	                           Collection objects ,
	                           String propertyName )
	{
		List < Number > propertyValues =
		                                 CollectionUtil
		                                               .selectProperty (
		                                                                 objects ,
		                                                                 propertyName ) ;
		return CollectionUtil
		                     .avg ( propertyValues ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:23:01</li>
	 * <li>设计目的：计算集合元素的平均值</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param values
	 * @return
	 */
	public static double avg (
	                           Collection < Number > values )
	{
		if ( values == null )
		{
			return 0 ;
		}
		if ( values
		           .isEmpty ( ) )
		{
			return 0 ;
		}
		return CollectionUtil
		                     .sum ( values )
		       / values
		               .size ( ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:59:06</li>
	 * <li>设计目的：将指定集合元素转换为字符串数组</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param elements
	 * @return
	 */
	public static String [ ] collectionToStringArray (
	                                                   Collection < ? > elements )
	{
		String [ ] result =
		                    new String [ elements
		                                         .size ( ) ] ;

		int index =
		            0 ;
		if ( elements != null )
		{
			for ( Object name : elements )
			{
				result [ index ] =
				                   ObjectUtils
				                              .defaultIfNull (
				                                               name ,
				                                               "" )
				                              .toString ( ) ;
				index ++ ;
			}
		}
		return result ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午04:53:06</li>
	 * <li>设计目的：计算链表容量</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param arraySize
	 * @return
	 */
	public static int computeListCapacity (
	                                        int arraySize )
	{
		return ( int ) Math
		                   .min (
		                          5L
		                                  + arraySize
		                                  + ( arraySize / 10 ) ,
		                          Integer.MAX_VALUE ) ;
	}

	@ SuppressWarnings (
	{
		"unchecked"
	} )
	public static < E > Collection < E > emptyCollection (
	                                                       Class < E > clazz )
	{
		return Collections.EMPTY_SET ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:30:49</li>
	 * <li>设计目的：获取单一元素集合对象中的元素值</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param collection
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static Object findSingleObject (
	                                        Collection collection )
	{
		if ( ( collection == null )
		     || collection
		                  .isEmpty ( ) )
		{
			return null ;
		}
		if ( collection
		               .size ( ) > 1 )
		{
			throw new IllegalStateException (
			                                  "集合中出现了多个元素" ) ;
		}
		return collection
		                 .iterator ( )
		                 .next ( ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:33:38</li>
	 * <li>设计目的：判断指定数组是否为空数组</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty (
	                                Object [ ] array )
	{
		return ( ( array == null ) || ( array.length == 0 ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:25:14</li>
	 * <li>设计目的：获取集合元素中的最大值</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param objects
	 * @param propertyName
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static Object max (
	                           Collection objects ,
	                           String propertyName )
	{
		List < Comparable > propertyValues =
		                                     CollectionUtil
		                                                   .selectProperty (
		                                                                     objects ,
		                                                                     propertyName ) ;
		return Collections
		                  .max ( propertyValues ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:24:57</li>
	 * <li>设计目的：获取集合元素中的最小值</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param objects
	 * @param propertyName
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static Object min (
	                           Collection objects ,
	                           String propertyName )
	{
		List < Comparable > propertyValues =
		                                     CollectionUtil
		                                                   .selectProperty (
		                                                                     objects ,
		                                                                     propertyName ) ;
		return Collections
		                  .min ( propertyValues ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:10:16</li>
	 * <li>设计目的：为Map置入合理的键值对</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param map
	 * @param key
	 * @param defaultValue
	 */
	@ SuppressWarnings ( "unchecked" )
	public static void putIfNull (
	                               Map map ,
	                               Object key ,
	                               Object defaultValue )
	{
		if ( key == null )
		{
			throw new IllegalArgumentException (
			                                     "Map的键不允许为空" ) ;
		}
		if ( map == null )
		{
			throw new IllegalArgumentException (
			                                     "Map的值不允许为空" ) ;
		}
		if ( map
		        .get ( key ) == null )
		{
			map
			   .put (
			          key ,
			          defaultValue ) ;
		}
	}
	
	public static void printInfo(Map map) {
		logger.debug("打印信息：");
		Set<String> set = (Set<String>) map.keySet();
		for (String key : set) {

			logger.debug("key是【" + key + "】，value是【" + map.get(key) + "】");
		}
	}
	

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:25:48</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param from
	 * @param propertyName
	 * @return
	 */
	@ SuppressWarnings ( { "unchecked", "rawtypes" } )
	public static List selectProperty (
	                                    Collection from ,
	                                    String propertyName )
	{
		if ( propertyName == null )
		{
			throw new IllegalArgumentException (
			                                     "参数'propertyName'不允许为空" ) ;
		}
		if ( from == null )
		{
			return null ;
		}

		List result =
		              new ArrayList ( ) ;
		for ( Object object : from )
		{
			try
			{
				if ( object == null )
				{
					result
					      .add ( null ) ;
				}
				else
				{
					Object value =
					               PropertyUtils
					                            .getSimpleProperty (
					                                                 object ,
					                                                 propertyName ) ;
					result
					      .add ( value ) ;
				}
			}
			catch ( IllegalAccessException illegalAccessException )
			{
				throw new IllegalArgumentException (
				                                     "无法在对象：["
				                                             + object
				                                             + "]中获取名称为：["
				                                             + propertyName
				                                             + "]的属性值" ,
				                                     illegalAccessException ) ;
			}
			catch ( InvocationTargetException invocationTargetException )
			{
				throw new IllegalArgumentException (
				                                     "无法在对象：["
				                                             + object
				                                             + "]中获取名称为：["
				                                             + propertyName
				                                             + "]的属性值" ,
				                                     invocationTargetException
				                                                              .getTargetException ( ) ) ;
			}
			catch ( NoSuchMethodException noSuchMethodException )
			{
				throw new IllegalArgumentException (
				                                     "未知属性："
				                                             + propertyName ,
				                                     noSuchMethodException ) ;
			}
		}
		return result ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:23:39</li>
	 * <li>设计目的：计算集合中各元素的和</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param objects
	 * @param propertyName
	 * @return
	 */
	@ SuppressWarnings ( "unchecked" )
	public static double sum (
	                           Collection objects ,
	                           String propertyName )
	{
		if ( objects
		            .isEmpty ( ) )
		{
			return 0 ;
		}
		List < Number > propertyValues =
		                                 CollectionUtil
		                                               .selectProperty (
		                                                                 objects ,
		                                                                 propertyName ) ;
		return CollectionUtil
		                     .sum ( propertyValues ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:23:21</li>
	 * <li>设计目的：计算集合中各元素的和</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param values
	 * @return
	 */
	public static double sum (
	                           Collection < Number > values )
	{
		if ( values == null )
		{
			return 0 ;
		}
		if ( values
		           .isEmpty ( ) )
		{
			return 0 ;
		}

		double sum =
		             0 ;
		for ( Number num : values )
		{
			if ( num == null )
			{
				continue ;
			}
			sum +=
			       num
			          .doubleValue ( ) ;
		}
		return sum ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:13:09</li>
	 * <li>设计目的：将对象数组置入Map对象中</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param array
	 * @param keys
	 * @return
	 */
	public static Map < String , Object > toMap (
	                                              Object [ ] array ,
	                                              String ... keys )
	{
		if ( array == null )
		{
			return new HashMap < String , Object > ( ) ;
		}
		Map < String , Object > map =
		                              new LinkedHashMap < String , Object > ( ) ;
		for ( int index =
		                  0 ; index < keys.length ; index ++ )
		{
			if ( array.length == index )
			{
				break ;
			}
			map
			   .put (
			          keys [ index ] ,
			          array [ index ] ) ;
		}
		return map ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:40:30</li>
	 * <li>设计目的：将指定原始类型数组转换为对象数组</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param primitiveArray
	 * @return
	 */
	public static Object [ ] toObjectArray (
	                                         Object primitiveArray )
	{
		if ( primitiveArray == null )
		{
			return new Object [ 0 ] ;
		}
		Class < ? > clazz =
		                    primitiveArray
		                                  .getClass ( ) ;
		if ( ! clazz
		            .isArray ( )
		     || ! clazz
		               .getComponentType ( )
		               .isPrimitive ( ) )
		{
			throw new IllegalArgumentException (
			                                     "The specified parameter is not a primitive array" ) ;
		}
		int length =
		             Array
		                  .getLength ( primitiveArray ) ;
		if ( length == 0 )
		{
			return new Object [ 0 ] ;
		}
		Class < ? > wrapperType =
		                          Array
		                               .get (
		                                      primitiveArray ,
		                                      0 )
		                               .getClass ( ) ;
		Object [ ] newArray =
		                      ( Object [ ] ) Array
		                                          .newInstance (
		                                                         wrapperType ,
		                                                         length ) ;
		for ( int index =
		                  0 ; index < length ; index ++ )
		{
			newArray [ index ] =
			                     Array
			                          .get (
			                                 primitiveArray ,
			                                 index ) ;
		}
		return newArray ;
	}

	/**
	 * 构造函数
	 */
	private CollectionUtil ( )
	{
		super ( ) ;
	}
}

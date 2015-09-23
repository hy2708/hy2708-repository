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
package org.hy.commons.lang.generic ;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-5</li>
 * <li>设计时间：下午04:03:49</li>
 * <li>设计目的：泛型操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class GenericUtil
{
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:17:34</li>
	 * <li>设计目的：加入接口</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param interfaceList
	 * @param clazz
	 */
	private static void addInterface (
	                                   List < Class < ? >> interfaceList ,
	                                   Class < ? > clazz )
	{
		if ( clazz == null )
		{
			return ;
		}
		Class < ? > [ ] interfaces =
		                             clazz
		                                  .getInterfaces ( ) ;
		for ( Class < ? > interface1 : interfaces )
		{
			GenericUtil
			           .addInterface (
			                           interfaceList ,
			                           interface1 ) ;
		}
		if ( clazz
		          .isInterface ( ) == true )
		{
			interfaceList
			             .add ( clazz ) ;
		}
		else
		{
			GenericUtil
			           .addInterface (
			                           interfaceList ,
			                           clazz
			                                .getSuperclass ( ) ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:16:57</li>
	 * <li>设计目的：判断是否匹配</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param declaringClass
	 * @param parameterTypes
	 * @param genericParameterTypes
	 * @return
	 */
	private static boolean allMatches (
	                                    Class < ? > declaringClass ,
	                                    Class < ? > [ ] parameterTypes ,
	                                    Type [ ] genericParameterTypes )
	{
		for ( int index =
		                  0 ; index < genericParameterTypes.length ; index ++ )
		{
			Type type =
			            genericParameterTypes [ index ] ;
			Class < ? > actualClass =
			                          GenericUtil
			                                     .getActualClass (
			                                                       type ,
			                                                       declaringClass ) ;
			if ( parameterTypes [ index ]
			                             .equals ( actualClass ) == false )
			{
				return false ;
			}
		}
		return true ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:06:14</li>
	 * <li>设计目的：搜集类型变量</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @param type
	 * @param map
	 */
	private static void gatherTypeVariables (
	                                          final Class < ? > clazz ,
	                                          final Type type ,
	                                          final Map < TypeVariable < ? > , Type > map )
	{
		if ( clazz == null )
		{
			return ;
		}
		GenericUtil
		           .gatherTypeVariables (
		                                  type ,
		                                  map ) ;

		final Class < ? > superClass =
		                               clazz
		                                    .getSuperclass ( ) ;
		final Type superClassType =
		                            clazz
		                                 .getGenericSuperclass ( ) ;
		if ( superClass != null )
		{
			GenericUtil
			           .gatherTypeVariables (
			                                  superClass ,
			                                  superClassType ,
			                                  map ) ;
		}

		final Class < ? > [ ] interfaces =
		                                   clazz
		                                        .getInterfaces ( ) ;
		final Type [ ] interfaceTypes =
		                                clazz
		                                     .getGenericInterfaces ( ) ;
		for ( int index =
		                  0 ; index < interfaces.length ; ++ index )
		{
			GenericUtil
			           .gatherTypeVariables (
			                                  interfaces [ index ] ,
			                                  interfaceTypes [ index ] ,
			                                  map ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:04:53</li>
	 * <li>设计目的：搜集类型变量</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param map
	 */
	private static void gatherTypeVariables (
	                                          final Type type ,
	                                          final Map < TypeVariable < ? > , Type > map )
	{
		if ( ParameterizedType.class
		                            .isInstance ( type ) )
		{
			final ParameterizedType parameterizedType =
			                                            ParameterizedType.class
			                                                                   .cast ( type ) ;
			final TypeVariable < ? > [ ] typeVariables =
			                                             GenericDeclaration.class
			                                                                     .cast (
			                                                                             parameterizedType
			                                                                                              .getRawType ( ) )
			                                                                     .getTypeParameters ( ) ;
			final Type [ ] actualTypes =
			                             parameterizedType
			                                              .getActualTypeArguments ( ) ;
			for ( int index =
			                  0 ; index < actualTypes.length ; ++ index )
			{
				map
				   .put (
				          typeVariables [ index ] ,
				          actualTypes [ index ] ) ;
			}
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:09:39</li>
	 * <li>设计目的：获取类型的实际类类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param map
	 * @return
	 */
	private static Class < ? > getActualClass (
	                                            Type type ,
	                                            Map < TypeVariable < ? > , Type > map )
	{
		if ( Class.class
		                .isInstance ( type ) )
		{
			return Class.class
			                  .cast ( type ) ;
		}
		if ( ParameterizedType.class
		                            .isInstance ( type ) )
		{
			return GenericUtil
			                  .getActualClass (
			                                    GenericUtil
			                                               .getActualType (
			                                                                type ,
			                                                                map ) ,
			                                    map ) ;
		}
		if ( TypeVariable.class
		                       .isInstance ( type ) )
		{
			return GenericUtil
			                  .getActualClass (
			                                    GenericUtil
			                                               .getActualType (
			                                                                type ,
			                                                                map ) ,
			                                    map ) ;
		}
		if ( GenericArrayType.class
		                           .isInstance ( type ) )
		{
			GenericArrayType genericArrayType =
			                                    GenericArrayType.class
			                                                          .cast ( type ) ;
			Class < ? > componentClass =
			                             GenericUtil
			                                        .getActualClass (
			                                                          genericArrayType
			                                                                          .getGenericComponentType ( ) ,
			                                                          map ) ;
			return Array
			            .newInstance (
			                           componentClass ,
			                           0 )
			            .getClass ( ) ;
		}
		return null ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:09:06</li>
	 * <li>设计目的：获取实际类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param map
	 * @return
	 */
	private static Type getActualType (
	                                    Type type ,
	                                    Map < TypeVariable < ? > , Type > map )
	{
		if ( Class.class
		                .isInstance ( type ) )
		{
			return type ;
		}
		if ( ParameterizedType.class
		                            .isInstance ( type ) )
		{
			return ParameterizedType.class
			                              .cast (
			                                      type )
			                              .getRawType ( ) ;
		}
		if ( TypeVariable.class
		                       .isInstance ( type ) )
		{
			return map
			          .get ( TypeVariable.class
			                                   .cast ( type ) ) ;
		}
		return null ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:17:55</li>
	 * <li>设计目的：获取所有接口</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param declaringClass
	 * @return
	 */
	private static Class < ? > [ ] getAllInterfaces (
	                                                  Class < ? > declaringClass )
	{
		List < Class < ? >> interfaceList =
		                                    new ArrayList < Class < ? >> ( ) ;
		GenericUtil
		           .addInterface (
		                           interfaceList ,
		                           declaringClass ) ;
		return interfaceList
		                    .toArray ( new Class [ interfaceList
		                                                        .size ( ) ] ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:06:48</li>
	 * <li>设计目的：获取类型变量Map</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @return
	 */
	private static Map < TypeVariable < ? > , Type > getTypeVariableMap (
	                                                                      final Class < ? > clazz )
	{
		final Map < TypeVariable < ? > , Type > map =
		                                              new LinkedHashMap < TypeVariable < ? > , Type > ( ) ;

		if ( clazz == null )
		{
			return map ;
		}

		final Class < ? > superClass =
		                               clazz
		                                    .getSuperclass ( ) ;
		final Type superClassType =
		                            clazz
		                                 .getGenericSuperclass ( ) ;
		if ( superClass != null )
		{
			GenericUtil
			           .gatherTypeVariables (
			                                  superClass ,
			                                  superClassType ,
			                                  map ) ;
		}

		final Class < ? > [ ] interfaces =
		                                   clazz
		                                        .getInterfaces ( ) ;
		final Type [ ] interfaceTypes =
		                                clazz
		                                     .getGenericInterfaces ( ) ;
		for ( int index =
		                  0 ; index < interfaces.length ; ++ index )
		{
			GenericUtil
			           .gatherTypeVariables (
			                                  interfaces [ index ] ,
			                                  interfaceTypes [ index ] ,
			                                  map ) ;
		}

		return map ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:13:34</li>
	 * <li>设计目的：获取实际类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param targetClass
	 * @return
	 */
	public static Class < ? > getActualClass (
	                                           Type type ,
	                                           Class < ? > targetClass )
	{
		Map < TypeVariable < ? > , Type > map =
		                                        GenericUtil
		                                                   .getTypeVariableMap ( targetClass ) ;
		return GenericUtil
		                  .getActualClass (
		                                    type ,
		                                    map ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:10:10</li>
	 * <li>设计目的：获取实际类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param targetClass
	 * @return
	 */
	public static Type getActualType (
	                                   Type type ,
	                                   Class < ? > targetClass )
	{
		Map < TypeVariable < ? > , Type > map =
		                                        GenericUtil
		                                                   .getTypeVariableMap ( targetClass ) ;
		return GenericUtil
		                  .getActualType (
		                                   type ,
		                                   map ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:15:39</li>
	 * <li>设计目的：获取集合元素类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Type getElementTypeOfCollection (
	                                                Type type )
	{
		if (GenericUtil.isTypeOf(type, Collection.class) == false) {
			return null;
		}
		return GenericUtil.getTypeParameter(type, 0);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:15:01</li>
	 * <li>设计目的：获取Map键的类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Type getKeyTypeOfMap (
	                                     Type type )
	{
		if ( GenericUtil
		                .isTypeOf (
		                            type ,
		                            Map.class ) == false )
		{
			return null ;
		}
		return GenericUtil
		                  .getTypeParameter (
		                                      type ,
		                                      0 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:08:28</li>
	 * <li>设计目的：获取类型的原始类类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Class < ? > getRawClass (
	                                        Type type )
	{
		if ( Class.class
		                .isInstance ( type ) )
		{
			return Class.class
			                  .cast ( type ) ;
		}
		if ( ParameterizedType.class
		                            .isInstance ( type ) )
		{
			ParameterizedType parameterizedType =
			                                      ParameterizedType.class
			                                                             .cast ( type ) ;
			return GenericUtil
			                  .getRawClass ( parameterizedType
			                                                  .getRawType ( ) ) ;
		}
		if ( GenericArrayType.class
		                           .isInstance ( type ) )
		{
			GenericArrayType genericArrayType =
			                                    GenericArrayType.class
			                                                          .cast ( type ) ;
			Class < ? > rawClass =
			                       GenericUtil
			                                  .getRawClass ( genericArrayType
			                                                                 .getGenericComponentType ( ) ) ;
			return Array
			            .newInstance (
			                           rawClass ,
			                           0 )
			            .getClass ( ) ;
		}
		return null ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:07:43</li>
	 * <li>设计目的：获取指定索引位置的泛型参数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param index
	 * @return
	 */
	public static Type getTypeParameter (
	                                      Type type ,
	                                      int index )
	{
		Type[] genericParameters = GenericUtil.getTypeParameters(type);
		if (genericParameters == null) {
			return null;
		}
		return genericParameters[index];
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:07:22</li>
	 * <li>设计目的：获取类型参数数组</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Type [ ] getTypeParameters (
	                                           Type type )
	{
		if (ParameterizedType.class.isInstance(type)) {
			return ParameterizedType.class.cast(type).getActualTypeArguments();
		}
		if (GenericArrayType.class.isInstance(type)) {
			return GenericUtil.getTypeParameters(GenericArrayType.class.cast(
					type).getGenericComponentType());
		}
		if (Class.class.isInstance(type)) {
			return Class.class.cast(type).getTypeParameters();
		}
		return new Type[0];
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:14:25</li>
	 * <li>设计目的：获取Map值的类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @return
	 */
	public static Type getValueTypeOfMap (
	                                       Type type )
	{
		if ( GenericUtil
		                .isTypeOf (
		                            type ,
		                            Map.class ) == false )
		{
			return null ;
		}
		return GenericUtil
		                  .getTypeParameter (
		                                      type ,
		                                      1 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:18:54</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param method
	 * @return
	 */
	public static boolean isImplMethod (
	                                     Method method )
	{
		Class < ? > declaringClass =
		                             method
		                                   .getDeclaringClass ( ) ;
		Class < ? > [ ] parameterTypes =
		                                 method
		                                       .getParameterTypes ( ) ;
		Class < ? > [ ] interfaces =
		                             GenericUtil
		                                        .getAllInterfaces ( declaringClass ) ;
		for ( Class < ? > interfaceClass : interfaces )
		{
			Method [ ] methods =
			                     interfaceClass
			                                   .getMethods ( ) ;
			for ( Method methodTemp : methods )
			{
				String methodName =
				                    method
				                          .getName ( ) ;
				if ( methodTemp
				               .getName ( )
				               .equals (
				                         methodName ) == false )
				{
					continue ;
				}
				Type [ ] genericParameterTypes =
				                                 methodTemp
				                                           .getGenericParameterTypes ( ) ;
				if ( GenericUtil
				                .allMatches (
				                              declaringClass ,
				                              parameterTypes ,
				                              genericParameterTypes ) )
				{
					return true ;
				}
			}
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-5</li>
	 * <li>设计时间：下午04:13:56</li>
	 * <li>设计目的：是否为指定类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param type
	 * @param clazz
	 * @return
	 */
	public static boolean isTypeOf (
	                                 Type type ,
	                                 Class < ? > clazz )
	{
		if ( Class.class
		                .isInstance ( type ) )
		{
			return clazz
			            .isAssignableFrom ( Class.class
			                                           .cast ( type ) ) ;
		}
		if ( ParameterizedType.class
		                            .isInstance ( type ) )
		{
			ParameterizedType parameterizedType =
			                                      ParameterizedType.class
			                                                             .cast ( type ) ;
			return GenericUtil
			                  .isTypeOf (
			                              parameterizedType
			                                               .getRawType ( ) ,
			                              clazz ) ;
		}
		return false ;
	}

	/**
	 * 构造函数
	 */
	private GenericUtil ( )
	{
		super ( ) ;
	}
	
	/**  
     * 通过反射,获得指定类的父类的泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的类,该类必须继承范型父类
     * @param index 泛型参数所在索引,从0开始.  
     * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
    @SuppressWarnings({"unchecked", "rawtypes"})
	public static Class getSuperClassGenricType(Class clazz, int index) {    
       return GenericsUtils.getSuperClassGenricType( clazz,  index);
    }
	/**  
     * 通过反射,获得指定类的父类的第一个泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>  
     *  
     * @param clazz clazz 需要反射的类,该类必须继承泛型父类
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */  
    @SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz) {
    	return getSuperClassGenricType(clazz,0);
    }
	/**  
     * 通过反射,获得方法返回值泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @param int index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Class getMethodGenericReturnType(Method method, int index) {
    	return GenericsUtils.getMethodGenericReturnType(method, index);
    }
	/**  
     * 通过反射,获得方法返回值第一个泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
     *  
     * @param Method method 方法
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getMethodGenericReturnType(Method method) {
    	return getMethodGenericReturnType(method, 0);
    }
    
	/**  
     * 通过反射,获得方法输入参数第index个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method 方法
     * @param int index 第几个输入参数
     * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */ 
    @SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method, int index) {
    	return GenericsUtils.getMethodGenericParameterTypes( method,  index);
    }
	/**  
     * 通过反射,获得方法输入参数第一个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer> maps, List<String> names){}
     *  
     * @param Method method 方法
     * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
     */ 
    @SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method) {
    	return getMethodGenericParameterTypes(method, 0);
    }
	/**  
     * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
     *  
     * @param Field field 字段
     * @param int index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field, int index) {
    	return GenericsUtils.getFieldGenericType( field,  index);
    }
	/**  
     * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
     *  
     * @param Field field 字段
     * @param int index 泛型参数所在索引,从0开始.
     * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回<code>Object.class</code>
     */ 
    @SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field) {
    	return getFieldGenericType(field, 0);
    }
}

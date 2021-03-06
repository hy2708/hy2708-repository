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
package org.hy.commons.lang.annotation ;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hy.commons.lang.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午01:28:41</li>
 * <li>设计目的：Annotation注解操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class AnnotationUtil
{
	
	public static void main(String[] args) {
		
	}
	static Logger logger = LoggerFactory.getLogger(AnnotationUtil.class);
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获取类名上的所有注解<br/>
	 * <b>注意：有的注解，不能被获取到，例如：@SuppressWarnings
	 * </b>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-26；时间：下午6:12:45</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param clazz
	 * @return
	 */
	public static Annotation[] getAllAnnotations(Class<?> clazz) {
		Annotation[] annotations = clazz.getAnnotations();
		if (annotations==null||annotations.length==0) {
			logger.warn("类【" +
					clazz.getName()+"】的类名上，没有注解！");
		} else {
			logger.debug("类【" +
					clazz.getName()+"】的类名上，包含如下注解：");
			for (Annotation annotation : annotations) {
				logger.debug("类【" +
						clazz.getName()+"】的类名上，包含注解：【" +
						annotation.annotationType()+"】"
						);
			}
		}
		return annotations;
		
	}
	
	public static Annotation[] getAllAnnotations(Method method) {
		Annotation[] annotations = method.getAnnotations();
		if (annotations==null||annotations.length==0) {
			logger.warn("方法【" +
					method.getName()+"】的方法名上，没有注解！");
		} else {
			logger.debug("方法【" +
					method.getName()+"】的方法名上，包含如下注解：");
			for (Annotation annotation : annotations) {
				logger.debug("方法【" +
						method.getName()+"】的方法名上，包含注解：【" +
						annotation.annotationType()+"】"
						);
			}
		}
		return annotations;
	}
	
	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午05:13:59</li>
	 * <li>设计目的：获取目标类的类名上,指定类型上指定注解类型的注解对象</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <A>
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> A getAnnotation(Class<?> targetClass,
			Class<A> annotationClass) {
		if (AnnotationUtil.isClassAnnotationPresent(targetClass,
				annotationClass)) {
			return targetClass.getAnnotation(annotationClass);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获取目标类的属性名上,指定类型上指定注解类型的注解对象</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-1；时间：下午9:28:43</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param method
	 * @param annotationClass
	 * @return
	 * @return
	 */
	public static <A extends Annotation> A getAnnotation(Field method,
			Class<A> annotationClass) {
		if (AnnotationUtil.isFieldAnnotationPresent(method, annotationClass)) {
			return method.getAnnotation(annotationClass);
		} else {
			return null;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午12:34:13</li>
	 * <li>设计目的：获取指定方法中指定类型的注解</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <A>
	 * @param method
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> A getAnnotation(Method method,
			Class<A> annotationClass) {
		if (AnnotationUtil.isMethodAnnotationPresent(method, annotationClass)) {
			return method.getAnnotation(annotationClass);
		} else {
			return null;
		}
	}
	
	
	
	

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：下午01:59:49</li>
	 * <li>设计目的：获取属性或Getter方法上指定类型的注解</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <A>
	 * @param getter
	 * @param annotationClass
	 * @return
	 */
	public static < A extends Annotation > A getPropertyOrGetterAnnotation (
	                                                                         Method getter ,
	                                                                         Class < A > annotationClass )
	{
		if ( getter
		           .isAnnotationPresent ( annotationClass ) )
		{
			return getter
			             .getAnnotation ( annotationClass ) ;
		}

		String propertyNameForGetter =
		                               ObjectUtil
		                                         .propertyNameForGetter ( getter ) ;
		try
		{
			Field field =
			              getter
			                    .getDeclaringClass ( )
			                    .getDeclaredField (
			                                        propertyNameForGetter ) ;
			return field
			            .getAnnotation ( annotationClass ) ;
		}
		catch ( NoSuchFieldException noSuchFieldException )
		{
			return null ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午05:13:10</li>
	 * <li>设计目的：判断指定类<code>targetClass</code>是否标记了<code>annotationClass</code>注解
	 * </li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param targetClass
	 * @param annotationClass
	 * @return
	 */
	public static < A extends Annotation > boolean isClassAnnotationPresent (
	                                                                          Class < ? > targetClass ,
	                                                                          Class < A > annotationClass )
	{
		if ( ( null == targetClass )
		     || ( null == annotationClass ) )
		{
			return false ;
		}
		return targetClass
		                  .isAnnotationPresent ( annotationClass ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:29:35</li>
	 * <li>设计目的：判断指定的类型指定名称属性的字段中是否出现了指定类型的注解</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param targetClass
	 * @param annotationClass
	 * @param propertyName
	 * @return
	 * @throws NoSuchFieldException
	 */
	public static < A extends Annotation > boolean isFieldAnnotationPresent (
	                                                                          Class < ? > targetClass ,
	                                                                          Class < A > annotationClass ,
	                                                                          String propertyName )
	                                                                                               throws NoSuchFieldException
	{
		return targetClass
		                  .getDeclaredField (
		                                      propertyName )
		                  .getAnnotation (
		                                   annotationClass ) != null ;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：判断指定类<code>targetClass</code>在属性上，是否标记了<code>annotationClass</code>注解</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-1；时间：下午9:31:31</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param field
	 * @param annotationClass
	 * @return
	 * @return
	 */
	public static <A extends Annotation> boolean isFieldAnnotationPresent(
			Field field, Class<A> annotationClass) {
		if ((null == annotationClass) || (field == null)) {
			return false;
		}
		return field.isAnnotationPresent(annotationClass);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:32:03</li>
	 * <li>设计目的：判断指定类型的指定名称属性的获取器方法中是否出现了指定类型的注解</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param targetClass
	 * @param annotationClass
	 * @param propertyName
	 * @return
	 * @throws NoSuchMethodException
	 */
	public static <A extends Annotation> boolean isGetterAnnotationPresent(
			Class<?> targetClass, Class<A> annotationClass, String propertyName)
			throws NoSuchMethodException {
		/*boolean isAnnotationPresent = false;
		String getterMethod = ClassUtil.composeGetter(propertyName);
		Method method = ReflectionUtil.getDeclaredMethod(targetClass,
				getterMethod, null);
		if (method != null) {
			isAnnotationPresent = method.getAnnotation(annotationClass) != null;
		}
		return isAnnotationPresent;*/
		return false;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-7</li>
	 * <li>设计时间：下午12:32:25</li>
	 * <li>设计目的：判断指定方法中是否出现指定注解</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param <A>
	 * @param method
	 * @param annotationClass
	 * @return
	 */
	public static <A extends Annotation> boolean isMethodAnnotationPresent(
			Method method, Class<A> annotationClass) {
		if ((null == annotationClass) || (method == null)) {
			return false;
		}
		return method.isAnnotationPresent(annotationClass);
	}

	/**
	 * 构造函数
	 */
	private AnnotationUtil ( )
	{
		super ( ) ;
	}
}

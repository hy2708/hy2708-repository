package org.hy.commons.lang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-2-1；时间：下午8:39:16</li>
 * <li>类型名称：MyAnnotation</li>
 * <li>设计目的：<b>一个定义好的注解的例子</b>
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
/* 
 * 时间轴，也就是存在的，有效期
 * 该注解描述了作用范围
 *   java             RetentionPolicy.SOURCE
 *   java+class       RetentionPolicy.CLASS
 *   java+class+jvm   RetentionPolicy.RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * 空间面，即，可以使用该注解的位置
 * ElementType.TYPE,用在 类，接口或者枚举声明
 * ElementType.FIELD, 用在字段
 * ElementType.METHOD 用在方法上
 */
@Target(value={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Documented//是否在帮助文档中出现

public @interface MyAnnotation {
	/*
	 * String[] value1() default "abc";
	 * String[] 是 该注解，中的，一个属性value的数据类型
	 * value1() 是该注解，中的一个名为value1的变量的名字
	 * default "abc"; 是该注解，中的一个名为value1的变量的默认值
	 */
    String[] value1() default "abc";
    String[] value2() default "vvv";
}

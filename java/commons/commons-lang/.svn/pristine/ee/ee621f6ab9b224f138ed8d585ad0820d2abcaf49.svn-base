/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-9</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang.math ;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.commons.lang.math.NumberUtils;


//import com.vsoft.libra.enterprise.framework.lang.LibraRuntimeException;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-9</li>
 * <li>设计时间：下午04:54:13</li>
 * <li>设计目的：数字操作助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class NumberUtil extends NumberUtils
{
	

	
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:04:38</li>
	 * <li>设计目的：将指定字符串解码为{@link java.math.BigInteger}类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param value
	 * @return
	 */
	private static BigInteger decodeBigInteger (
	                                             String value )
	{
		int radix =
		            10 ;
		int index =
		            0 ;
		boolean negative =
		                   false ;
		if ( value
		          .startsWith ( "-" ) )
		{
			negative =
			           true ;
			index ++ ;
		}
		if ( value
		          .startsWith (
		                        "0x" ,
		                        index )
		     || value
		             .startsWith (
		                           "0X" ,
		                           index ) )
		{
			index +=
			         2 ;
			radix =
			        16 ;
		}
		else if ( value
		               .startsWith (
		                             "#" ,
		                             index ) )
		{
			index ++ ;
			radix =
			        16 ;
		}
		else if ( value
		               .startsWith (
		                             "0" ,
		                             index )
		          && ( value
		                    .length ( ) > 1 + index ) )
		{
			index ++ ;
			radix =
			        8 ;
		}

		BigInteger result =
		                    new BigInteger (
		                                     value
		                                          .substring ( index ) ,
		                                     radix ) ;
		return ( negative
		                 ? result
		                         .negate ( )
		                 : result ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:01:55</li>
	 * <li>设计目的：抛出堆栈溢出异常</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param number
	 * @param targetClass
	 */
	private static void raiseOverflowException (
	                                             Number number ,
	                                             Class < ? > targetClass )
	{
		throw new IllegalArgumentException (
		                                     "无法将类型为：["
		                                             + number
		                                                     .getClass ( )
		                                                     .getName ( )
		                                             + "]的数字：["
		                                             + number
		                                             + "]转换为目标类型：["
		                                             + targetClass
		                                                          .getName ( )
		                                             + "]，出现类溢出异常" ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:01:21</li>
	 * <li>设计目的：将给定数字转换为指定的目标类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param number
	 * @param targetClass
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Number convertNumberToTargetClass (
	                                                  Number number ,
	                                                  Class < ? > targetClass )
	                                                                           throws IllegalArgumentException
	{
		if ( ( null == number )
		     || ( null == targetClass ) )
		{
			throw new
			//LibraRuntimeException 
			RuntimeException(
			                                  "给定的数字参数或类型参数不能为空" ) ;
		}
		if ( targetClass
		                .isInstance ( number ) )
		{
			return number ;
		}
		else if ( targetClass
		                     .equals ( Byte.class ) )
		{
			long value =
			             number
			                   .longValue ( ) ;
			if ( ( value < Byte.MIN_VALUE )
			     || ( value > Byte.MAX_VALUE ) )
			{
				NumberUtil
				          .raiseOverflowException (
				                                    number ,
				                                    targetClass ) ;
			}
			return new Byte (
			                  number
			                        .byteValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( Short.class ) )
		{
			long value =
			             number
			                   .longValue ( ) ;
			if ( ( value < Short.MIN_VALUE )
			     || ( value > Short.MAX_VALUE ) )
			{
				NumberUtil
				          .raiseOverflowException (
				                                    number ,
				                                    targetClass ) ;
			}
			return new Short (
			                   number
			                         .shortValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( Integer.class ) )
		{
			long value =
			             number
			                   .longValue ( ) ;
			if ( ( value < Integer.MIN_VALUE )
			     || ( value > Integer.MAX_VALUE ) )
			{
				NumberUtil
				          .raiseOverflowException (
				                                    number ,
				                                    targetClass ) ;
			}
			return new Integer (
			                     number
			                           .intValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( Long.class ) )
		{
			return new Long (
			                  number
			                        .longValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( Float.class ) )
		{
			return new Float (
			                   number
			                         .floatValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( Double.class ) )
		{
			return new Double (
			                    number
			                          .doubleValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( BigInteger.class ) )
		{
			return BigInteger
			                 .valueOf ( number
			                                  .longValue ( ) ) ;
		}
		else if ( targetClass
		                     .equals ( BigDecimal.class ) )
		{
			// using BigDecimal(String) here, to avoid unpredictability of
			// BigDecimal(double)
			// (see BigDecimal javadoc for details)
			return new BigDecimal (
			                        number
			                              .toString ( ) ) ;
		}
		else
		{
			throw new IllegalArgumentException (
			                                     "Could not convert number ["
			                                             + number
			                                             + "] of type ["
			                                             + number
			                                                     .getClass ( )
			                                                     .getName ( )
			                                             + "] to unknown target class ["
			                                             + targetClass
			                                                          .getName ( )
			                                             + "]" ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:08:24</li>
	 * <li>设计目的：将给定数字字符串转换为目标类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param text
	 * @param targetClass
	 * @return
	 */
	public static Number parseNumber (
	                                   String text ,
	                                   Class < ? > targetClass )
	{
		if ( ( null == text )
		     || ( null == targetClass ) )
		{
			throw new 
			//LibraRuntimeException 
			RuntimeException(
			                                  "给定字符串文本和目标类型不允许为空" ) ;
		}
		String trimmed =
		                 text
		                     .trim ( ) ;

		if ( targetClass
		                .equals ( Byte.class ) )
		{
			return Byte
			           .decode ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( Short.class ) )
		{
			return Short
			            .decode ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( Integer.class ) )
		{
			return Integer
			              .decode ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( Long.class ) )
		{
			return Long
			           .decode ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( BigInteger.class ) )
		{
			return NumberUtil
			                 .decodeBigInteger ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( Float.class ) )
		{
			return Float
			            .valueOf ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( Double.class ) )
		{
			return Double
			             .valueOf ( trimmed ) ;
		}
		else if ( targetClass
		                     .equals ( BigDecimal.class )
		          || targetClass
		                        .equals ( Number.class ) )
		{
			return new BigDecimal (
			                        trimmed ) ;
		}
		else
		{
			throw new IllegalArgumentException (
			                                     "无法将字符串：["
			                                             + text
			                                             + "]转换为类型：["
			                                             + targetClass
			                                                          .getName ( )
			                                             + "]的字符串" ) ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午01:08:16</li>
	 * <li>设计目的：将给定数字字符串转换为目标类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param text
	 * @param targetClass
	 * @param numberFormat
	 * @return
	 */
	public static Number parseNumber (
	                                   String text ,
	                                   Class < ? > targetClass ,
	                                   NumberFormat numberFormat )
	{
		if ( numberFormat != null )
		{
			if ( ( null == text )
			     || ( null == targetClass ) )
			{
				throw new 
				//LibraRuntimeException
				RuntimeException(
				                                  "给定字符串文本和目标类型不允许为空" ) ;
			}
			try
			{
				Number number =
				                numberFormat
				                            .parse ( text
				                                         .trim ( ) ) ;
				return NumberUtil
				                 .convertNumberToTargetClass (
				                                               number ,
				                                               targetClass ) ;
			}
			catch ( ParseException parseException )
			{
				throw new IllegalArgumentException (
				                                     parseException
				                                                   .getMessage ( ) ) ;
			}
		}
		else
		{
			return NumberUtil
			                 .parseNumber (
			                                text ,
			                                targetClass ) ;
		}
	}
	
	
	public static String toHex(String number) {
		return Integer.toHexString(Integer.valueOf(number)).toString();
	}
	
	public static String toNumber(String number,Integer radix) {
		return Integer.valueOf(number, radix).toString();
	}

	public static String toOctal(String number) {
		return Integer.toOctalString(Integer.valueOf(number)).toString();
	}

	/**
	 * 构造函数
	 */
	private NumberUtil ( )
	{
		super ( ) ;
	}
}

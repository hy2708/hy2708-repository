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
package org.hy.commons.lang.string ;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.bean.BeanTemplateParser;
import jodd.io.FileUtil;
import jodd.io.StreamUtil;
import jodd.util.StringTemplateParser;

import org.apache.commons.lang.StringUtils;

//import com.vsoft.libra.enterprise.framework.lang.LibraRuntimeException;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-4</li>
 * <li>设计时间：下午01:54:08</li>
 * <li>设计目的：

 * </li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class StringUtil extends jodd.util.StringUtil
{
	public static void main(String[] args) {
		String string = "adfad";
		string.substring(2);
		 int  dist  =  StringUtils.getLevenshteinDistance(  " Word " ,  " World "  );  
		 int  dist2  =  StringUtils.getLevenshteinDistance(  " username " ,  " name "  );  
		 int  dist3  =  StringUtils.getLevenshteinDistance(    " name " ," username " );  
		  
		String diff  =  StringUtils.difference(  " Word " ,  " World "  );  
		String diff2  =  StringUtils.difference(  " Wordd " ,  " Worlldd "  );  
		String diff3  =  StringUtils.difference(  " username" ,  " name"  );  
		String diff4  =  StringUtils.difference(  " name" , " username"  );  
		  
		 int  index  =  StringUtils.indexOfDifference(  " Word " ,  " World "  );  
		  
		System.out.println(  " Edit Distance:  "   +  dist );  
		System.out.println(  " Edit Distance:  "   +  dist2 );  
		System.out.println(  " Edit Distance:  "   +  dist3 );  
		  
		System.out.println(  " Difference:  "   +  diff3 );  
		System.out.println(  " Difference:  "   +  diff4 );  
		  
		System.out.println(  " Diff Index:  "   +  index ); 
	}
	public static final String	HEX_CHARS	=
	                                          "0123456789ABCDEF" ;

	private static  SimpleStringTemplateParser stp = null;

	public static StringTemplateParser getStringTemplateParser() {
		if (stp == null) {			
			stp =new SimpleStringTemplateParser();
		}
		return stp;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午10:13:54</li>
	 * <li>设计目的：判断给定文本中指定字符出现的次数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param text
	 * @param character
	 * @return
	 */
	public static int countChar(String text, char character) {
		int count = 0;

		String tempText = text;

		int pos = tempText.indexOf(character);
		while (pos != -1) {
			count++;

			pos = tempText.indexOf(character, pos + 1);
		}

		return count;
	}
	public static Boolean contains(String str, String searchChar) {
		//StringUtils.containsIgnoreCase(str, searchStr)
		return StringUtils.contains(str, searchChar);
	}
	public static Boolean containsIgnoreCase(String str, String searchChar) {
		//StringUtils.containsIgnoreCase(str, searchStr)
		return StringUtils.containsIgnoreCase(str, searchChar);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:44:27</li>
	 * <li>设计目的：获取指定字符串中指定字符所出现的次数</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @param countChar
	 * @return
	 */
	public static int getCount(String string, char countChar) {
		if ((string == null) || (string.length() == 0)) {
			return 0;
		}
		int counter = 0;
		char[] array = string.toCharArray();
		for (char element : array) {
			if (element == countChar) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：下午05:12:36</li>
	 * <li>设计目的：判断指定文本中是否有内容</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean hasLength(String string) {
		return isNotEmpty(string);
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-8</li>
	 * <li>设计时间：下午05:11:54</li>
	 * <li>设计目的：判断指定字符串是否含有文本</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean hasText (
	                                String string )
	{
		if ( ! StringUtil
		                 .hasLength ( string ) )
		{
			return false ;
		}
		int strLen =
		             string
		                   .length ( ) ;
		for ( int index =
		                  0 ; index < strLen ; index ++ )
		{
			if ( ! Character
			                .isWhitespace ( string
			                                      .charAt ( index ) ) )
			{
				return true ;
			}
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:46:05</li>
	 * <li>设计目的：判断给定字符串中是否都为8位字符</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean is8Bit (
	                               String string )
	{
		if ( ( string == null )
		     || ( string
		                .length ( ) == 0 ) )
		{
			return true ;
		}
		char [ ] characters =
		                      string
		                            .toCharArray ( ) ;
		for ( char character : characters )
		{
			if ( character > 255 )
			{
				return false ;
			}
		}
		return true ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:52:01</li>
	 * <li>设计目的：判断给定字符串是否为{@link java.math.BigDecimal}类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isBigDecimal (
	                                     String string )
	{
		try
		{
			new BigDecimal (
			                 string
			                       .trim ( ) ) ;
			return true ;
		}
		catch ( Exception exception )
		{
			return false ;
		}
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:53:14</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param strDate1
	 * @param strDate2
	 * @param DateFormatter
	 * @return
	 * @throws ParseException
	 */
	public static boolean isBiggerDate (
	                                     String strDate1 ,
	                                     String strDate2 ,
	                                     DateFormat DateFormatter )
	                                                               throws ParseException
	{
		final Calendar Date1 =
		                       Calendar
		                               .getInstance ( ) ;
		Date1
		     .setTime ( DateFormatter
		                             .parse ( strDate1 ) ) ;
		final long MillisDate1 =
		                         Date1
		                              .getTimeInMillis ( ) ;
		final Calendar Date2 =
		                       Calendar
		                               .getInstance ( ) ;
		Date2
		     .setTime ( DateFormatter
		                             .parse ( strDate2 ) ) ;
		final long MillisDate2 =
		                         Date2
		                              .getTimeInMillis ( ) ;
		if ( MillisDate1 > MillisDate2 )
		{
			return true ;
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:53:39</li>
	 * <li>设计目的：判断给定字符串是否为日期类型</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param reference
	 * @return
	 */
	public static boolean isDateTime (
	                                   String reference )
	{
		if ( ( reference == null )
		     || reference
		                 .equals ( "" ) )
		{
			return false ;
		}
		switch ( Integer
		                .valueOf (
		                           reference )
		                .intValue ( ) )
		{
			case 15 :
			case 16 :
			case 24 :
				return true ;
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:54:15</li>
	 * <li>设计目的：判断给定字符串是否为带小数的数字</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param reference
	 * @return
	 */
	public static boolean isDecimalNumber (
	                                        String reference )
	{
		if ( ( reference == null )
		     || reference
		                 .equals ( "" ) )
		{
			return false ;
		}
		switch ( Integer
		                .valueOf (
		                           reference )
		                .intValue ( ) )
		{
			case 12 :
			case 22 :
			case 29 :
			case 80008 :
				return true ;
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午12:57:40</li>
	 * <li>设计目的：判断指定字符串是否为空</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty (
	                                String string )
	{
		return ! ( StringUtil
		                     .isNotEmpty ( string ) ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:36:22</li>
	 * <li>设计目的：判断给定字符是否为十六进制字符</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param character
	 * @return
	 */
	public static final boolean isHexStringChar (
	                                              char character )
	{
		return ( ( "0123456789abcdefABCDEF"
		                                   .indexOf ( character ) ) >= 0 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:54:51</li>
	 * <li>设计目的：判断给定字符串是否为整型数字</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param reference
	 * @return
	 */
	public static boolean isIntegerNumber (
	                                        String reference )
	{
		if ( ( reference == null )
		     || reference
		                 .equals ( "" ) )
		{
			return false ;
		}
		switch ( Integer
		                .valueOf (
		                           reference )
		                .intValue ( ) )
		{
			case 11 :
			case 13 :
			case 25 :
				return true ;
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-10</li>
	 * <li>设计时间：上午12:57:17</li>
	 * <li>设计目的：判断指定字符串是否不为空</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty (
	                                   String string )
	{
		return ( string != null )
		       && ( string
		                  .length ( ) > 0 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：下午04:04:28</li>
	 * <li>设计目的：判断给定对象是否为空字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNullOrEmptyString (
	                                            Object object )
	{
		if ( object == null )
		{
			return true ;
		}
		if ( object instanceof String )
		{
			String string =
			                ( String ) object ;
			if ( string
			           .length ( ) == 0 )
			{
				return true ;
			}
		}
		return false ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:47:26</li>
	 * <li>设计目的：判断给定字符串是否为数字</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isNumeric (
	                                  String input )
	{
		if ( StringUtil
		               .isEmpty ( input ) )
		{
			return false ;
		}
		for ( int index =
		                  0 ; index < input
		                                   .length ( ) ; index ++ )
		{
			if ( ! Character
			                .isDigit ( input
			                                .charAt ( index ) ) )
			{
				return false ;
			}
		}
		return true ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:48:12</li>
	 * <li>设计目的：判断给定代表布尔型的字符传是否为“真”</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param booleanString
	 * @return
	 */
	public static boolean isTrue (
	                               String booleanString )
	{
		boolean test =
		               false ;

		if ( null != booleanString )
		{
			if ( booleanString
			                  .equalsIgnoreCase ( "Y" ) )
			{
				test =
				       true ;
			}
			else if ( booleanString
			                       .equalsIgnoreCase ( "YES" ) )
			{
				test =
				       true ;
			}
			else if ( booleanString
			                       .equalsIgnoreCase ( "T" ) )
			{
				test =
				       true ;
			}
			else if ( booleanString
			                       .equalsIgnoreCase ( "TRUE" ) )
			{
				test =
				       true ;
			}
		}

		return test ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:51:00</li>
	 * <li>设计目的：判断给定字符串是否为UUID字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isUUIDString (
	                                     String string )
	{
		if ( string
		           .length ( ) == 32 )
		{
			for ( int index =
			                  0 ; index < string
			                                    .length ( ) ; index ++ )
			{
				if ( ! StringUtil
				                 .isHexStringChar ( string
				                                          .charAt ( index ) ) )
				{
					return false ;
				}
			}
			return true ;
		}
		return false ;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：解析字符串<br/>
	 * <code>String template = "Hello ${user.name}. Today is ${dayName}.";</code>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-3；时间：下午1:02:00</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param template
	 * @param contextBean
	 * @return
	 * @return
	 */
	public static String parseTemplate(String template,Map<String, Object> contextBean) {
		    String result = stp.parse(template, contextBean);
		    return result;
	}

	public static String parseTemplate(InputStream in,Map<String, Object> contextBean) {
		String template=null;
		try {
			char[] chars =StreamUtil.readChars(in, "utf8");
			template =String.valueOf(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parseTemplate(template, contextBean);

	}
	public static String parseTemplate(File templateFile,Map<String, Object> contextBean) {
		String template=null;
		try {
			template = FileUtil.readString( templateFile,"utf8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parseTemplate(template, contextBean);
	}


	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-15</li>
	 * <li>设计时间：上午09:32:51</li>
	 * <li>设计目的：</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @param from
	 * @param to
	 * @return
	 */
	public static String replaceAllOccurances(String string, String from,
			String to) {
		if ((string == null) || (string.length() == 0)) {
			return string;
		} else if ((string.length() == 1) && string.equals(from)) {
			return to;
		} else if ((string.length() == 1) && !string.equals(from)) {
			return string;
		}
		int index = -1;
		while ((index = string.indexOf(from)) >= 0) {
			string = string.substring(0, index) + (char) 5
					+ string.substring(index + from.length());
		}
		int sunIndex = -1;
		while ((sunIndex = string.indexOf((char) 5)) >= 0) {
			string = string.substring(0, sunIndex) + to
					+ string.substring(sunIndex + 1);
		}
		return string;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-11</li>
	 * <li>设计时间：上午11:47:36</li>
	 * <li>设计目的：判断给定字符串的长度</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param string
	 * @return
	 */
	public static int size (
	                         String string )
	{
		if ( string == null )
		{
			return 0 ;
		}
		int length =
		             string
		                   .length ( ) ;
		int size =
		           length ;
		try
		{
			size =
			       string
			             .getBytes ( "UTF-8" ).length ;
		}
		catch ( UnsupportedEncodingException unSupportedEncodingException )
		{
//			throw new LibraRuntimeException (  string ,  unSupportedEncodingException ) ;
			throw new RuntimeException(  string ,  unSupportedEncodingException ) ;
		}
		return size ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午05:11:05</li>
	 * <li>设计目的：将字节参数转换为十六进制字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param b
	 * @return
	 */
	public static String toHex (
	                             byte b )
	{
		char hexDigit[] =
		                  {
		                          '0' ,
		                          '1' ,
		                          '2' ,
		                          '3' ,
		                          '4' ,
		                          '5' ,
		                          '6' ,
		                          '7' ,
		                          '8' ,
		                          '9' ,
		                          'a' ,
		                          'b' ,
		                          'c' ,
		                          'd' ,
		                          'e' ,
		                          'f'
		                  } ;
		char [ ] array =
		                 {
		                         hexDigit [ ( b >> 4 ) & 0x0f ] ,
		                         hexDigit [ b & 0x0f ]
		                 } ;
		return new String (
		                    array ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-9</li>
	 * <li>设计时间：下午05:11:49</li>
	 * <li>设计目的：将字符参数转换为十六进制字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param character
	 * @return
	 */
	static public String toHex (
	                             char character )
	{
		byte hi =
		          ( byte ) ( character >>> 8 ) ;
		byte lo =
		          ( byte ) ( character & 0xff ) ;
		return StringUtil
		                 .toHex ( hi )
		       + StringUtil
		                   .toHex ( lo ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午01:59:48</li>
	 * <li>设计目的：将数字转换为16进制字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param number
	 * @return
	 */
	public static String toHexString (
	                                   Number number )
	{
		if ( number == null )
		{
			return "null" ;
		}

		byte [ ] bytes =
		                 new byte [ 8 ] ;
		ByteBuffer bytesBuffer =
		                         ByteBuffer
		                                   .wrap ( bytes ) ;
		LongBuffer longBuffer =
		                        bytesBuffer
		                                   .asLongBuffer ( ) ;
		longBuffer
		          .put (
		                 0 ,
		                 number
		                       .longValue ( ) ) ;

		StringBuilder stringBuilder =
		                              new StringBuilder (
		                                                  16 ) ;
		for ( int index =
		                  0 ; index < bytes.length ; index ++ )
		{
			int b =
			        bytes [ index ] & 0xFF ;
			if ( ( b != 0 )
			     || ( stringBuilder
			                       .length ( ) > 0 )
			     || ( index == ( bytes.length - 1 ) ) )
			{
				stringBuilder
				             .append (
				                       StringUtil.HEX_CHARS
				                                           .charAt ( b >> 4 ) )
				             .append (
				                       StringUtil.HEX_CHARS
				                                           .charAt ( b & 0x0F ) ) ;
			}
		}
		return stringBuilder
		                    .toString ( ) ;
	}
	
	
	public static String toString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String string : list) {
			sb.append(string).append(',');
		}
		return sb.substring(0, sb.length()-1);
	}
	

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:01:08</li>
	 * <li>设计目的：将对象转换为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @return
	 */
	public static String toString (
	                                Object object )
	{
		return StringUtil
		                 .toString (
		                             object ,
		                             - 1 ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-4</li>
	 * <li>设计时间：下午02:01:57</li>
	 * <li>设计目的：将对象转换为字符串</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 * @param maxItems
	 * @return
	 */
	public static String toString (
	                                Object object ,
	                                int maxItems )
	{
		if ( object == null )
		{
			return "null" ;
		}

		if ( object instanceof String )
		{
			return ( "\""
			         + object + "\"" ) ;
		}

		if ( ( object instanceof Character )
		     || ( object
		                .getClass ( ) == Character.TYPE ) )
		{
			return ( "'"
			         + object + "'" ) ;
		}

		if ( object instanceof Number )
		{
			if ( ( object instanceof Byte )
			     || ( object instanceof Short )
			     || ( object instanceof Integer )
			     || ( object instanceof Long ) )
			{
				return object
				       + " <0x"
				       + StringUtil
				                   .toHexString ( ( Number ) object )
				       + ">" ;
			}
			return String
			             .valueOf ( object ) ;
		}

		if ( object
		           .getClass ( )
		           .isArray ( ) )
		{
			Class < ? > type =
			                   object
			                         .getClass ( )
			                         .getComponentType ( ) ;

			if ( maxItems < 0 )
			{
				if ( type
				         .isPrimitive ( ) )
				{
					if ( type == Byte.TYPE )
					{
						return Arrays
						             .toString ( ( byte [ ] ) object ) ;
					}
					if ( type == Character.TYPE )
					{
						return Arrays
						             .toString ( ( char [ ] ) object ) ;
					}
					if ( type == Integer.TYPE )
					{
						return Arrays
						             .toString ( ( int [ ] ) object ) ;
					}
					if ( type == Double.TYPE )
					{
						return Arrays
						             .toString ( ( double [ ] ) object ) ;
					}
					if ( type == Long.TYPE )
					{
						return Arrays
						             .toString ( ( long [ ] ) object ) ;
					}
					if ( type == Float.TYPE )
					{
						return Arrays
						             .toString ( ( float [ ] ) object ) ;
					}
					if ( type == Short.TYPE )
					{
						return Arrays
						             .toString ( ( short [ ] ) object ) ;
					}
					if ( type == Boolean.TYPE )
					{
						return Arrays
						             .toString ( ( boolean [ ] ) object ) ;
					}
					// 永远不会发生
					return "[未知原始类型数组："
					       + type
					       + "]" ;
				}
				return Arrays
				             .toString ( ( Object [ ] ) object ) ;
			}

			final int max =
			                Math
			                    .min (
			                           maxItems ,
			                           Array
			                                .getLength ( object ) ) ;
			List < Object > list =
			                       new ArrayList < Object > (
			                                                  max ) ;

			for ( int index =
			                  0 ; index < max ; index ++ )
			{
				list
				    .add ( Array
				                .get (
				                       object ,
				                       index ) ) ;
			}
			if ( max < Array
			                .getLength ( object ) )
			{
				list
				    .add ( "(first "
				           + max
				           + '/'
				           + Array
				                  .getLength ( object )
				           + " elements only...)" ) ;
			}

			object =
			         list ;
		}
		else if ( ( object instanceof Collection )
		          && ( maxItems >= 0 ) )
		{

			Collection < ? > collection =
			                              ( Collection < ? > ) object ;
			final int max =
			                Math
			                    .min (
			                           maxItems ,
			                           collection
			                                     .size ( ) ) ;
			List < Object > list =
			                       new ArrayList < Object > (
			                                                  max ) ;

			int index =
			            0 ;
			for ( Object item : collection )
			{
				if ( index >= max )
				{
					list
					    .add ( "(first "
					           + max
					           + '/'
					           + collection
					                       .size ( )
					           + " elements only...)" ) ;
					break ;
				}
				list
				    .add ( item ) ;
				index ++ ;
			}

			object =
			         list ;
		}
		else if ( ( object instanceof Map )
		          && ( maxItems >= 0 ) )
		{
			Map < ? , ? > map =
			                    ( Map < ? , ? > ) object ;
			final int max =
			                Math
			                    .min (
			                           maxItems ,
			                           map
			                              .size ( ) ) ;
			Map < Object , Object > copy =
			                               new HashMap < Object , Object > (
			                                                                 max ) ;

			int index =
			            0 ;
			for ( Map.Entry < ? , ? > item : map
			                                    .entrySet ( ) )
			{
				if ( index >= max )
				{
					copy
					    .put (
					           "(first "
					                   + max
					                   + '/'
					                   + map
					                        .size ( )
					                   + " elements only...)" ,
					           "..." ) ;
					break ;
				}
				copy
				    .put (
				           item
				               .getKey ( ) ,
				           item
				               .getValue ( ) ) ;
				index ++ ;
			}

			object =
			         copy ;
		}

		return String
		             .valueOf ( object ) ;
	}
	
	public static StringBuffer toStringBuffer(String string){
		return new StringBuffer(string);
	}
	
	
	public static StringBuilder toStringBuilder(String string){
		return new StringBuilder(string);
	}
	

	/**
	 * 构造函数
	 */
	private StringUtil ( )
	{
		super ( ) ;
	}
}

package org.hy.commons.lang.character;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2013-8-2；时间：上午10:54:17</li>
 * <li>类型名称：CharacterUtil</li>
 * <li>设计目的：由于网络传输中，默认使用的是编码是【ISO8859-1】，而，当传输【中文，或者空格】等【ISO8859-1】字符集不支持的字符的时候,<br/>
 * 就需要把这些不支持的字符，转换成【ISO8859-1】支持的字符<br/>
 * 例如：把字符【中文】转换成【ISO8859-1】支持的字符<br>
 * 【中文】对应的【UTF8】字符集的byte字符数组是【-28, -72, -83, -26, -106, -121】，<br/>
 * 再经过特殊的编码后，<b><将该字符集对应的byte字符数组>，<转换成对应的字符串></b>，即【%E4%B8%AD%E6%96%87】
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
public class CharacterUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CharacterUtil.class);
	
	public static void main(String[] args) {
		System.err.println(getAsciiValue(' '));
	}
	
	/**
	 * 判断文件的编码格式 UTF-8 GBK
	 * @param fileName :file
	 * @return 文件编码格式
	 * @throws Exception
	 */
	public static String getFileCharset(String fileName) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(
		new FileInputStream(fileName));
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		
		switch (p) {
			case 0xefbb:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "GBK";
		}
		
		logger.debug("文件【{}】的编码是【{}】",fileName,code);
		return code;
	}
	
	/*
	 * Decodes a application/x-www-form-urlencoded string using a specific encoding scheme.
	 * The supplied encoding is used to determine what characters are represented 
	 * by any consecutive sequences of the form "%xy". 
	 */
	public static String decode(String s,String charsetName) {
		
		try {
			return URLDecoder.decode(s, charsetName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new RuntimeException("7777777777777");

	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：把字符串，编码成ISO8859-1支持的字符串<br/>
	 * Translates a string into application/x-www-form-urlencoded format using a specific encoding scheme.
	 * This method uses the supplied encoding scheme to obtain the bytes for unsafe characters. 
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-17；时间：下午5:30:59</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param s
	 * @param charsetName
	 * @return
	 */
	public static String encode(String s,String charsetName) {
		
		try {
			return URLEncoder.encode(s, charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("7777777777777");
	}
	
	public static String encode(String s) {
		
		return encode(s,"utf-8");
	}
	
	public static Integer getAsciiValue(Character data) {
		
		return Integer.valueOf(data);
		//return Character.tNumericValue(data);
	}

	
	public static Boolean isChinese(Character c) {
		
		return CharacterCheckUtil.isChinese(c);
	}
	
	public static Boolean isMessyCode(String c) {
		
		return CharacterCheckUtil.isMessyCode(c);
	}
	
}

package org.hy.commons.lang.character;

import java.nio.charset.Charset;

//@Deprecated
public class CharsetUtil {

	
	
	public static Charset getCharset(String charsetName) {
		return Charset.forName(charsetName);
	}
	public static void main(String[] args) {
		/*
		 */////u4e00---/u9f5a
		 
		char d ='\u9636';
		System.err.println(d);
		System.out.println(Charset.defaultCharset());
		System.out.println(CharsetUtil.getCharset("gbk"));
		System.out.println(CharsetUtil.getCharset("GBK"));
	}
}

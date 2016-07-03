package org.hy.commons.lang.string;

import org.junit.Test;

/*
 http://lin-yp.iteye.com/blog/1683679
 http://www.cnblogs.com/zdwillie/archive/2013/10/23/3384766.html
 */
public class String_OutOfMemoryTest {

	//@Test
	public void testString() throws Exception {
		String string =new String("abcdef");
		string.substring(0, string.length()-1);
		final char[] src = {'a','b','c'};
		final char[] des = src;
		System.out.println(src.hashCode());
		System.out.println(des.hashCode());
	}
	
	/*
	 * String string2 = "abc";创建的字符串，存储在常量池
	 * String string =new String("abc");创建的字符串，存储在堆内存
	 * string2==string 返回false;因为内存地址不一样
	 * string.intern()==string 返回false; 
	 * 因为string.intern()是把一份字符串，存储在常量池
	 */
	@Test
	public void testStringIntern() throws Exception {
		String string =new String("abc");
		String string2 = "abc";
		String string3 = "abc";
		System.out.println(string2.hashCode());
		System.out.println(string.hashCode());
		System.out.println(string2==string3+string2.hashCode());
		System.out.println("=========================");
		System.out.println(string2==string );
		System.out.println(string2==string.intern());
		System.out.println(string2==string );
		System.out.println(string.intern()==string );
		
	}
	
	
	//@Test
	public void testSubString() throws Exception {
		for (int i = 0; i < 10000; i++) {
			//HugeStr h = new HugeStr();
			ImprovedHugeStr h = new ImprovedHugeStr();
			h.getSubString(0, 5);
		}
	}
	
}

 class HugeStr{

	 private String string = new String(new char[100000]);
	 
	 public String getSubString(int beginIndex,int endIndex) {
		return string.substring(beginIndex, endIndex);
	}
}
 class ImprovedHugeStr{
	 
	 private String string = new String(new char[100000]);
	 
	 public String getSubString(int beginIndex,int endIndex) {
		 return new String(string.substring(beginIndex, endIndex));
	 }
 }


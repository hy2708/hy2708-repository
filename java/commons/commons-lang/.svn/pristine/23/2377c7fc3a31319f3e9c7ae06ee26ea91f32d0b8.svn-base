package org.hy.commons.lang.character.example;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String msg = "中国";
		System.out.println(msg.getBytes("utf-8").length);
		//打印出:6
		System.out.println(
			    java.util.Arrays.toString(msg.getBytes("utf-8"))
			);
			// 输出可以看到 byte 数组的内容：[-28, -72, -83, -27, -101, -67, -28, -70, -70]
		System.out.println(URLEncoder.encode(msg,"utf-8"));
		//打印出:%E4%B8%AD%E5%9B%BD
		String xyz="中";
		String xyg="国";
		System.out.println(Integer.toHexString(-28));
		System.out.println(Integer.toHexString(0xff & xyz.getBytes("utf-8")[0]));
		System.out.println(Integer.toHexString(0xff & xyz.getBytes("utf-8")[1]));
		System.out.println(Integer.toHexString(0xff & xyz.getBytes("utf-8")[2]));
		System.out.println(Integer.toHexString(0xff & xyg.getBytes("utf-8")[0]));
		System.out.println(Integer.toHexString(0xff & xyg.getBytes("utf-8")[1]));
		System.out.println(Integer.toHexString(0xff & xyg.getBytes("utf-8")[2]));
		//打印出:b8
		//ad
		//e5
		//9b
		//bd
		//是否证明两者是相同的，答案是否定的 
		//因为URLEncode还会做一些特殊处理
		String xys = " ";//它的asci码，是20
		System.out.println(URLEncoder.encode(xys ,"utf-8"));
		//打印出：+
		System.out.println(Integer.toHexString(0xff & xys.getBytes("utf-8")[0]));
	}

}

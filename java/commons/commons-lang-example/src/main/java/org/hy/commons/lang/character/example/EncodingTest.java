package org.hy.commons.lang.character.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * URLEncoder.encode("中国人", "UTF-8")
 * 是在对，字符串，进行charset的字节编码基础上，再进行加密（用%xx的形式）
 */
/*
 * <meta http-equiv="Content-Type" content="text/html; charset=GBK">
 * 
 * <meta http-equiv="Content-Type" content="text/html; charset=utf8">
 * 
 * 
 * 字符编码，可以在Html的，如上位置中，设置
 */
public class EncodingTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	static String data = "中文";
	
	
	public  void printEncoding() throws Exception {
		String encode = URLEncoder.encode(data, "utf8");
		String encode2 = URLEncoder.encode(data, "gbk");
		String encode3 = URLEncoder.encode(data, "iso8859-1");
		//%E4%B8%AD%E6%96%87
		logger.info("对【中文】，进行进行【utf8】的编码后，得到是编码是【" +
				encode+"】");
		URLDecoder.decode(encode, "UTF8");
		//涓枃
		logger.info("对【中文】，进行进行【utf8】的编码后，再用【gbk】进行【解码】，得到是字符是【" +
				URLDecoder.decode(encode, "GBK")+"】");
		
		//%D6%D0%CE%C4
		logger.info("对【中文】，进行进行【gbk】的编码后，得到是编码是【" +
				encode2+"】");
		logger.info("对【中文】，进行进行【gbk】的编码后，再用【gbk】进行【解码】，得到是字符是【" +
				URLDecoder.decode(encode2, "GBK")+"】");
		logger.info("============================================");
		//%3F%3F
		logger.info("对【中文】，进行进行【iso8859-1】的编码后，得到是编码是【" +
				encode3+"】");
		logger.info("对【中文】，进行进行【iso8859-1】的编码后，再用【iso8859-1】进行【解码】，得到是字符是【" +
				URLDecoder.decode(encode3, "iso8859-1")+"】");
		logger.info("============================================");
		//System.out.println(Integer.toHexString(0xff & xyz.getBytes("utf-8")[0]));


		logger.info("对【中文】，进行进行【.getBytes('utf8')】的编码后，得到是byte数组是【"+Arrays.toString(data.getBytes("utf8"))+"】");
		logger.info("再对byte数组【"+Arrays.toString(data.getBytes("utf8"))+"】，执行【" +
				"new String(data.getBytes('utf8'), 'utf8')"+"】方法，得到的字符串是【"+new String(data.getBytes("utf8"), "utf8")+"】");
		String encodeaa = new String(data.getBytes("utf8"), "iso8859-1");
		logger.info("再对byte数组【"+Arrays.toString(data.getBytes("utf8"))+"】，执行【" +
				"new String(data.getBytes('utf8'), 'iso8859-1')"+"】方法，得到的字符串是【"+encodeaa+"】");
		logger.info("再," +
				"new String(data.getBytes('iso8859-1'), 'utf8')"+"】方法，得到的字符串是【"+ new String(data.getBytes("iso8859-1"), "utf8")+"】");
		
		logger.info("对【中文】，进行进行【.getBytes('gbk')】的编码后，得到是byte数组是【"+Arrays.toString(data.getBytes("gbk"))+"】");
		logger.info("再对byte数组【"+Arrays.toString(data.getBytes("gbk"))+"】，执行【" +
				"new String(data.getBytes('gbk'), 'gbk')"+"】方法，得到的字符串是【"+new String(data.getBytes("gbk"), "gbk")+"】");

		
		logger.info("============================================");
		logger.info("对【中文】，进行进行【.getBytes('iso8859-1')】的编码后，得到是byte数组是【"+Arrays.toString(data.getBytes("iso8859-1"))+"】");
		logger.info("再对byte数组【"+Arrays.toString(data.getBytes("iso8859-1"))+"】，执行【" +
				"new String(data.getBytes('iso8859-1'), 'iso8859-1')"+"】方法，得到的字符串是【"+new String(data.getBytes("iso8859-1"), "iso8859-1")+"】");
		logger.info("============================================");
		String string = new String(data.getBytes("utf8"),0,1, "iso8859-1");
		System.err.println(string);
	}
	
	public static void main(String[] args) throws Exception {
		
		

		
		
		new EncodingTest().printEncoding();
		
		
		
	}
	
	public void printEncodingByte() throws UnsupportedEncodingException {
		byte[] bytes = "中文".getBytes("UTF-8");  // 按UTF-8把 "中国人" 字编码.
		System.out.println(
		    java.util.Arrays.toString(bytes)
		);
		// 输出可以看到 byte 数组的内容：[-28, -72, -83, -27, -101, -67, -28, -70, -70]
		 
		// 把每个字节的都转成 %xx 的形式
		for (int i=0; i<bytes.length; i++) {
		    System.out.print(
		        "%" +
		        Integer.toString((bytes[i]>>>4)&0x0f, 16) +
		        Integer.toString(bytes[i]&0x0f, 16)
		    );
		}
		 
		System.out.println();
		// 用 URLEncoder.encode 编一次
		System.out.println(
		    java.net.URLEncoder.encode("中国人", "UTF-8").toLowerCase()
		);
	}

}

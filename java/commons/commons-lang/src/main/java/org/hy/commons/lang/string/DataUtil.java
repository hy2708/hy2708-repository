package org.hy.commons.lang.string;

import java.security.MessageDigest;

/**
 * 数据工具类
 */
public class DataUtil {
	
	/**
	 * 采用md5加密
	 */
	public static String md5(String src){
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] data = md.digest(src.getBytes());
			for(byte b : data){
				//高4位
				buffer.append(chars[(b >> 4) & 0x0F]);
				//低4位
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
}

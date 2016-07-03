package org.hy.commons.io.core;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtil extends jodd.util.PropertiesUtil{

	private PropertiesUtil() {
	}
	
	public static Properties getPropertiesFile(String filePath) {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			InputStream in = new BufferedInputStream(fileInputStream);
			props.load(in);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：读取properties文件的全部信息<br>
	 * 
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-21；时间：下午1:28:15</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param filePath 文件名，需要以,properties结尾
	 * @return
	 */
	public static Map<String, String> readProperties(String filePath) {
		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			InputStream in = new BufferedInputStream(fileInputStream);
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				// System.out.println(key + Property);
				map.put(key, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：读取properties文件的全部信息<br>
	 * 
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-21；时间：下午1:28:15</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param filePath 文件名，需要以,properties结尾
	 * @return
	 */
	public static String readProperty(String filePath, String key) {
		String tempPath = null;
		if (filePath.endsWith(".properties")) {
			tempPath = filePath.substring(0, filePath.indexOf(".properties"));
			//tempPath = filePath;
		}else {
			tempPath = filePath;
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(tempPath);
		return resourceBundle.getString(key);
		//Map<String, String> map = PropertiesUtil.readProperties(filePath);
		//return map.get(key);

	}
}

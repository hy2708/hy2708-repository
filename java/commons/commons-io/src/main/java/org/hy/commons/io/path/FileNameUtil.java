package org.hy.commons.io.path;

import java.io.IOException;

import org.hy.commons.lang.UUIDUtil;
import org.hy.commons.lang.character.CharacterUtil;

public class FileNameUtil extends jodd.io.FileNameUtil{
	
    /**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：用空格" "，代替文件路径filePath中的"%20"</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-6-17；时间：下午11:13:45</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @return
	 */
	public static String filterFilePath(String filePath) {
		return CharacterUtil.decode(filePath, "utf8");
		
		/*try {
			return URLDecoder.decode(filePath, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		*/
//		return filePath.replace("%20", " ");
	}
	
	/**
	 *  @see FileNameUtil#getExtension(String) 
	 */
	public static String getExtName(String filename) {
		return getExtension(filename);
	}
	public static String getName(String filename) {
		return jodd.io.FileNameUtil.getName(filename);
	}
	public static String getBaseName(String filename) {
		return jodd.io.FileNameUtil.getBaseName(filename);
	}

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回【/】或者【\】或者【】</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-9-12；时间：上午10:38:15</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param filename
	 * @return
	 * @return
	 */
	public static String getPrefix(String filename)
	{
		 return jodd.io.FileNameUtil.getPrefix(filename);
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：<br/>
	 * eg: d:\aaa\bbb\ccc.txt----d:\aaa\bbb\asdfasdfdfafasdfasfdsf.txt<br/>
	 * eg: ccc.txt----asdfasdfdfafasdfasfdsf.txt<br/>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-10-7；时间：下午8:57:58</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param originalFileName
	 * @return
	 */
	public static String getRandomFileName(String originalFileName) {
//		String dir =getFullPathNoEndSeparator(originalFileName);
		String dir =getFullPath(originalFileName);
		//getBaseName(originalFileName);
		String newName =dir+ UUIDUtil.randomUUID()+getExtName(originalFileName);
		return newName;
	}
	
	/** 
	 * 	@see FileNameUtil#getFileDirNoEndSeparator(String)
	 */
	public static String getFileDirNoEndSeparator(String filename){
		return getFullPathNoEndSeparator(filename);
	}
	
	
    public static String separatorsToWeb(String path){
    	return separatorsToUnix(path);
    }
    
    
    public static String removePrefix(String filename)
    {
    	String preString = getPrefix(filename);
    	return filename.substring(preString.length());
    }
    
    


}

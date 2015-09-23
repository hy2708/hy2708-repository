package org.hy.commons.io.find;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

import jodd.io.findfile.FindFile;
import jodd.io.findfile.WildcardFindFile;

import org.hy.commons.io.path.FileNameUtil;
import org.hy.commons.lang.string.StringUtil;
import org.hy.commons.lang.string.WildcardUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-9-15；时间：下午10:09:21</li>
 * <li>类型名称：FindFileUtil</li>
 * <li>设计目的：查找文件的辅助工具类</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class FindFileUtil {

	private static Logger logger = LoggerFactory.getLogger(FindFileUtil.class);
	
	public static List<File> findFiles(String searchPath,String fileName) {
		return findFiles(searchPath,true, null, fileName);
	}
	public static List<File> findFiles(String searchPath,Boolean findSubDir,String fileName) {
		return findFiles(searchPath,findSubDir, null, fileName);
	}
	
	public static List<File> findFiles(String searchPath,Boolean findSubDir,String keyPath,String fileName) {
		return findFilesByWildCard(searchPath,findSubDir, keyPath, fileName);
	}

	/**
	 *  @see #findFilesByWildCard(String, Boolean, String, String, Boolean)
	 */
	public static List<File> findFilesByWildCard(String searchPath,Boolean findSubDir,String matchPath) {
		return findFilesByWildCard(searchPath,findSubDir, matchPath, null);
	}
	
	/**
	 *  @see #findFilesByWildCard(String, Boolean, String, String, Boolean)
	 */
	public static List<File> findFilesByWildCard(String searchPath,Boolean findSubDir,String matchPath,String fileName) {
		return findFilesByWildCard(searchPath,true,findSubDir,true, matchPath, fileName, true);
	}

	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：在searchPath目录下，查找符合结构matchPath的名称为fileName的文件</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-9-16；时间：下午3:49:56</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param searchPath 表示需要检索的根路径
	 * @param recursive  是否搜索子目录
	 * @param findSubDir  是否把目录，列为搜索对象。如果是false，则搜索结果中，不包含文件夹
	 * @param includeFile  是否文件，列为搜索对象。如果是false，则搜索结果中，不包含文件
	 * @param matchPath  在跟路径下，需要符合的路径匹配结构
	 * @param fileName  需要查找的文件名
	 * @param isRest  是否重置
	 * @return
	 */
	public static List<File> findFilesByWildCard(String searchPath,Boolean recursive,Boolean findSubDir,Boolean includeFile, String matchPath,String fileName,Boolean isRest) {
		FindFile<?> ff = new WildcardFindFile()
		.setIncludeDirs(findSubDir)//是否把目录，列为搜索对象
		.setIncludeFiles(includeFile)
		.setRecursive(recursive)//是否搜索子文件夹
		//.include("**/*file/a*")
		//.include(matchPath)
		//.searchPath(searchPath)
		;
		if (StringUtil.isNotEmpty(matchPath)) {
			ff.include(matchPath);
		}
		ff.searchPath(searchPath);
		
		List<File> list = new  LinkedList<File>();
		File f;
		
		//iterates through all files in the given dir.
		int dirSum=0;
		int fileSum=0;
		while ((f = ff.nextFile()) != null) {
			
			//is Dir 
			if (f.isDirectory() == true) {
				++dirSum;
				list.add(f);
			}
			//is File
			else {
				++fileSum;
				//fileName is empty 
				if (fileName==null||fileName.trim().equals("")) {
					list.add(f);

				}
				//fileName is not empty
				else {
					String path = f.getAbsolutePath();
					path = FileNameUtil.separatorsToUnix(path);
					
					String fullName =FileNameUtil.getName(path);
					StringBuilder builder = new StringBuilder();
					if (WildcardUtil.hasWildcard(fileName)) {					
						if (WildcardUtil.match(fullName, fileName)) {
							list.add(f);
						}
					}else {
						//TODO 需要修改，不正确
						if (StringUtil.containsIgnoreCase(fullName, fileName)) {
							list.add(f);
						}
						
					}
				}
				
			}
		}
		
		//logger.debug("遍历到的目录数量是【{}】",dirSum);
		//logger.debug("遍历到的目录数量是【{}】",fileSum);
		

		if (isRest) {
			ff.reset();
		}
		
		return list;

	}
	


}

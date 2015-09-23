package org.hy.commons.io.maven.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;


/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-9-15；时间：下午10:09:21</li>
 * <li>类型名称：MavenUtil</li>
 * <li>设计目的：</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class MavenUtil {
	
	public static void main(String[] args) {
		createProjectPackage();
	}

	public static void createProjectPackage() {
		String filePath = ProjectPathUtil.getProjectPath();
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"main"+File.separator+"java" );

		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"main"+File.separator+"resources" );
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"test"+File.separator+"resources" );
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"test"+File.separator+"java" );
	}

	public static void createProjectPackage(Class clazz) {
		String filePath = ProjectPathUtil.getProjectPath(clazz);
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"main"+File.separator+"java" );
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"main"+File.separator+"resources" );
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"test"+File.separator+"resources" );
		FileUtil.createFile(filePath+File.separator+"src"+File.separator+"test"+File.separator+"java" );
	}
	
	public static void copyResourcesFromSrcToTest(Class clazz) {
		createProjectPackage(clazz);
		String filePath = ProjectPathUtil.getProjectPath(clazz);
		File srcFile = new File(filePath+File.separator+"src"+File.separator+"main"+File.separator+"resources" );
		File destFile = new File(filePath+File.separator+"src"+File.separator+"test"+File.separator+"resources" );
		try {
			FileUtil.copyDir(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static File getResourcesPath(Class clazz) {
		String filePath = ProjectPathUtil.getProjectPath(clazz);
		File srcFile = new File(filePath+File.separator+"src"+File.separator+"main"+File.separator+"resources" );
		//File destFile = new File(filePath+File.separator+"src"+File.separator+"test"+File.separator+"resources" );
		FileUtil.existsFile(srcFile);
		return srcFile;
		
	}
	
	public static File getTestResourcesPath(Class clazz) {
		String filePath = ProjectPathUtil.getProjectPath(clazz);
		//File srcFile = new File(filePath+File.separator+"src"+File.separator+"main"+File.separator+"resources" );
		File destFile = new File(filePath+File.separator+"src"+File.separator+"test"+File.separator+"resources" );
		FileUtil.existsFile(destFile);
		return destFile;
		
	}
}

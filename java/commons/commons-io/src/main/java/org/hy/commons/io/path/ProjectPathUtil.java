package org.hy.commons.io.path;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.lang.character.CharacterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectPathUtil {

	private static Logger logger = LoggerFactory
			.getLogger(ProjectPathUtil.class);

	public static final String dirSeparator = File.separator;
	private static final String fileSeparator = File.separator;
	public static void main(String[] args) throws Exception {
		System.err.println(getProjectClassPath());
		// System.err.println(getProjectPath());
		// System.err.println(getProjectPath(MyLoggerUtil.class,
		// "commons-log-slf4j-logback"));
		
		String projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("").toURI().getPath();
		String path = projectClassPath.substring(1,projectClassPath.length()-1);
		logger.debug("项目【" +  "】的classes路径是【" + path + "】");

	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-21；时间：下午3:55:57</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @return
	 * @return
	 */
	@Deprecated
	public static String getClassFileDir(Class clazz) {
		File currentFile = new File(clazz.getResource("").getFile());
		File filteredFile = null;
		try {
			filteredFile = FileUtil.filterFilePath(currentFile);
		} catch (IOException e) {
			//
			e.printStackTrace();
		}

		logger.debug("【" + clazz.getSimpleName() + "】" + "所在的文件目录路径是："
				+ filteredFile.toString());
		
		return filteredFile.toString();
	}
	
	public static String getClassFileDirInProject(Class clazz) {
		
		
		String classFilePath = getClassFilePathInProject(clazz);
		int lastIndex = 0;
		if (classFilePath.indexOf("/")!=-1) {			
			lastIndex = classFilePath.lastIndexOf('/');
		}else if (classFilePath.indexOf("\\")!=-1) {			
			lastIndex = classFilePath.lastIndexOf("\\");
		}else {			
			throw new RuntimeException("9999999999");
		}
		
		return classFilePath.substring(0, lastIndex);
	}

	@Deprecated
	public static String getClassFilePath(Class clazz) {
		// logger.debug("【" +
		// clazz.getSimpleName()+"】"+"所在的文件路径是："+filteredFile.toString());
		return getJavaFileDir(clazz) + File.separator + clazz.getSimpleName()
				+ ".class";
	}
	

	
	public static String getClassFilePathInProject(Class clazz) {
		// logger.debug("【" +
		// clazz.getSimpleName()+"】"+"所在的文件路径是："+filteredFile.toString());
		StringBuilder sb = new StringBuilder();
		String name = clazz.getName();
		String classesDir = getProjectClassesDirPath();
		if (classesDir.indexOf("/")!=-1) {			
			sb.append("/").append(name.replace('.', '/'));
		}else if (classesDir.indexOf("\\")!=-1) {			
			sb.append("\\").append(name.replace('.', '\\'));
		}else {			
			throw new RuntimeException("9999999999");
		}
		
		return classesDir+sb.toString()		+ ".class";
	}
	
	public static String getJavaClassPackageName(Class clazz) {
		// logger.debug("【" +
		// clazz.getSimpleName()+"】"+"所在的文件路径是："+filteredFile.toString());
		String name = clazz.getName();
		if (name.contains(".")) {
			return name.substring(0, name.lastIndexOf("."));
		}else {
			return null;
		}
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：在项目中,类对应的Java文件，所在的文件目录</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-21；时间：下午3:50:40</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @return
	 * @return
	 */
	public static String getJavaFileDir(Class clazz) {
		String srcPath = getProjectJavaDirPath(clazz);
		StringBuilder sb =new StringBuilder(clazz.getName().substring(0, clazz.getName().lastIndexOf('.')));
		String relativePackagePath =sb.toString().replace( ".", dirSeparator);
		

		logger.debug("【" + clazz.getSimpleName() + "】" + "所在的文件目录路径是："
				+ srcPath+dirSeparator+relativePackagePath);
		return srcPath+dirSeparator+relativePackagePath;
	}

	public static String getJavaFilePath(Class clazz) {
		// logger.debug("【" +
		// clazz.getSimpleName()+"】"+"所在的文件路径是："+filteredFile.toString());
		return getJavaFileDir(clazz) + dirSeparator + clazz.getSimpleName()
				+ ".class";
	}

	
	
	public static String getJarFileDir(Class clazz) {
		/*
		 * String filePath = getJarFileLocation(clazz);
		 * System.out.println("66666"+filePath); String fileDirPath = null; if
		 * (filePath.endsWith(".jar")){ fileDirPath = filePath.substring(0,
		 * filePath.lastIndexOf("/") + 1); return fileDirPath; }
		 * 
		 * return filePath;
		 */

		java.net.URL url = clazz.getProtectionDomain().getCodeSource()
				.getLocation();
		String filePath = null;
		try {
			filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("8888"+filePath);
		if (filePath.endsWith(".jar")) {

			filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}
		java.io.File file = new java.io.File(filePath);
		filePath = file.getAbsolutePath();
		// System.out.println("9999"+filePath);
		String returnString = null;
		if (filePath.endsWith(".")) {
			returnString = filePath.substring(0, filePath.lastIndexOf("."));
			return returnString;
		}
		return filePath;
	}
	
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：项目被打包成jar后，获取jar所在的当前路径<b> 返回的路径，以jar为结尾</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-3-16；时间：下午3:08:48</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 * @return
	 * @return
	 */
	public static String getJarFileLocation(Class clazz) {
		String location = null;
		try {
			location = URLDecoder.decode(clazz.getProtectionDomain()
					.getCodeSource().getLocation().getFile(), "UTF-8");
			System.out.println("7777777777" + location);

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return location;
	}

	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回项目的classPath路径，使用/作为分隔符，并以/结尾<br/>
	 * <b>返回的路径是，是以"/classes"或者"\classes"为结尾的；<br/>
	 * 当出现以test-classes/"为结尾的时候，也会替换成以"classes/"为结尾的路径</b></li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-15；时间：下午1:49:01</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @return
	 * @return
	 */
	public static String getProjectClassPath() {
//		String projectClassPath = IoUtil.filterFilePath(
//				ProjectPathUtil.class.getClassLoader().getResource("")
//				// .getResource("/")
//				// .getResource(File.separator)
//						.getPath()).substring(1);
//		// StringBuffer stringBuffer = new StringBuffer(projectClassPath);
//		// stringBuffer.deleteCharAt(projectClassPath.length()-1);
//		String path = null;
//		if (projectClassPath.endsWith("test-classes/")) {
//			path = projectClassPath.replaceFirst("test-classes/", "classes/");
//		} else if (projectClassPath.endsWith("test-classes\\")) {
//			path = projectClassPath.replaceFirst("test-classes\\", "classes\\");
//
//		} else {
//			path = projectClassPath;
//		}
//		logger.debug("项目【" + getProjectName() + "】的classes路径是【" + path + "】");
//		return path;
		return getProjectClassesDirPath();

	}
	
	public static String getProjectClassesDirPath() {

		String path = getProjectPath();
		if (path.indexOf("/")!=-1) {			
			path =  path+"/target/classes";
		}else if (path.indexOf("\\")!=-1) {			
			path =  path+"\\target\\classes";
		}else {			
			throw new RuntimeException("9999999999");
		}
		logger.debug("项目【" + getProjectName() + "】的java文件编译后，的classes文件夹，所在路径是【" +path + "】");
		if (FileUtil.existsFile(path)) {			
			return path;
		}
		throw new RuntimeException("9999999999");

	}
	
	public static String getProjectClassPath(Class clazz) throws URISyntaxException {
		String projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("").toURI().getPath();
		String path = projectClassPath.substring(1,projectClassPath.length()-1);
		logger.debug("项目【" + getProjectName() + "】的classes路径是【" + path + "】");
		return path;
		

	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回项目的classPath路径，使用File.separator作为分隔符，并以separator结尾;<br>
	 * 在Windows环境下，File.separato = \</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-21；时间：下午6:34:34</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param clazz
	 *            必须是项目projectName中，src下的类
	 * @param projectName
	 * @return
	 * @return
	 */
	public static String getProjectClassPath(Class clazz, String projectName) {
		String classFile = IoUtil.findFile(getProjectPath(clazz, projectName),
				clazz.getSimpleName() + ".class").toString();
		return classFile.substring(0, classFile.indexOf("classes")) + "classes"
				+ File.separator;

	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获得当前项目的名称</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-2；时间：下午7:05:32</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	public static String getProjectName() {

		/*int projectNameIndex = System.getProperty("user.dir").lastIndexOf(
				File.separator);
		return System.getProperty("user.dir").substring(projectNameIndex + 1);
		 */
		String name = FileNameUtil.getName(System.getProperty("user.dir"));
		return name;
	}
	
	public static String getProjectName(Class<?> clazz) {

		File currentFile = new File(clazz.getResource("").getFile());
		String filePath = CharacterUtil.decode(currentFile.getPath(),"utf8");

		int endIndex = filePath.lastIndexOf(dirSeparator+"target");
		
		filePath = filePath.substring(0, endIndex );
		int index =  filePath.lastIndexOf(dirSeparator);
		filePath = filePath.substring(index+1);
		logger.debug("类【"  +clazz.getSimpleName() +"】所在的项目的名称是【" + filePath + "】");

		return filePath;
	}
	
	
	
	

	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：获得当前项目所在的路径<br/>
	 * 没有以分隔符,为结尾</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-5-25；时间：下午10:39:42</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @return
	 * @return
	 */
	public static String getProjectPath() {

		String path = System.getProperty("user.dir");
		logger.debug("项目【" + getProjectName() + "】的项目路径是【" + path + "】");
		return path;
	}
	

	/*
	 * 未充分测试
	 */
	public static String getProjectPath(Class<?> clazz) {

		File currentFile = new File(clazz.getResource("").getFile());
		String filePath = CharacterUtil.decode(currentFile.getPath(),"utf8");

		int endIndex = filePath.lastIndexOf(dirSeparator+"target");
		//System.err.println(filePath);
		filePath = filePath.substring(0, endIndex );
		logger.debug("项目【"  + "】的项目路径是【" + filePath + "】");

		return filePath;
	}
	
	/*
	 * 未充分测试
	 * 没有以分隔符,为结尾
	 */
	public static String getProjectPath(Class clazz, String projectName) {
		String classFilePath = getJavaFilePath(clazz);
		int offset = classFilePath.indexOf(projectName);
		String path = classFilePath.substring(0, offset + projectName.length());
		return path;
	}

	

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回Maven项目,目录/src/main/java的路径<br/>
	 * <b>注意：只适用于当前开发的系统的路径，并且必须是Maven的结构 </b>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-3；时间：下午11:17:27</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 */
	public static String getProjectJavaDirPath() {

		String path = getProjectPath();
		StringBuilder sb = new StringBuilder(path);
		sb.append(dirSeparator)
		.append("src")
		.append(dirSeparator)
		.append("main")
		.append(dirSeparator)
		.append("java");
		path = sb.toString();
		//path =  path+dirSeparator"/src/main/java";
		logger.debug("项目【" + getProjectName() + "】的java文件夹，所在路径是【" +path + "】");
		if (FileUtil.existsFile(path)) {			
			return path;
		}
		throw new RuntimeException("9999999999");
	}
	
	/*
	 * 未重复测试
	 */
	public static String getProjectJavaDirPath(Class clazz) {
//		File currentFile = new File(clazz.getResource("").getFile());
//		String filePath = CharacterUtil.decode(currentFile.getPath(),"utf8");
//		int endIndex = filePath.lastIndexOf(dirSeparator+"src"+dirSeparator+"main"+dirSeparator+"java")+"/src/main/java".length();
//		System.err.println(filePath);
//		filePath = filePath.substring(0, endIndex );
//		logger.debug("【" + clazz.getSimpleName() + "】" + "所在的文件目录路径是："
//				+ filePath);
		String path = getProjectPath(clazz);
		StringBuilder sb = new StringBuilder(path);
		sb.append(dirSeparator)
		.append("src")
		.append(dirSeparator)
		.append("main")
		.append(dirSeparator)
		.append("java");
		path = sb.toString();
		//path =  path+dirSeparator"/src/main/java";
		logger.debug("项目【" + getProjectName() + "】的java文件夹，所在路径是【" +path + "】");
		if (FileUtil.existsFile(path)) {			
			return path;
		}
		throw new RuntimeException("9999999999");
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-7-3；时间：下午11:17:27</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 * @throws Exception 
	 */
	public static String getProjectResourcesDirPath() {
		//返回Maven项目,目录/src/main/resources的路径
		String projectClassPath=null;
		try {
			projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("").toURI().getPath();
			projectClassPath = FileUtil.filterFilePath(projectClassPath);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path2 = FileNameUtil.removePrefix(projectClassPath);
		//System.err.println(path2);
		String path = FileNameUtil.normalizeNoEndSeparator(path2, true);
		//projectClassPath.substring(1,projectClassPath.length()-1);		
		
		logger.debug("项目【" + getProjectName() + "】的resources文件夹，所在路径是【" +path + "】");
		return path;
	
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-26；时间：上午11:38:50</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param resourceName
	 * @return
	 */
	public static String getProjectResourcePath(String resourceName) {
		//返回Maven项目,目录/src/main/resources的路径
		String projectClassPath=null;
		try {
			projectClassPath = ProjectPathUtil.class.getClassLoader().getResource(resourceName).toURI().getPath();
			projectClassPath = FileUtil.filterFilePath(projectClassPath);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path2 = FileNameUtil.removePrefix(projectClassPath);
		//System.err.println(path2);
		String path = FileNameUtil.normalizeNoEndSeparator(path2, true);
		//projectClassPath.substring(1,projectClassPath.length()-1);		
		
		logger.debug("项目【" + getProjectName() + "】的资源【{}】，所在路径是【" +path + "】",resourceName);
		return path;
	
	}
	
	public static URI getProjectResourcesURIPath() {
		URI projectClassPath=null;
		try {
			projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("").toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}//.getPath();
		return projectClassPath;
	}

	public static URL getProjectResourcesURLPath() {
		URL projectClassPath=null;
		projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("");//.toURI().getPath();
		return projectClassPath;
	}
	
	/*
	 * 未充分测试
	 */
	public static String getProjectResourcesDirPath(Class<?> clazz) {

		String path = getProjectPath(clazz);
		path =  path+
				dirSeparator+
				"src" +
				dirSeparator +
				"main" +
				dirSeparator +
				"resources";
		
		logger.debug("项目【" + getProjectName() + "】的resources文件夹，所在路径是【" +path + "】");
		if (FileUtil.existsFile(path)) {			
			return path;
		}
		throw new RuntimeException("项目【" + getProjectName() + "】的resources文件夹，所在路径是【" +path + "】不存在");
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：<br/>
	 * <b>注意:仅仅，用于Maven的web程序结构</b></li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-24；时间：下午11:56:12</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @return
	 * @return
	 */
	public static String getWebContextPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("");
	}
	
	

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：返回/src/main/webapp目录，所在的物理路径<br/>
	 * <B>只在开发阶段使用</B>
	 * </li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2013-6-29；时间：下午4:54:20</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @return
	 * @return
	 */
	public static String getWebRootPath() {
		String path = getProjectPath() + "/src/main/webapp";
		File file = new File(path);
		if (file.exists()) {			
			return path;
		}
		throw new RuntimeException("Web项目的【webRoot】的根路径查找失败：【" +
				path+
				"】不存在");
	}
	
	/**
	 *  @see #getWebRootPath()
	 */
	public static String getWebRootPath(Class clazz) {
		String path = getProjectPath(clazz) + "/src/main/webapp";
		File file = new File(path);
		if (file.exists()) {			
			return path;
		}
		throw new RuntimeException("Web项目的【webRoot】的根路径查找失败：【" +
				path+
				"】不存在");
	}
	
	
	public static String getMavenProjectResourcesDirPath() {

		
		
		String path = getProjectPath();
		if (path.indexOf("/")!=-1) {						
			path =  path+"/src/main/resources";
		}else if (path.indexOf("\\")!=-1) {			
			path =  path+"\\src\\main\\resources";
		}else {			
			throw new RuntimeException("9999999999");
		}
		logger.debug("项目【" + getProjectName() + "】的resources文件夹，所在路径是【" +path + "】");
		return path;
//		if (IoUtil.existsFile(path)) {			
//			return path;
//		}else {
//			
//		}
//		throw new RuntimeException("项目【" + getProjectName() + "】的resources文件夹，所在路径是【" +path + "】不存在");
	
	}
	
	
	

}

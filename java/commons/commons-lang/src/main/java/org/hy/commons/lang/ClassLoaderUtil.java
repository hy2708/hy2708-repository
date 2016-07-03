package org.hy.commons.lang;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import jodd.io.FileUtil;
import jodd.util.ReflectUtil;

import org.hy.commons.lang.character.CharsetUtil;
import org.hy.commons.lang.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 
 Java动态编译(一)
 http://chrui.iteye.com/blog/1007252
 
 http://www.oschina.net/code/snippet_220184_8607
 
 http://blog.csdn.net/zzcchunter/article/details/6991321
 
 http://www.cnblogs.com/liuling/archive/2013/05/09/dynamicCompiler.html
 
 动态生成java、动态编译、动态加载
 http://blog.sina.com.cn/s/blog_70279be20101dk0j.html
 
 * 
 */
public class ClassLoaderUtil extends jodd.util.ClassLoaderUtil{

	private static Logger logger= LoggerFactory.getLogger(ClassLoaderUtil.class);
	
	// ---------------------------------------------------------------- add class path

	/**
	 * Adds additional file or path to classpath during runtime.
	 * @see #addUrlToClassPath(java.net.URL, ClassLoader)
	 */
	public static void addFileToClassPath(File path, java.lang.ClassLoader classLoader) {
		logger.info("将文件【{}】，添加到classpath",path);
		jodd.util.ClassLoaderUtil.addFileToClassPath(path, classLoader);
		
	}

	/**
	 * Adds the content pointed by the URL to the classpath during runtime.
	 * Uses reflection since <code>addURL</code> method of
	 * <code>URLClassLoader</code> is protected.
	 */
	public static void addUrlToClassPath(URL url, java.lang.ClassLoader  classLoader) {
		logger.info("将路径【{}】，添加到classpath",url);
		jodd.util.ClassLoaderUtil.addUrlToClassPath(url, classLoader);
		
	}

	
	/**
	 * @see #compile(String, String)
	 */
	public static void compile(String fileName) {
		compile(fileName, "utf-8");
	}
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：用编程的方式，对Java文件进行编译</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-26；时间：下午4:40:38</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param fileName
	 * @param charset
	 */
	public static void compile(String javaFilePath,String charset) {
		if (new File(javaFilePath).isFile()&&!StringUtil.endsWithIgnoreCase(javaFilePath, ".java")) {
			throw new RuntimeException("");
		}
		JavaCompiler compiler =ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, CharsetUtil.getCharset(charset));
//		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, CharsetUtil.getCharset("utf-8"));
		Iterable iterable = manager.getJavaFileObjects(new File(javaFilePath));
		CompilationTask task =compiler.getTask(null, manager, null, null, null, iterable);
		Boolean result =task.call();
		if (result) {
			logger.info("文件【{}】编译成功",javaFilePath);
		}else {
			logger.error("文件【{}】编译失败",javaFilePath);
			throw new RuntimeException("文件【" +
					javaFilePath+"】编译失败");
		}
		try {
			manager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void compile3(String javaFilePath,String charset) {
		//ProcessBuilder pb = new ProcessBuilder("myCommand", "myArg1", "myArg2"); 
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：用编程的方式，对Java文件进行编译</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-26；时间：下午4:40:38</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param fileName
	 * @param charset
	 */
	public static void compile2(String javaFilePath,String charset,String... arg) {
		if (new File(javaFilePath).isFile()&&!StringUtil.endsWithIgnoreCase(javaFilePath, ".java")) {
			throw new RuntimeException("");
		}
		JavaCompiler javac =ToolProvider.getSystemJavaCompiler();
		
		List<String> commandArgs= new LinkedList<String>(Arrays.asList(arg));
		commandArgs.add("-encoding");
		commandArgs.add(charset);
		//commandArgs.add("-g");
		//commandArgs.add("-verbose");
		commandArgs.add(javaFilePath);
		int compilationResult = javac.run(null,null,null,
				//arg[0],arg[1],
				//"-g","-verbose",
				//javaFilePath
				commandArgs.toArray(new String[commandArgs.size()])
				);
		if (compilationResult==0) {
			logger.info("文件【{}】编译成功",javaFilePath);
		}else {
			logger.error("文件【{}】编译失败",javaFilePath);
			throw new RuntimeException("文件【" +
					javaFilePath+"】编译失败");
		}
	}

	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：编译制定目录下的Java文件</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-6-6；时间：下午2:44:04</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param javaFilePath
	 * @param charset
	 */
	public static void compileDir(String fileDirPath,String charset) {
		File fileDir = new File(fileDirPath);
		if (fileDir.exists()&&fileDir.isDirectory()) {
			File[] children =fileDir.listFiles();
			for (int i = 0; i < children.length; i++) {
				if (children[i].isFile()) {
					compile(children[i].toString(), charset);
				}else {
					compileDir(children[i].toString(), charset);
				}
			}
		}else {
			throw new RuntimeException("路径【" +
					fileDirPath+"】不存在或者不是一个目录");
		}
	}

	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：把classpath路径外的class文件加载到内存</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-26；时间：下午4:45:10</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param className
	 * @param classData
	 * @return
	 */
	public static Class defineClass(String className, byte[] classData) {
		logger.info("类【{}】，加载到JVM",className);
		return jodd.util.ClassLoaderUtil.defineClass(className, classData, getDefaultClassLoader());
	}
	
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：编译Java文件，并加载到内存</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-5-11；时间：下午8:36:23</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param className
	 * @param classData
	 * @return
	 */
	@Deprecated
	public static Class compileJavaAndDefineClass(String javaFilePath, byte[] classData) {
		ClassLoaderUtil.compile(javaFilePath,"gbk");
		int suff =javaFilePath.lastIndexOf(".java");
		String preFileName =javaFilePath.substring(0, suff);
		
      //  ClassLoaderUtil.defineClass(preFileName+".class", IoUtil.readBytes(file.toString()));
        
        
		//return jodd.util.ClassLoaderUtil.defineClass(className, classData, getDefaultClassLoader());
		return null;
	}
    

}

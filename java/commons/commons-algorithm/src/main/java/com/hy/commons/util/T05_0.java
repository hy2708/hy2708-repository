package com.hy.commons.util;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


import org.apache.commons.io.input.ClassLoaderObjectInputStream;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.find.FindFileUtil;
import org.hy.commons.io.path.ProjectPathUtil;
import org.hy.commons.lang.ClassLoaderUtil;
import org.hy.commons.lang.character.CharacterUtil;
import org.hy.commons.lang.character.CharsetUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.hy.commons.lang.string.StringUtil;


public class T05_0 {

	static  String charset="gbk";
	public static void main(String[] args) throws Exception {
		String path ="E:\\导师\\java\\实验5_hhy\\实验5_20150522\\" +
				"__5_3901140130_1406_3901140130_______5" ;

		path=getFinalPath(path);
		System.out.println("Final Path  "+path);
		ClassLoaderUtil.compile(path+"\\" +"GeometricObject.java",charset);
		ClassLoaderUtil.compile(path+"\\" +"Circle2D.java",charset);
		ClassLoaderUtil.compile(path+"\\" +"Triangle.java",charset);
		System.out.println("============================================");
		List<String> testCases01 = new  LinkedList<String>();
		String fileNamePre ="";
		fileNamePre= getFileNamePre(path);
		/*ClassLoaderUtil.compile(path+"\\" +	fileNamePre+"1"+".java",charset);
		ClassLoaderUtil.compile(path+"\\" +	fileNamePre+"2"+".java",charset);
		ClassLoaderUtil.compile(path+"\\" +	fileNamePre+"3"+".java",charset);
		ClassLoaderUtil.compile(path+"\\" +	fileNamePre+"4"+".java",charset);
		*/
		//loadOthers(path, "");
		
		testCases01.add("abcaba \r\n a");
		//testCases01.add("abcdefa \r\n  a");
		//testCases01.add("abcdefa \r\n  g");
		//testDemo01(path,fileNamePre+"1",testCases01,"");
		System.out.println("============================================");
		
		List<String> testCases02 = new  LinkedList<String>();
		//testCases02.add("12345678a");
		//testCases02.add("1234567a");
		//testCases02.add("123456788");
		
		//testCases02.add("12345678.");
		//testCases02.add("aaaaaaaaa");
		
		//testCases02.add("aaaaaaaa");
		//testCases02.add("123456a");
		testCases02.add("a");
		
		//testDemo01(path,"Fan",testCases02,"");
		testDemo01(path,fileNamePre+"2",testCases02,"");
		System.out.println("============================================");

		
		List<String> mainArgs03 = new  LinkedList<String>();
		mainArgs03.add("d:/1.txt");
		mainArgs03.add("d:/2.txt");
		List<String> testCases03 = new  LinkedList<String>();
		testCases03.add("d:/1.txt");
		testCases03.add("d:/2.txt");
		//testCases03.add("1 0 1");
		//testDemo01(path,"QuadraticEquation",testCases03,"");
		//testDemo01(path,fileNamePre+"3",testCases03,mainArgs03,"");
		System.out.println("============================================");
		
		List<String> testCases04 = new  LinkedList<String>();
		testCases04.add("");
		//testDemo01(path,"Location",testCases04,"");
		//testDemo01(path,fileNamePre+"4",testCases04,"");
		System.out.println("============================================");
		
	}
	
	public static String getFinalPath(String path) throws Exception {
		File file = new File(path);
		
		if (file.isDirectory()) {
			List<File> files =FindFileUtil.findFilesByWildCard(
					path,
					false,false,true, "", "*.java",true);
			if (files.size()>0) {
				return path;
			}else {
				List<File> dir =FindFileUtil.findFilesByWildCard(
						path,
						true, true,false,"", "*39011*",true);
				if (dir.size()!=1) {					
					throw new RuntimeException();
				}else {
					return dir.get(0).getAbsolutePath();
				}
			}
		}else {
			throw new RuntimeException();
		}
	}
	public static String getFileNamePre(String path) throws Exception {
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", "*.java");
		Set<String> fileNames = new HashSet<String>();
		for (File file : files) {
			fileNames.add(file.getName());
		}
		
		String pre = null;
		for (String string : fileNames) {
			if (string.endsWith("1.java")) {
				pre = string.substring(0, string.indexOf("1.java"));
				if (fileNames.contains(pre+"2.java")) {
					return pre;
				}else {
					pre=null;
				}
			}
		}
		return null;
	}
	public static void loadOthers(String path,String packagePre) throws Exception {
		List<String> list= new ArrayList<String>();
		list.add("Fan");
		list.add("location");
		list.add("QuadraticEquation");
		//list.add("QuadraticEquation");
		for (String string : list) {
			String sspath =path+"\\" +string+".java";
			File file00 = new File(sspath);
			if (file00.exists()) {
				System.out.println("文件存在"+sspath);

				ClassLoaderUtil.compile(path+"\\" +
						string+".java",charset);
				//List<File> files =FindFileUtil.findFilesByWildCard(
					//	path,
						//true, "",path+"\\"+ string+".class");
				//File file =files.get(0);
				//File file =files.get(0);
				String classFile =path+"\\" +string+".class";
				File file = new File(classFile);

				if (file.exists()) {
					//System.out.println(files.size());
					
				       // ClassLoaderUtil..(path, classLoader);
					
					System.out.println("class文件存在"+string+".class");
				        ClassLoaderUtil.defineClass(packagePre+string, IoUtil.readBytes(file.toString()));
				        //System.out.println(ClassLoaderUtil.loadClass(packagePre+string));
					
				} else {

					System.out.println("class文件不存在"+sspath);
				}
			}else {
				System.out.println("文件不存在"+sspath);
				String classFile =path+"\\" +string+".class";
				File file = new File(classFile);
				if (file.exists()) {
					
					System.out.println("class文件存在"+path+"\\" +string+".class");
				       // ClassLoaderUtil..(path, classLoader);
				        ClassLoaderUtil.defineClass(packagePre+string, IoUtil.readBytes(file.toString()));
						 
				        System.out.println(ClassLoaderUtil.loadClass(packagePre+string));
					
				} else {

					System.out.println("class文件不存在"+sspath);
				}
			}
			
		}
	}
	public static void testDemo01(String path,String className,List<String> inputstreamTestCases,String packagePre) throws Exception {
		testDemo01(path, className, inputstreamTestCases, null, packagePre);
	}
	public static void testDemo01(String path,String className,List<String> inputstreamTestCases,List<String> mainArgs,String packagePre) throws Exception {
		
		charset = CharacterUtil.getFileCharset(path+"\\" +
				className+".java");
		
//		FileUtil.replaceLine(path+"\\" +
	//			className+".java", 0, 4, "package", ";", charset);

		ClassLoaderUtil.compile(path+"\\" +
				className+".java",charset);
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", className+".class");
		File file =files.get(0);
		System.out.println(files.size());
		
        ClassLoaderUtil.defineClass(packagePre+className, IoUtil.readBytes(file.toString()));
        
        System.out.println(ClassLoaderUtil.loadClass(packagePre+className));
        Object m = ClassLoaderUtil.loadClass(packagePre+className).newInstance();
//		Test1xx m =(Test1xx) Class.forName(Test1xx.class.getName()).newInstance();
		 //Class.forName(Test1xx.class.getName()).newInstance();
		
		
//		String string ="2\na b";
		for (int i = 0; i < inputstreamTestCases.size(); i++) {
			
			System.setIn(new ByteArrayInputStream(inputstreamTestCases.get(i).getBytes()));
			Method method =ReflectionUtil.getMethod0(ClassLoaderUtil.loadClass(packagePre+className), "main", String[].class);
			System.out.println(method);
			if (mainArgs==null||mainArgs.size()==0) {				
				method.invoke(m, (Object)new String[]{});
			}else {
				method.invoke(m, (Object)new String[]{mainArgs.get(i)});
				
			}
			//m.main(null);
		}
	}
	
	public static void testDemo02(String path,String className) throws Exception {
		ClassLoaderUtil.compile(path+"\\" +
				className+".java");
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", className+".class");
		File file =files.get(0);
		System.out.println(files.size());
		
        //final Process proc = Runtime.getRuntime().exec("cd "+path+" \r\n javac "+file.getName());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //ClassLoaderUtil.addFileToClassPath(file, contextClassLoader);
        ClassLoaderUtil.defineClass(className, IoUtil.readBytes(file.toString()));
        //        ClassLoaderObjectInputStream mi = new ClassLoaderObjectInputStream(contextClassLoader, );
  //      System.out.println(mi.readObject());
        System.out.println(ClassLoaderUtil.loadClass(className));
        Object m = ClassLoaderUtil.loadClass(className).newInstance();
//		Test1xx m =(Test1xx) Class.forName(Test1xx.class.getName()).newInstance();
		 //Class.forName(Test1xx.class.getName()).newInstance();
		
		List<String> testCases = new  LinkedList<String>();
		testCases.add("0 0 1 0 1 1");
		testCases.add("3 8 1 4 3 9");
//		String string ="2\na b";
		for (int i = 0; i < testCases.size(); i++) {
			
			System.setIn(new ByteArrayInputStream(testCases.get(i).getBytes()));
			Method method =ReflectionUtil.getMethod0(ClassLoaderUtil.loadClass(className), "main", String[].class);
			System.out.println(method);
			method.invoke(m, (Object)new String[]{});
			//m.main(null);
		}
	}

	
	public static void testDemo03(String path,String className) throws Exception {
		ClassLoaderUtil.compile(path+"\\" +
				className+".java");
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", className+".class");
		File file =files.get(0);
		System.out.println(files.size());
		
        //final Process proc = Runtime.getRuntime().exec("cd "+path+" \r\n javac "+file.getName());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //ClassLoaderUtil.addFileToClassPath(file, contextClassLoader);
        ClassLoaderUtil.defineClass(className, IoUtil.readBytes(file.toString()));
        //        ClassLoaderObjectInputStream mi = new ClassLoaderObjectInputStream(contextClassLoader, );
  //      System.out.println(mi.readObject());
        System.out.println(ClassLoaderUtil.loadClass(className));
        Object m = ClassLoaderUtil.loadClass(className).newInstance();
//		Test1xx m =(Test1xx) Class.forName(Test1xx.class.getName()).newInstance();
		 //Class.forName(Test1xx.class.getName()).newInstance();
		StringBuffer stringBuffer = new StringBuffer();
		
		List<String> testCases = new  LinkedList<String>();
		testCases.add("");
		testCases.add("");
//		String string ="2\na b";
		for (int i = 0; i < testCases.size(); i++) {
			
			System.setIn(new ByteArrayInputStream(testCases.get(i).getBytes()));
			Method method =ReflectionUtil.getMethod0(ClassLoaderUtil.loadClass(className), "main", String[].class);
			System.out.println(method);
			method.invoke(m, (Object)new String[]{});
			//m.main(null);
		}
	}
	
	public static void testDemo04(String path,String className) throws Exception {
		ClassLoaderUtil.compile(path+"\\" +
				className+".java");
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", className+".class");
		File file =files.get(0);
		System.out.println(files.size());
		
        //final Process proc = Runtime.getRuntime().exec("cd "+path+" \r\n javac "+file.getName());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //ClassLoaderUtil.addFileToClassPath(file, contextClassLoader);
        ClassLoaderUtil.defineClass(className, IoUtil.readBytes(file.toString()));
        //        ClassLoaderObjectInputStream mi = new ClassLoaderObjectInputStream(contextClassLoader, );
  //      System.out.println(mi.readObject());
        System.out.println(ClassLoaderUtil.loadClass(className));
        Object m = ClassLoaderUtil.loadClass(className).newInstance();
//		Test1xx m =(Test1xx) Class.forName(Test1xx.class.getName()).newInstance();
		 //Class.forName(Test1xx.class.getName()).newInstance();
		StringBuffer stringBuffer = new StringBuffer();
		
		List<String> testCases = new  LinkedList<String>();
		testCases.add("");
		
//		String string ="2\na b";
		for (int i = 0; i < testCases.size(); i++) {
			
			System.setIn(new ByteArrayInputStream(testCases.get(i).getBytes()));
			Method method =ReflectionUtil.getMethod0(ClassLoaderUtil.loadClass(className), "main", String[].class);
			System.out.println(method);
			method.invoke(m, (Object)new String[]{});
			//m.main(null);
		}
	}
}

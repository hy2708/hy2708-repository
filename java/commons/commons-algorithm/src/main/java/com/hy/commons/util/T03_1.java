package com.hy.commons.util;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
import org.hy.commons.lang.character.CharsetUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.hy.commons.lang.string.StringUtil;


public class T03_1 {

	public static void main(String[] args) throws Exception {
		String path ="E:\\导师\\java\\实验3\\" +
				"__3_3901140329_1406";

		
		//ClassLoaderUtil.compile(path+"\\" +"Fan.java","gbk");
		//ClassLoaderUtil.compile(path+"\\" +"Location.java","gbk");
		//ClassLoaderUtil.compile(path+"\\" +"QuadraticEquation.java","gbk");
		//loadOthers(path, "");
		System.out.println("============================================");
		List<String> testCases01 = new  LinkedList<String>();
		String fileNamePre ="Work";
		testCases01.add("");
		//testCases01.add("2 2 2 8 99 99 8 8 5 0");
		//testDemo01(path,fileNamePre+"1",testCases01,"");
		testDemo01(path,"Random",testCases01,"");
		System.out.println("============================================");
		
		List<String> testCases02 = new  LinkedList<String>();
		testCases02.add("");
		//testCases02.add("2 5 5 8 1 8 5 8 9 11");
		
		//testDemo01(path,"Fan",testCases02,"");
		//testDemo01(path,fileNamePre+"2",testCases02,"");
		System.out.println("============================================");

		
		List<String> testCases03 = new  LinkedList<String>();
		testCases03.add("1 2 1");
		testCases03.add("1 3 2");
		testCases03.add("1 0 1");
		testDemo01(path,"QuadraticEquation",testCases03,"");
		//testDemo01(path,fileNamePre+"3",testCases03,"");
		System.out.println("============================================");
		
		List<String> testCases04 = new  LinkedList<String>();
		testCases04.add("3  4 " +
				"23.5  35  2  10 " +
				"4.5  3  45  3.5 " +
				"35  44  5.5  9.6");
		testDemo01(path,"Location",testCases04,"");
		//testDemo01(path,fileNamePre+"4",testCases04,"");
		System.out.println("============================================");
		
	}
	
	public static void loadOthers(String path,String packagePre) throws Exception {
		List<String> list= new ArrayList<String>();
		list.add("Fan");
		list.add("Location");
		list.add("QuadraticEquation");
		for (String string : list) {
			String sspath =path+"\\" +string+".java";
			File file00 = new File(sspath);
			if (file00.exists()) {
				ClassLoaderUtil.compile(path+"\\" +
						string+".java","gbk");
				List<File> files =FindFileUtil.findFilesByWildCard(
						path,
						true, "", string+".class");
				File file =files.get(0);
				if (file.exists()) {
					System.out.println(files.size());
					
				       // ClassLoaderUtil..(path, classLoader);
					System.out.println("class文件存在"+sspath);
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
					
				       // ClassLoaderUtil..(path, classLoader);
				        ClassLoaderUtil.defineClass(packagePre+string, IoUtil.readBytes(file.toString()));
						 
				        System.out.println("class文件存在"+sspath);
				        System.out.println(ClassLoaderUtil.loadClass(packagePre+string));
					
				} else {

					System.out.println("class文件不存在"+sspath);
				}
			}
			
		}
	}
	public static void testDemo01(String path,String className,List<String> testCases,String packagePre) throws Exception {
		
		
		ClassLoaderUtil.compile(path+"\\" +
				className+".java","gbk");
		List<File> files =FindFileUtil.findFilesByWildCard(
				path,
				true, "", className+".class");
		File file =files.get(0);
		System.out.println(files.size());
		
        ClassLoaderUtil.defineClass(packagePre+className, IoUtil.readBytes(file.toString()));
        
        System.out.println(ClassLoaderUtil.loadClass(packagePre+className));
//        Object m = ClassLoaderUtil.loadClass(packagePre+className).newInstance();
        Object m = ClassLoaderUtil.loadClass(className).newInstance();
//		Test1xx m =(Test1xx) Class.forName(Test1xx.class.getName()).newInstance();
		 //Class.forName(Test1xx.class.getName()).newInstance();
		
		
//		String string ="2\na b";
		for (int i = 0; i < testCases.size(); i++) {
			
			System.setIn(new ByteArrayInputStream(testCases.get(i).getBytes()));
			Method method =ReflectionUtil.getMethod0(ClassLoaderUtil.loadClass(packagePre+className), "main", String[].class);
			System.out.println(method);
			method.invoke(m, (Object)new String[]{});
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

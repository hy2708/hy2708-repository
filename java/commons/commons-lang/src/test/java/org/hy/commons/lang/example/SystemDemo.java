package org.hy.commons.lang.example;

import java.io.IOException;
import java.util.Properties;


class Emp{
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("运行垃圾回收的收,执行这里");
		super.finalize();
	}
	
}

public class SystemDemo {
	public static void main(String[] args) {
		
		System.out.println("hello");
		
		/**
		 * 非 0 的状态码表示异常终止
		 * 0表示 直接退出
		 */
		//System.exit(0);
		
		try{
			
			//return;//打印0000000000000
			
			//System.exit(1);//不打印0000000000000
			
		}finally{
			System.out.println("0000000000000");
		}
		
	//	System.out.println("hello");
		
		/**
		 * static String getenv(String name) 
          			获取指定的环境变量值。 
		 */
		
		String paths = System.getenv("path");
		System.out.println(paths);
		
		String[] ps = paths.split(";");
		for (String string : ps) {
			System.out.println(string);
		}
		
		/**
		 * static Properties getProperties() 
          			确定当前的系统属性。 
		 */
		
		Properties p = System.getProperties();
		
		p.list(System.out);//输出系统的属性
		
		/**
		 * static void gc() 运行垃圾回收器。 
		 */
		
		new Emp();
		new Emp();
		new Emp();
		
		/*
		 * 	强制垃圾回收
		 * 
		 *  Runtime.getRuntime().gc()

		 * */
		
		System.gc();
		
		/**
		 *  Process exec(String command) 
          		在单独的进程中执行指定的字符串命令。 
		 */
		try {
			Runtime.getRuntime().exec("notepad");
			Runtime.getRuntime().exec("mspaint");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

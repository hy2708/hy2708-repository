package org.hy.commons.jni;

import org.hy.commons.lang.SystemUtil;

public class HelloJni {
	
	
	public native void hello() ;
	
	
	 
	public static void main(String[] args) {
		String
		int jj =JNILib.add(8, 11);
		System.out.println(jj);
		int i = new JNILib().doInt(8);
		System.out.println(i);
		//new HelloJni().hello();
		//System.out.println( System.getProperty("java.library.path"));
	}
}

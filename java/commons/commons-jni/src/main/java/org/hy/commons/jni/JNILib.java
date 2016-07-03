package org.hy.commons.jni;

import java.util.Enumeration;
import java.util.Iterator;

public class JNILib {
	static{
		//System.out.println(System.getProperty("java.library.path"));
		System.loadLibrary("libJNILib");
	}
	
	public static native void jniPrint(String str);
	
	public static native int add(int a, int b);

	private native void  doVoid();
	native int doShort();
	native void doArray(Object[] o );
	native int doInt(int i);	//byte ,short ,int,long,float,double ,boolean,char	
	native int doInt(double d);	//byte ,short ,int,long,float,double ,boolean,char
	native int doInt(Object o);	
	native int doInt(double d1,double d2);
	static native int doInt(double d1 ,double d2,double d3);
	static native int doInt(double d1 ,float f,boolean b ,char[] c );	
	
	native int doInt(int[] i);
	native int doInt(int[] i1,double[] i2 );	
	static native int doInt(int[] i1,double[] i2 ,Object[] o );	
	
	public native String doString(String s);
	public native Object doObject(Object o );
	public native Enumeration doInterface(Iterator it);
	public native Student doStudent(Student s);
	

//	native int[] doInt(int[] i);	//byte ,short ,int,long,float,double ,boolean,char
	public native String[] doString(String[] s);
	public native Object[] doObjects(Object[] o );
	public native Enumeration[] doInterface(Iterator[] it);
	public native Student[] doStudent(Student[] s);
		
	public native static Object doAll(int[] i , String[] s , Student[] student );				

};

class Student{}

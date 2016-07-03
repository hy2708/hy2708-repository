package org.hy.commons.jni;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//MavenUtil.createProjectPackage();
        System.out.println( "Hello World!" );
    }
}

class A{
	public  void name(WA wa,String string) {
		System.err.println(wa+string);
	}
};

class WA{
	A a ;
	public  void name(String string) {
		a .name(this, string);
	}
};

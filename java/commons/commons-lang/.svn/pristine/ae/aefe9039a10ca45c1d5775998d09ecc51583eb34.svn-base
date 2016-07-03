package org.hy.commons.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MyAnnotation(value1={"onClass01","onClass02"})
public class MyAnnotationExample {
	
    @MyAnnotation(value1={"onField01","onField02"})
	private String mm=null;

    @MyAnnotation(value1={"onMethod01","onMethod02"})
    @Deprecated
    public void execute(String...  arg){
        System.out.println("method");
    }
    
    
}

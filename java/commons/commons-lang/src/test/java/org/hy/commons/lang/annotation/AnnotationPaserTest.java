package org.hy.commons.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationPaserTest {
	
	@MyAnnotation(value1={"onMethod01","onMethod02"})
    @Deprecated
    public void m(){
        System.out.println("method");
    }
	
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        MyAnnotationExample annotationTest2 = new MyAnnotationExample();
		Class<MyAnnotationExample> c = MyAnnotationExample.class;
        /*
         * 解析Class的注解
         */
		//获取AnnotationTest2的Class实例
        if (c.isAnnotationPresent(MyAnnotation.class)) {
        	System.err.println("我的类上，有这个注解");
		}
        
        /*
         * 解析Method的注解
         */
        //获取需要处理的方法Method实例
        Method method = c.getMethod("execute", new Class[]{});
        //判断该方法是否包含MyAnnotation注解
        if(method.isAnnotationPresent(MyAnnotation.class)){
            //获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            //执行该方法
            method.invoke(annotationTest2, new Object[]{});
            //获取myAnnotation
            String[] value1 = myAnnotation.value1();
            System.out.println(value1[0]);
        }
        //获取方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations){
            System.out.println(annotation);
        }
    }

}

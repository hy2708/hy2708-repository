package org.hy.commons.aop.proxy;

import java.lang.reflect.Method;

import org.hy.commons.example.entity.Student;
import org.hy.commons.lang.reflect.ReflectionUtil;

public class T {

	public static void main(String[] args) {
		Student student = new Student();
		String expression ="execution(* org.hy..*.set*(..))";
		Method[] methods =ReflectionUtil.getDeclaredAllMethods(student.getClass());
		for (Method method : methods) {
			
			Boolean boolean1 =PointcutUtil.match(expression,student.getClass(), method);
			System.out.println(boolean1+" "+method.getName());
		}
	}
}

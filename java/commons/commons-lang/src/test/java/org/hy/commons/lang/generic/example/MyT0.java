package org.hy.commons.lang.generic.example;

import java.io.Serializable;
import java.lang.reflect.Type;


public class MyT0<T> implements Serializable{

	public static void main(String[] args) {
		//Class clazz = GenericsUtils.getSuperClassGenricType(MyT2.class);
		Type[] types =MyT2.class.getGenericInterfaces();
		System.err.println(""+types.length);
		System.err.println(""+types[0].toString());
	}
}
class MyT2<T>{
	private void m(String string) {

	}
}
class MyT3{
	private void m() {

	}
}
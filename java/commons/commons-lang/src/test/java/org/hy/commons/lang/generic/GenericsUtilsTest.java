package org.hy.commons.lang.generic;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.lang.reflect.Type;

import org.hy.commons.lang.generic.GenericsUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenericsUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSuperClassGenricTypeClassInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuperClassGenricTypeClass() {
		
		MyT2<MyT3> myT2 = new MyT2<MyT3>();
		
		myT2.m(null);
	}

	@Test
	public void testGetMethodGenericReturnTypeMethodInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMethodGenericReturnTypeMethod() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMethodGenericParameterTypesMethodInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMethodGenericParameterTypesMethod() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldGenericTypeFieldInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldGenericTypeField() {
		fail("Not yet implemented");
	}

}

class MyT<T> implements Serializable{

	public static void main(String[] args) {
		//Class clazz = GenericsUtils.getSuperClassGenricType(MyT2.class);
		Type[] types =MyT2.class.getClass().getGenericInterfaces();
		System.err.println(""+types.length);
		System.err.println(""+types[0].toString());
	}
}
class MyT2<T> extends MyT<T>{
	public void m(String string) {
		Class class1 = GenericsUtils.getSuperClassGenricType(MyT2.class);
		System.err.println(class1);
	}
}
class MyT3{
	private void m() {

	}
}

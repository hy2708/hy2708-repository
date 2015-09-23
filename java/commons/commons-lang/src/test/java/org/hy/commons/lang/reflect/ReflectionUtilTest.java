package org.hy.commons.lang.reflect;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.hy.commons.lang.example.entity.UserA;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionUtilTest {
	Logger logger = LoggerFactory.getLogger(ReflectionUtilTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToUncheckedException() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchElementPropertyToList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchElementPropertyToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeclaredField() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeclaredMethodClassOfQStringClassOfQArray() {
		Method object =ReflectionUtil.getDeclaredMethod(UserA.class, "getName",new Class[]{});
		logger.debug("[{}]",object.toString());
		
		Method object2 =ReflectionUtil.getDeclaredMethod(UserA.class, "getName");
		logger.debug("[{}]",object2.toString());
		logger.debug("[{}]",object2.getName());
		Method object3 =ReflectionUtil.getDeclaredMethod(UserA.class, "setName",new Class[]{});
		logger.debug("[{}]",object3.toString());
	}

	@Test
	public void testGetDeclaredMethodObjectStringClassOfQArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFieldValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuperClassGenricTypeClassOfQ() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSuperClassGenricTypeClassOfQInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testInvokeMethod() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsPublicStaticFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakeAccessible() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFieldValue() {
		fail("Not yet implemented");
	}

}

package org.hy.commons.lang.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.hy.commons.lang.annotation.AnnotationUtil;
import org.hy.commons.lang.reflect.ReflectionUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnnotationUtilTest {
	Logger logger = LoggerFactory.getLogger(AnnotationUtilTest.class);

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
	public void testGetAllAnnotations_Class() {
		
		Annotation[] annotations = AnnotationUtil.getAllAnnotations(MyAnnotationExample.class);
		for (Annotation annotation : annotations) {
			logger.debug(annotation.annotationType().toString());
		
		}
		logger.debug("ssssssss");
		assertTrue(annotations.length>0);
	}
	
	@Test
	public void testGetAllAnnotations_Method() {
		Method method = ReflectionUtil.getDeclaredMethod(AnnotationPaserTest.class, "m");
		Annotation[] annotations = AnnotationUtil.getAllAnnotations(method);
		assertTrue(annotations!=null);

	}

	@Test
	public void testGetAnnotationClassOfQClassOfA() {
		Annotation annotation = AnnotationUtil.getAnnotation(MyAnnotationExample.class, MyAnnotation.class);
		logger.debug(annotation.annotationType().toString());
		assertEquals(MyAnnotation.class.getName(), annotation.annotationType().getName());
	
	}

	
	
	@Test
	public void testGetAnnotationMethodClassOfA() {
		Method method = ReflectionUtil.getDeclaredMethod(AnnotationPaserTest.class, "m");
		Annotation annotation = AnnotationUtil.getAnnotation(method, Deprecated.class);
		logger.debug(annotation.annotationType().toString());
		assertEquals(Deprecated.class.getName(), annotation.annotationType().getName());
	
	}

	//@Test
	public void testGetPropertyOrGetterAnnotation() {
		fail("Not yet implemented");
	}

	//@Test
	public void testIsClassAnnotationPresent() {
		fail("Not yet implemented");
	}

	//@Test
	public void testIsFieldAnnotationPresent() {
		fail("Not yet implemented");
	}

	//@Test
	public void testIsGetterAnnotationPresent() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsMethodAnnotationPresent() {
		Method method = ReflectionUtil.getDeclaredMethod(AnnotationPaserTest.class, "m");
		Annotation[] annotations = AnnotationUtil.getAllAnnotations(method);
		for (Annotation annotation : annotations) {
			logger.debug(annotation.annotationType().toString());
		}
		Boolean actual = AnnotationUtil.isMethodAnnotationPresent(method, Deprecated.class);
		assertEquals(true, actual);
	}

}

@Deprecated
@SuppressWarnings("unchecked")
@Ignore
class T2{
	@Ignore
	@Deprecated
	@SuppressWarnings("unchecked")
	public void m() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void m2() {
		
	}
}

package org.hy.commons.lang;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.hy.commons.example.entity.Classroom;
import org.hy.commons.example.entity.Special;
import org.hy.commons.example.entity.Student;
import org.hy.commons.lang.example.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BeanUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCloneBean() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopyProperties() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopyProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testDescribe() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrayProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIndexedPropertyObjectString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIndexedPropertyObjectStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMappedPropertyObjectString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMappedPropertyObjectStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void tesGetFieldNameFromMethodName_Method() {
		fail("Not yet implemented");
	}
	
	@Test
	public void tesGetFieldNameFromMethodName_MethodName() {
		String field = BeanUtil.getFieldNameFromMethodName("getName");
		String field2 = BeanUtil.getFieldNameFromMethodName("setName");
		Assert.assertEquals("name", field);
		Assert.assertEquals("name", field2);
	}
	
	@Test
	public void testGetNestedProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		classroom.setName("cccccc");
		student.setClassroom(classroom);
		//a.setbObject(bObject);
		System.err.println(BeanUtil.getProperty(student, "classroom.name"));;
	}
	
	@Test
	public void testGetProperty_2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		classroom.setName("cccccc");
		student.setClassroom(classroom);
		//a.setbObject(bObject);
		classroom = (Classroom) BeanUtil.getProperty(student, "classroom");;
		System.err.println(classroom.getName());;
	}
	
	@Test
	public void testGetProperty_3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		classroom.setName("cccccc");
		//student.setClassroom(classroom);
		//a.setbObject(bObject);
		//classroom = (Classroom) ;;
		System.err.println(BeanUtil.hasProperty(student, "classroom"));;
	}

	@Test
	public void testGetSimpleProperty() throws Exception, InvocationTargetException, NoSuchMethodException {
		User a = new User();
		BU_B bObject = new BU_B();
		a.setName("mmmmmmm");
		//a.setbObject(bObject);
		//System.err.println(BeanUtil.getSimpleProperty(a, "name"));;
	}

	@Test
	public void hasProperty() throws Exception, IllegalAccessException {
		Boolean boolean1 = BeanUtil.hasProperty( Classroom.class.newInstance(), "special");
		Boolean boolean2 = BeanUtil.hasProperty(new Special(), "classroom");
		System.err.println(boolean1);
		System.err.println(boolean2);
	}

	public static boolean hasDeclaredProperty(Object bean, String name) {
		return jodd.bean.BeanUtil.hasDeclaredProperty(bean, name);
	}


	
	public static Boolean hasPropertyValue(Object bean, String name)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException 
			{	
		Object value = jodd.bean.BeanUtil.getProperty(bean, name);
		if (null==value) {
			return false;
		}
		return true;
	}
	
	@Test
	public void testPopulate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		//classroom.setName("cccccc");
		//student.setClassroom(classroom);
		BeanUtil.setProperty(student	, "classroom", classroom);
		System.err.println(BeanUtil.getProperty(student, "classroom"));;
	}

	@Test
	public void testSetProperty_2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		//classroom.setName("cccccc");
		student.setClassroom(classroom);
		BeanUtil.setProperty(student	, "classroom.name", "nnnn");
		System.err.println(BeanUtil.getProperty(student, "classroom.name"));;
	}
	
	@Test
	public void testSetProperty_3() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Student student = new Student();
		Classroom classroom = new Classroom();
		//classroom.setName("cccccc");
		//student.setClassroom(classroom);
		BeanUtil.setProperty(student	, "classroom.name", "nnnn");
		System.err.println(BeanUtil.getProperty(student, "classroom.name"));;
	}
	public void testPopulateToList() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
	}
	public void testPopulateToMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
	}
	public void testPopulateToMap2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
	}
}

class A{
	BU_B  bObject;

	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public BU_B getbObject() {
		return bObject;
	}

	public void setbObject(BU_B bObject) {
		this.bObject = bObject;
	}
}
class BU_B{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
package org.hy.commons.lang;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConvertUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToSubClass() {
		CA ca = new CA();
		ca.setId(1);
		ca.setName("nnn");
		CB cb = ConvertUtil.convertToSubClass(ca, CB.class);
		System.err.println(cb.getId());
		System.err.println(cb.getName());
	}

}

class CA{
	String name = null;
	Integer id= null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
class CB extends CA{
	String gender= null;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

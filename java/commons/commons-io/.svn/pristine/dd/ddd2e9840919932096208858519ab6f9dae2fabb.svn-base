package org.hy.commons.io.core;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertiesUtilTest {

	String path = ProjectPathUtil.getProjectClassPath()+"/test.properties";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPropertiesFile() {
		Properties properties = PropertiesUtil.getPropertiesFile( path);
		String username = properties.getProperty("username");
		assertEquals("xxx", username);
	}

	@Test
	public void testReadProperties() {
		Map<String, String> properties = PropertiesUtil.readProperties(path);
		String username = properties.get("username");
		assertEquals("xxx", username);
	}

	@Test
	public void testReadProperty() {
		
		String username = PropertiesUtil.readProperty(path,"username");
		assertEquals("xxx", username);
	}

}

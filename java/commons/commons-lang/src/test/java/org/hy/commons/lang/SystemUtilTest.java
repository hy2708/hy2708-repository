package org.hy.commons.lang;

import static org.junit.Assert.*;

import java.util.Properties;

import org.hy.commons.test.CommonTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

public class SystemUtilTest extends CommonTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetJavaHome() {
		logger.info("JavaHome 是【{}】", SystemUtil.getJavaHome());
	}

	@Test
	public void testGetJavaHomeLib() {
		logger.info("JavaHomeLib 是【{}】", SystemUtil.getJavaHomeLib());
	}

	@Test
	public void testGetUserHome() {
		logger.info("User Home 是 【{}】",SystemUtil.getUserHome());
	}

	@Test
	public void testGetProperties() {
		Properties p =SystemUtil.getProperties();
		p.list(System.out);
	}

	@Test
	public void testArraycopy() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testGetJrePackages() {
		logger.info("Jre Packages 是 【{}】",SystemUtil.getJrePackages());

	}

	@Test
	public void testGetUserDir() {
		logger.info("User Dir 是 【{}】",SystemUtil.getUserDir());
		
	}

	@Test
	public void testGetUserName() {
		logger.info("User Home 是 【{}】",SystemUtil.getUserName());

	}

	@Test
	public void testGetUserHome1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWorkingFolder() {
		logger.debug("WorkingFolder 是 【{}】",SystemUtil.getWorkingFolder());
	}

	@Test
	public void testGetJavaJreHome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJavaHome1() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTempDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOsName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOsVersion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJavaVersion() {
		logger.info("Java Version 是 【{}】",SystemUtil.getJavaVersion());
	}

	@Test
	public void testGetJavaSpecificationVersion() {
		logger.info("Java Specification Version 是 【{}】",SystemUtil.getJavaSpecificationVersion());
	}

	@Test
	public void testGetJavaVersionNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJavaVendor() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAtLeastJavaVersion() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsJavaVersion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassPath() {
		logger.debug("ClassPath 是 【{}】",SystemUtil.getClassPath());
	}

	@Test
	public void testGetPathSeparator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileEncoding() {
		logger.debug("File Encoding 是 【{}】",SystemUtil.getFileEncoding());
	}

	@Test
	public void testIsHostWindows() {
		logger.debug("Host Windows 是 【{}】",SystemUtil.isHostWindows());
	}

	@Test
	public void testIsHostLinux() {
		logger.debug("Host Linux 是 【{}】",SystemUtil.isHostLinux());
	}

	@Test
	public void testIsHostUnix() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsHostMac() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsHostSolaris() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsHostAix() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSunBoothClassPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHttpProxyStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHttpProxyStringString() {
		System.out.println(UUIDUtil.randomUUID().toString());
	}

}

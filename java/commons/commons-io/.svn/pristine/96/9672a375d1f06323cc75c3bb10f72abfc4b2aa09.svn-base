package org.hy.commons.io.core;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hamcrest.Matchers;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectPathUtilTest {

	String projectName = "commons-io";
	Logger logger = LoggerFactory.getLogger(ProjectPathUtilTest.class);
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
	public void testGetClassFileDir() {
		System.err.println(ProjectPathUtil.class.getResource("").getFile());
		String path = ProjectPathUtil.getClassFileDir(ProjectPathUtil.class);
		File result = IoUtil.findFile(path, ProjectPathUtil.class.getSimpleName()+".class");
		assertNotNull(result);
		fail("方法实现，有问题");
	}

	@Test
	public void testGetClassFilePath() {
		String path = ProjectPathUtil.getClassFilePath(ProjectPathUtil.class);
		assertTrue(path.endsWith(".class"));
		assertNotNull(new File(path));
		fail("方法实现，有问题");
	}
	
	
	@Test
	public void testGetClassFileDirInProject() {
		String path = ProjectPathUtil.getClassFileDirInProject(ProjectPathUtil.class);
		System.err.println(path);
	}

	@Test
	public void testGetClassFilePathInProject() {
		String path = ProjectPathUtil.getClassFilePathInProject(ProjectPathUtil.class);
		System.err.println(path);
	}
	
	@Test
	public void testGetJavaClassPackageName() {
		String path = ProjectPathUtil.getJavaClassPackageName(ProjectPathUtil.class);
		System.err.println(path);
	}
	@Test
	public void testGetJavaFileDir() {
		String path = ProjectPathUtil.getJavaFileDir(ProjectPathUtil.class);
		System.err.println(path);
	}

	
	@Test
	public void testGetJavaFilePath() {
		char d ='\u9636';
		System.err.println(d);
		ProjectPathUtil.getJavaFilePath(ProjectPathUtil.class);
		fail("方法实现，有问题");
	}

	
	@Test
	public void testGetJarFileLocation() throws IOException {
		String path = ProjectPathUtil.getJarFileLocation(Logger.class);
		logger.debug(path);
		assertThat(path, Matchers.endsWith(".jar"));
		
	}

	@Test
	public void testGetJarFileDir() {
		String path = ProjectPathUtil.getJarFileDir(Logger.class);
		logger.debug(path);
		
	}

	@Test
	public void testGetProjectName() {
		String actual = ProjectPathUtil.getProjectName();
		logger.debug(actual);
		assertEquals(projectName, actual);
	}
	
	@Test
	public void testGetProjectName_Class() {
		String actual = ProjectPathUtil.getProjectName(ProjectPathUtil.class);
		assertEquals(projectName, actual);
	}

	@Test
	public void testGetProjectPath() {
		String path = ProjectPathUtil.getProjectPath();
		System.err.println(path);
		//如果写‘/’程序会报错，只能用File.separator
		String actual = path.substring(path.lastIndexOf(File.separator)+1);
		System.out.println(actual);
		System.out.println(path.lastIndexOf('/'));
		assertEquals(ProjectPathUtil.getProjectName(), actual);
	}
	
	@Test
	public void testGetProjectPath_Class() {
		String path = ProjectPathUtil.getProjectPath(ProjectPathUtil.class);
		System.err.println("00"+path);
		//如果写‘/’程序会报错，只能用File.separator
		String actual = path.substring(path.lastIndexOf(File.separator)+1);
		System.out.println(actual);
		System.out.println(path.lastIndexOf('/'));
		assertEquals(ProjectPathUtil.getProjectName(), actual);
	}

	@Test
	public void testGetProjectPathClassString() {
		String path = ProjectPathUtil.getProjectPath(ProjectPathUtil.class, projectName);
		System.err.println(path);
		String expected = ProjectPathUtil.getProjectPath();
		assertEquals(expected, path);
	}

	@Test
	public void testGetProjectClassDirPath(){
		//见testGetProjectClassesPath
		testGetProjectClassPath();
	}
	
	@Test
	public void testGetProjectClassPath() {
		System.err.println(ProjectPathUtil.class.getName());
		String path  = ProjectPathUtil.getProjectClassPath();
		System.err.println(path);
		System.err.println(ProjectPathUtil.getProjectClassesDirPath());
		String temp = null;
		//System.err.println(File.separator);
		//if (path.endsWith(File.separator)) {
		if (path.endsWith("/")) {
			temp = path.substring(0, path.length()-1);
		}else {
			temp = path;
		}
		logger.debug(temp);
		if (temp.endsWith("classes")) {
			return;
		} else if(temp.endsWith("test-classes")){
			return;
		}else {
			fail();
		}
		//assertThat(temp.substring(temp.lastIndexOf(File.separator)+1), any)
		
	}

	@Test
	public void testGetProjectClassPath_Class() throws URISyntaxException {
		String path = ProjectPathUtil.getProjectClassPath(ProjectPathUtil.class);
		System.err.println(path);
	}
	
	@Test
	public void testGetProjectClassPathClassString() {
		String path = ProjectPathUtil.getProjectClassPath(ProjectPathUtil.class, projectName);
		System.out.println(path);
		String temp = null;
		//System.err.println(File.separator);
		if (path.endsWith(File.separator)) {
			temp = path.substring(0, path.length()-1);
		}else {
			temp = path;
		}
		logger.debug(temp);
		if (temp.endsWith("classes")) {
			return;
		} else if(temp.endsWith("test-classes")){
			return;
		}else {
			fail();
		}
		//assertThat(temp.substring(temp.lastIndexOf(File.separator)+1), any)
	
	}
	
	@Test
	public void testGetProjectJavaDirPath() {
		String path = ProjectPathUtil.getProjectJavaDirPath();
		System.err.println(path);
	}
	
	@Test
	public void testGetProjectJavaDirPath_Class() {

		String path = ProjectPathUtil.getProjectJavaDirPath(ProjectPathUtil.class);
		System.err.println("00"+path);

	}


	@Test
	public void testGetProjectResourcePath_ResourceName() {
		String path = ProjectPathUtil.getProjectResourcePath("1.txt");
		Boolean boolean1 = FileUtil.existsFile(path);
		//assertThat(temp.substring(temp.lastIndexOf(File.separator)+1), any)
		assertEquals(true, boolean1);
	}
	@Test
	public void testGetProjectResourcesDirPath() {
		String path = ProjectPathUtil.getProjectResourcesDirPath();
		System.err.println(path);
		String temp = null;
		//System.err.println(File.separator);
		if (path.endsWith(File.separator)) {
			temp = path.substring(0, path.length()-1);
		}else {
			temp = path;
		}
		if (temp.endsWith("resources")) {
			return;
		}else {
			fail();
		}
		//assertThat(temp.substring(temp.lastIndexOf(File.separator)+1), any)
		
	}
	
	@Test
	public void testGetProjectResourcesDirPath_Class() {
		String path = ProjectPathUtil.getProjectResourcesDirPath(ProjectPathUtil.class);
		System.out.println(path);
		String temp = null;
		//System.err.println(File.separator);
		if (path.endsWith(File.separator)) {
			temp = path.substring(0, path.length()-1);
		}else {
			temp = path;
		}
		logger.debug(temp);
		if (temp.endsWith("resources")) {
			return;
		}else {
			fail();
		}
		//assertThat(temp.substring(temp.lastIndexOf(File.separator)+1), any)
		
	}

}

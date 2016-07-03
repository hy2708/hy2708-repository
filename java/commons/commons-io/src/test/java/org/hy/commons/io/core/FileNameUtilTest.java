package org.hy.commons.io.core;

import static org.junit.Assert.fail;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileNameUtilTest {
	Logger logger = LoggerFactory.getLogger(FileNameUtilTest.class);


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSeparatorsToWeb() {
		fail("Not yet implemented");
	}

	@Test
	public void testFileNameUtil() throws Exception {
		String projectClassPath = ProjectPathUtil.class.getClassLoader().getResource("").toURI().getPath();
		String path = projectClassPath.substring(1,projectClassPath.length()-1);
		logger.debug("项目【" +  "】的classes路径是【" + path + "】");
		System.err.println(projectClassPath);
		String uString =FileNameUtil.removeExtension(projectClassPath);//FileNameUtil.normalizeNoEndSeparator(projectClassPath);
		System.err.println(uString);
		fail("Not yet implemented");
	}

	@Test
	public void testNormalizeString() {
		String string = FileNameUtil.normalize("aaa.txt");
		System.err.println(string);
		System.err.println(FileNameUtil.normalize("d:\\aaa.txt"));
		System.err.println(FileNameUtil.normalize("d:/aaa.txt"));
		System.err.println(FileNameUtil.normalize("/aaa.txt"));
		System.err.println(FileNameUtil.normalize("/aaa/bbb"));
		System.err.println(FileNameUtil.normalize("/aaa/bbb/"));
	}

	@Test
	public void testNormalizeStringBoolean() {
		String string = FileNameUtil.normalize("aaa.txt",false);
		System.err.println(string);
		System.err.println(FileNameUtil.normalize("aaa.txt",true));
		System.err.println(FileNameUtil.normalize("d:\\aaa.txt",false));
		System.err.println(FileNameUtil.normalize("d:\\aaa.txt",true));
		System.err.println(FileNameUtil.normalize("d:/aaa.txt",false));
		System.err.println(FileNameUtil.normalize("d:/aaa.txt",true));
		System.err.println(FileNameUtil.normalize("/aaa.txt",false));
		System.err.println(FileNameUtil.normalize("/aaa.txt",true));
		System.err.println(FileNameUtil.normalize("/aaa/bbb",false));
		System.err.println(FileNameUtil.normalize("/aaa/bbb",true));
		System.err.println(FileNameUtil.normalize("/aaa/bbb/",false));
		System.err.println(FileNameUtil.normalize("/aaa/bbb/",true));
	}

	@Test
	public void testNormalizeNoEndSeparatorString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNormalizeNoEndSeparatorStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testConcatStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testConcatStringStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoConcat() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeparatorsToUnix() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeparatorsToWindows() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeparatorsToSystem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrefixLength() {
		System.err.println(FileNameUtil.getPrefixLength("/aaa/bbb"));
		System.err.println(FileNameUtil.getPrefixLength("\\aaa\\bbb"));
		System.err.println("【" +
				FileNameUtil.getPrefixLength("aaa.txt")+"】");
	}

	@Test
	public void testIndexOfLastSeparator() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexOfExtension() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrefix() {
		System.err.println(FileNameUtil.getPrefix("/aaa/bbb"));
		System.err.println(FileNameUtil.getPrefix("\\aaa\\bbb"));
		System.err.println("【" +
				FileNameUtil.getPrefix("aaa.txt")+"】");

	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPathNoEndSeparator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullPathNoEndSeparator() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBaseName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExtension() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveExtension() {
		fail("Not yet implemented");
	}
	@Test
	public void testRemovePrefix() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsOnSystem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSplit() {
		fail("Not yet implemented");
	}

}

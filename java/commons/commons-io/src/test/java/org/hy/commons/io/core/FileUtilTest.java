package org.hy.commons.io.core;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hamcrest.Matchers;
import org.hy.commons.io.core.FileNameUtil;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.FindFileUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.io.maven.util.MavenUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtilTest {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteFolder() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testCopyFile() throws IOException {
		File src = FileUtil.createFile(ProjectPathUtil.getProjectResourcesDirPath()+"/source.txt");
		File des = FileUtil.createFile(ProjectPathUtil.getProjectResourcesDirPath()+"/destination.txt");
		System.err.println(des.getPath());
		//BufferedWriter writer = IoUtil.getBufferedWriter(src.getPath(), "gbk");
		FileUtil.copyFile(src	, "gbk", des, "utf8");
		
	}
	
	@Test
	public void testCopyFileFileStringFileString() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopyFileStringStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testCopyFileFileFile() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCopyTextFileWithCharConvert() {
		String filePath = FileNameUtil.concat(ProjectPathUtil.getProjectResourcesDirPath(),
				"Snippet.java");
		//FileUtil.createFile(filePath);
		FileUtil.copyTextFileWithCharConvert(filePath, "utf8", 
				FileNameUtil.concat(ProjectPathUtil.getProjectResourcesDirPath(), "Xx.java"),
				"utf8", null);
		//String text = IoUtil.readText(filePath, "utf8");
		//System.err.println(text);
	}

	
	
	
	@Test
	public void testCreateFileFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateFileString() {
		fail("Not yet implemented");
	}


	@Test
	public void testDeleteFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDirectory() {
		fail("Not yet implemented");
	}

	@Test
	public void testExistsFileString() {
		String path = getClass().getClassLoader().getResource("").getFile();
		logger.info(path);
		path=FileNameUtil.filterFilePath(path);
		logger.info(path);
		Boolean flag = FileUtil.existsFile(path);
		assertEquals(true, flag);
		File file = new File(path);
		logger.info(file.getPath());
	}

	@Test
	public void testExistsFileFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindText() {
		String ss ="E:\\Program Files\\eclipse-jee-helios-SR2-win32\\workspace\\commons-lang\\src\\main";
		List<File> list = FindFileUtil.findFiles(ss , "*.java");
		for (File file : list) {
			Boolean boolean1 =FileUtil.containsText(file.getAbsolutePath(), "刘");
			if (boolean1) {
				System.err.println(file.getName());
				
			}
		}
		
	}
	@Test
	public void testFindFilesStringStringListOfFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFilesStringStringStringListOfFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testBlurFindFiles() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetFile_URI() throws URISyntaxException {
		FileUtil.getFile(getClass().getClassLoader().getResource("").toURI());
	}
	@Test
	public void testGetFile_String() {
		FileUtil.getFile(getClass().getClassLoader().getResource("").getFile());
	}

	@Test
	public void testListFiles() {		
	}
	
	@Test
	public void testListFilesFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testListFilesFileBoolean() {
		File[] files = FileUtil.listFiles(MavenUtil.getTestResourcesPath(getClass())
				,true);
		for (File file : files) {
			logger.debug(file.toString());
		}
	}

	@Test
	public void testPrintDir() {

		FileUtil.printDir(new File(
				ProjectPathUtil.getProjectClassPath()
				));
	}

	@Test
	public void testReadPropertyStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadPropertyFileString() {
		fail("Not yet implemented");
	}
	@Test
	public void testReadLines() throws IOException {
		String lines[] =FileUtil.readLines(org.hy.commons.io.path.ProjectPathUtil.getProjectResourcesDirPath()+"/data/zhongwen_utf8.txt","utf8");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
//		lines =FileUtil.readLines(org.hy.commons.io.path.ProjectPathUtil.getProjectResourcesDirPath()+"/data/zhongwen_gbk.txt","gbk");
		lines =FileUtil.readLines("E:\\导师\\java\\ex6_all\\__6_3901140230___1406_3901140230_______6\\软件1406_3901140230_刘馨然_实验6\\Person.java","gbk");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}
	@Test
	public void testReplaceLine() throws IOException {
		FileUtil.replaceLine("d:/1.txt", 0, 5, "package", "", "gbk");
	}
	@Test
	public void testReplaceString() throws IOException {
		FileUtil.replaceString("E:\\导师\\java\\ex6_all\\__6_3901140230___1406_3901140230_______6\\软件1406_3901140230_刘馨然_实验6\\Person.java", 0, 5, "package", "//package", "gbk");
	}

	

}

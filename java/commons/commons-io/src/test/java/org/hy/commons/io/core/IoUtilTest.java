package org.hy.commons.io.core;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.hamcrest.Matchers;
import org.hy.commons.lang.RandomUtil;
import org.hy.commons.lang.character.CharacterUtil;
import org.hy.commons.lang.date.DateUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IoUtilTest {

	Logger logger =LoggerFactory.getLogger(IoUtilTest.class.getClass());

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
	public void testCopyInputStreamToFile() {
		fail("Not yet implemented");
	}



	@Test
	public void testGetProjectName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectPathClassString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectClassPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectClassPathClassString() {
		//ProjectPathUtil测试
	}



	@Test
	public void testFindFiles() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJavaFileDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJavaFilePath() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJarFileLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJarFileDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSystemProperty() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSystemPropertise() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetBufferedReaderStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedReader() throws IOException {
		File filePath = new File("E:\\Program Files\\eclipse-jee-helios-SR2-win32\\workspace\\commons-algorithm\\src\\main\\java\\com\\hy\\commons\\algorithm\\sort\\BubbleSort.java");
		BufferedReader reader =IoUtil.getBufferedReader(filePath.getAbsolutePath(),"utf-8");
		String line =reader.readLine(); 
		while (line!=null) {
			//System.out.println(line);
			System.out.println(new String(line.getBytes("utf-8"),"gbk"));
			line =reader.readLine();
		}
	}
	
	@Test
	public void testGetBufferedReader2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedReaderString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedReaderFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriterStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileOutputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriter() throws IOException {
		//createFile();
		File filePath = new File("d:/3xxx.txt");

		BufferedWriter bufferedWriter =IoUtil.getBufferedWriter(filePath);
		for (int i = 0; i < 5; i++) {
			bufferedWriter.write(UUID.randomUUID().toString());
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	@Test
	public void testGetBufferedWriterString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriterFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriterStringBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriterStringBooleanString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBufferedWriterFileBooleanString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrintWriter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResourceFromJarFile() throws IOException {
		String path = ProjectPathUtil.getJarFileLocation(Logger.class);
		logger.debug(path);
		assertThat(path, Matchers.endsWith(".jar"));
		JarFile file = new JarFile(path);
		JarEntry entry = file.getJarEntry("org/slf4j/MDC.class");
		System.err.println(entry.getName());
		InputStream in = IoUtil.getResourceFromJarFile(Logger.class, "org/slf4j/MDC.class");
		
		InputStreamReader reader = new InputStreamReader(in);
		//BufferedReader bufferedReader = new BufferedReader(reader);
		String string = IoUtil.readText(reader);
		System.err.println(string);
	}

	@Test
	public void testFilterFilePathString() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testPrintInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintBytesLengthString() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintBytesLengthStringString() {
		fail("Not yet implemented");
	}


	

	@Test
	public void testReadToBytes() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadBytes() throws IOException {

		String classPath = ProjectPathUtil.getProjectClassPath();
		String filePath = classPath+"1.txt";
		FileUtil.createFile(filePath);
		byte[] bytes = IoUtil.readBytes(filePath);
		System.err.println(bytes.length);
		
	}
	
	@Test
	public void testReadText_Reader_OneChar() throws IOException {
		InputStream in =getClass().getClassLoader().getResourceAsStream("1.txt");
		String path = ProjectPathUtil.getProjectResourcePath("1.txt");
		//InputStreamReader reader = new InputStreamReader(in);
		BufferedReader reader=IoUtil.getBufferedReader(path, "utf8");
		int integer = reader.read();
		
		System.err.println(integer+"---"+(char)integer);
		System.err.println(Integer.toHexString(integer));
		
		integer = reader.read();
		
		System.err.println(integer+"---"+(char)integer);
		System.err.println(Integer.toHexString(integer));
	}
	

	@Test
	public void testReadText_Reader() {
		InputStream in =getClass().getClassLoader().getResourceAsStream("1.txt");
		
		InputStreamReader reader = new InputStreamReader(in);
		String string = IoUtil.readText(reader);
		System.err.println(string);
	}
	
	
	@Test
	public void testReadText_FilePath_Charset() {

		
		String filePath = ProjectPathUtil.getProjectResourcesDirPath()+"/destination.txt";
		FileUtil.createFile(filePath);
		String text = IoUtil.readText(filePath, "utf8");
		System.err.println(text);
		
	}
	

	@Test
	public void testReadText2() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadTextToBytes() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteBytes() throws UnsupportedEncodingException, IOException {

		
		long t = DateUtil.getCurrentTimeMillis();
		
		String classPath = ProjectPathUtil.getProjectClassPath();
		String filePath = classPath+"1.txt";
		FileUtil.createFile(filePath);
		String string = RandomUtil.getRandomString(300);
		IoUtil.writeBytes(filePath, string.getBytes("utf8"));
		System.err.println(string);
		long t2 = DateUtil.getCurrentTimeMillis();
		
		
		System.err.println(DateUtil.getTimeStr(t2-t));
	}
	
	@Test
	public void testWriteText() {

		
		long t = DateUtil.getCurrentTimeMillis();
		
		String classPath = ProjectPathUtil.getProjectClassPath();
		String filePath = classPath+"1.txt";
		FileUtil.createFile(filePath);
		String string = RandomUtil.getRandomString(300000);
		IoUtil.writeText(filePath,"utf-8", string);
		//System.err.println(string);
		long t2 = DateUtil.getCurrentTimeMillis();
		
		
		System.err.println(DateUtil.getTimeStr(t2-t));
		System.err.println(string.length());
	}



	@Test
	public void testWriteTextWriterString() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteTextStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteTextStringBooleanString() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteTextStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteTextStringStringBooleanString() {
		fail("Not yet implemented");
	}

}

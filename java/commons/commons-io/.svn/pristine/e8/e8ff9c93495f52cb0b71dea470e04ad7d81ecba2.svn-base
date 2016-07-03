package org.hy.commons.io.compress;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import org.hy.commons.io.compress.GZipUtil;
import org.hy.commons.io.core.FileUtil;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.ByteUtil;
import org.hy.commons.lang.RandomUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GZipUtilTest {

	String filePath = null;
	String filePath2 = null;
	String filePath3 = null;
	StringBuilder stringBuilder = new StringBuilder();
	@Before
	public void setUp() throws Exception {
		String resourceDirPath = ProjectPathUtil.getProjectResourcesDirPath();
		filePath = resourceDirPath+"/1.txt";
		filePath2 = resourceDirPath+"/1.zip";
		filePath3 = resourceDirPath+"/3.txt";
		for (int i = 0; i < 100; i++) {
			stringBuilder.append("abcde");
		}
	}
	
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGzipBytes() throws IOException {
		
		File file =FileUtil.createFile(filePath);
//		StringBuffer stringBuffer = new StringBuffer() ;
//		for (int i = 0; i < 10; i++) {
//			stringBuffer.append(RandomUtil.getRandomText(100));
//		}
		//System.err.println(stringBuffer.toString().getBytes().length);
		byte[] bytes = IoUtil.readBytes(filePath);
		System.err.println(bytes.length);
		byte[] bytes2 = IoUtil.readBytes(filePath2);
		System.err.println(bytes2.length);
		System.err.println(bytes2.length);
		String text = IoUtil.readText(filePath2, "utf8");
		byte[] bytes2_2 = GZipUtil.gzipBytes(bytes);
		System.err.println(bytes2_2.length);
		
	}
	
	@Test
	public void testGzipBytesAndUnzipBytes() throws IOException {
		String text = stringBuilder.toString();
		byte[] source  = text.getBytes("utf8");
		byte[] compression = GZipUtil.gzipBytes(source);
		System.err.println(source.length);
		System.err.println(compression.length);
		byte[] unzip =GZipUtil.unzipBytes(compression);
		boolean b = ByteUtil.compareByteArray(source, unzip);
		assertTrue(b);
	}
	
	@Test
	public void testGzipBytesAndGzipText() throws IOException {
		String name = "iso8859-1";
		String text = stringBuilder.toString();
		byte[] source  = text.getBytes(name);
		System.err.println("原"+text.length()+"  "+source.length);
		
		byte[] compression = GZipUtil.gzipBytes(source);
		System.err.println("压1  "+compression.length);

		String string = GZipUtil.gzipText(text, name);
		System.err.println("压2  "+string.length()+"  "+string.getBytes(name).length);
		
		boolean b = ByteUtil.compareByteArray(compression, string.getBytes(name));
		assertTrue(b);
	}
	
	@Test
	public void testGzipFile() throws IOException {
		
		FileUtil.createFile(filePath);
		BufferedWriter writer = IoUtil.getBufferedWriter(filePath);
		StringBuffer stringBuffer = new StringBuffer() ;
		for (int i = 0; i < 10; i++) {
			stringBuffer.append(RandomUtil.getRandomText(100));
		}
		writer.write(stringBuffer.toString());
		writer.close();
		FileUtil.createFile(filePath2);
		GZipUtil.gzipFile(filePath, filePath2);
	}
	
	
	@Test
	public void testUnzipText() throws IOException {
		
//		String text = stringBuilder.toString();
//		byte[] source  = text.getBytes("utf8");
//		byte[] compression = GZipUtil.gzipBytes(source);
//		System.err.println(source.length);
//		System.err.println(compression.length);
//		byte[] unzip =GZipUtil.unzipBytes(compression);
//		boolean b = ByteUtil.compareByteArray(source, unzip);
				
		String string = GZipUtil.gzipText(stringBuilder.toString(), "iso8859-1");
		System.err.println(string.length());
		byte[] compression = GZipUtil.unzipBytes(string.getBytes( "iso8859-1"));
		String string2 = GZipUtil.unzipText(string, "iso8859-1");
		System.err.println(string2.length());
		
	}
	
	@Test
	public void testUnzip2() throws IOException {
				
		
		byte[] bytes = GZipUtil.unzipFile(filePath2);
		System.err.println(bytes.length);
		
	}

	@Test
	public void testUnzip() throws IOException {
				
		FileUtil.createFile(filePath2);
				
		FileUtil.createFile(filePath3);
		//byte[] bytes = GZipUtil.unzipFile(filePath);
		//System.err.println(bytes.length);
		GZipUtil.unzipFile(filePath2, filePath3);
	}

	@Test
	public void testZipDirectory() {
		fail("Not yet implemented");
	}

}

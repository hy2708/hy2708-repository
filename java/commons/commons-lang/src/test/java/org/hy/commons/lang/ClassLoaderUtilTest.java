package org.hy.commons.lang;

import static org.junit.Assert.*;

import java.io.File;

import org.hy.commons.lang.character.CharacterUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassLoaderUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompileString() {
		
		//String charset = CharacterUtil.getFileCharset(path+"\\" +
			//	className+".java");
		
//		FileUtil.replaceLine(path+"\\" +
	//			className+".java", 0, 4, "package", ";", charset);

	
	}

	@Test
	public void testCompileStringString() {
		fail("Not yet implemented");
	}
	
		@Test
		public void testCompileDirStringString() {

		ClassLoaderUtil.compile("E:\\导师\\java\\ex6_all\\__6_3901140230___1406_3901140230_______6\\软件1406_3901140230_刘馨然_实验6","gbk");

	}

	@Test
	public void testDefineClassStringByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompileJavaAndDefineClass() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetDefaultClasspath() {		
		File[] files =ClassLoaderUtil.getDefaultClasspath();
		ClassLoaderUtil.addFileToClassPath(new File("E:\\导师\\java\\ex6_all\\__6_3901140230___1406_3901140230_______6\\软件1406_3901140230_刘馨然_实验6")
		, ClassLoaderUtil.class.getClassLoader());
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}

}

package org.hy.commons.lang.character;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharacterUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDecode() {
		//String s = getClass().getClassLoader().getResource("log4j.properties").getPath();
		String s = "%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9";

		System.err.println(s);;
		String eString =CharacterUtil.decode(s, "utf8");
		System.err.println(eString);
		String eString2 =CharacterUtil.decode(" ", "utf8");
		System.err.println(eString2);
	}

	@Test
	public void testEncode() {
		String s = getClass().getClassLoader().getResource("log4j.properties").getPath();
		//String s = "%E6%8F%90%E4%BA%A4%E6%9F%A5%E8%AF%A2%E5%86%85%E5%AE%B9";
		System.err.println(s);;
		String eString =CharacterUtil.decode(s, "iso8859-1");
		System.err.println(eString);
		String eString2 =CharacterUtil.encode(eString);
		System.err.println(eString2);
	}
	@Test
	public void testGetFileCharset() throws Exception {
		String eString =CharacterUtil.getFileCharset( "d:/1.txt");
		System.out.println(eString);
	}

}

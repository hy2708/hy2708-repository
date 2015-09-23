package org.hy.commons.lang;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.hy.commons.lang.RandomUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRandomCharacter() {
		for (int i = 0; i < 500; i++) {
			String c = RandomUtil.getRandomCharacter();
			if (c.equalsIgnoreCase("9")) {
				System.err.println("==");
			}
		}
		
	}

	@Test
	public void testGetRandomString() {
		String c = RandomUtil.getRandomString(100);
		System.out.println(c);
	}
	
	@Test
	public void testGetRandomText() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextBytes() {
		byte[] bytes = new byte[5000];
		RandomUtil.nextBytes(bytes);
		System.err.println(bytes.length);
		System.err.println(Arrays.toString(bytes));;
	}

	@Test
	public void testNextInt() {
		for (int i = 0; i < 100; i++) {
			System.out.println(RandomUtil.nextInt());
		}
		;
	}

	@Test
	public void testNextIntInt() {
		for (int i = 0; i < 100; i++) {
			System.out.println(RandomUtil.nextInt(2));
		}
	}

	@Test
	public void testNextLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRandomInstance() {
		fail("Not yet implemented");
	}

}

package org.hy.commons.lang.string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-9-16；时间：下午4:09:45</li>
 * <li>类型名称：WildcardUtilTest</li>
 * <li>设计目的：其他测试内容，见WildcardTest.java</li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class WildcardUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHasWildcard() {
		boolean b=  WildcardUtil.hasWildcard("afdaf?sfd?");
		assertEquals(true, b);
	}

	
	@Test
	public void testMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsOrMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchPathOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatchTokens() {
		fail("Not yet implemented");
	}

}

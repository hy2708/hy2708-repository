package org.hy.commons.lang;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeUtilTest {

	private static Logger logger = LoggerFactory
			.getLogger(RuntimeUtilTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecuteCmd() {
		fail("Not yet implemented");
	}

	@Test
	public void testCurrentMethod() {
		logger.info("[{}]",RuntimeUtil.currentMethod());
	}

	@Test
	public void testAvailableMemory() {
		logger.info("[{}]",RuntimeUtil.availableMemory());
	}

	@Test
	public void testAvailableMemoryPercent() {
		logger.info("[{}]",RuntimeUtil.availableMemoryPercent());
	}

	@Test
	public void testCompactMemory() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassLocation() {
		logger.info("[{}]",RuntimeUtil.classLocation(RuntimeUtil.class));
		logger.info("[{}]",RuntimeUtil.classLocation(RuntimeUtilTest.class));

	}

	@Test
	public void testJoddLocation() {
		logger.info("[{}]",RuntimeUtil.joddLocation());
	}

}

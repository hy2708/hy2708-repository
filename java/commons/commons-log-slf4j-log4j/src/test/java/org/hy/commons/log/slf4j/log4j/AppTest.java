package org.hy.commons.log.slf4j.log4j;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	static Logger logger = LoggerFactory.getLogger(AppTest.class);
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.warn("warn {}----{}","xxxx","yyy");
        logger.warn("warn ${0}----${1}","000","1111");
        
        logger.error("error");
    }
}

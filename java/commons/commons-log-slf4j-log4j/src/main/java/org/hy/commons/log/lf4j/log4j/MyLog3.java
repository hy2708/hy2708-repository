package org.hy.commons.log.lf4j.log4j;
import org.apache.log4j.Logger;


public class MyLog3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Logger logger = Logger.getLogger(MyLog3.class);
//		 Logger logger = Logger.getLogger("arsresr");
		
		logger.debug("jj00000000j");
		logger.info("j0000000jj");
		logger.warn("j00000000000jj");
		logger.error("df00000000adsf");
		logger.fatal("j0000000000000jj");

	}

}

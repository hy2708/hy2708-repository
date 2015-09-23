package com.hy.designpatern.dynamicproxy.jdkproxy.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class BusinessObject implements BusinessInterface {
	
	@Override
	public void getMoney() {
		// TODO Auto-generated method stub
		//logger.info("get money .. ...");
		System.out.println(" get money ..........");
	}

	Logger logger = LoggerFactory.getLogger(Object.class);
	
	@Override
	public void doBusiness() {
		//logger.info("begin business ...");
		System.out.println(this.getClass().getSimpleName()+" : do Business ..........");
		//logger.info("end business ....");
	}

}

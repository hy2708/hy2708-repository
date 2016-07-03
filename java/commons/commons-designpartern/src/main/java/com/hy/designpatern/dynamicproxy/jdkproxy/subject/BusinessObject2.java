package com.hy.designpatern.dynamicproxy.jdkproxy.subject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("proxyedObject")
public class BusinessObject2 implements BusinessInterface {
	
	@Override
	public void getMoney() {
		// TODO Auto-generated method stub
		//logger.info("get money .. ...");
		System.out.println(" get money ..........");
	}

	Log logger = LogFactory.getLog(Object.class);
	
	@Override
	public void doBusiness() {
		//logger.info("begin business ...");
		System.out.println(this.getClass().getSimpleName()+" : do Business ..........");
		//logger.info("end business ....");
	}

}

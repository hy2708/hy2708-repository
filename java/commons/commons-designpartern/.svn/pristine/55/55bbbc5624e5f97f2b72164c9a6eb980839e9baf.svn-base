package com.hy.designpatern.dynamicproxy.aopproxy;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.designpatern.dynamicproxy.jdkproxy.subject.BusinessInterface;

@SuppressWarnings({"unchecked"})
public class HelloEhcacheSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BusinessInterface personManager = (BusinessInterface) context.getBean("proxyObject");
		
		personManager.doBusiness();
	}
	
}

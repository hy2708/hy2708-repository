package org.hy.commons.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hy.commons.lang.ByteUtil;
import org.hy.commons.lang.character.CharacterUtil;
import org.hy.commons.lang.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetUtil {
	private static Logger logger = LoggerFactory.getLogger(NetUtil.class);

	public static void main(String[] args) throws Exception {
		//NetUtil.getLocalIP();
		//NetUtil.getRemoteIP(null);
		NetUtil.isReachable(null);
	}
	
	public static String getLocalIP() throws UnknownHostException {
		InetAddress locAdd = InetAddress.getLocalHost();
		logger.debug("本机IP= {}" , locAdd.getHostAddress());
		return locAdd.getHostAddress();
		 
		
	}
	
	public static String getRemoteIP(String domainName) throws IOException {
		//InetAddress locAdd = InetAddress.getLocalHost();
		if (StringUtil.isEmpty(domainName)) {
			domainName="www.baidu.com";
		}
		InetAddress remAdd = 	InetAddress.getByName(domainName);
		logger.debug("远程IP= {}" , remAdd.getHostAddress());
		
		byte[] ip= {(byte) 211,100,52,39}; 
		InetAddress remAdd2 = InetAddress.getByAddress(ip);
		//System.out.println("本机IP= " + locAdd.getHostAddress());
		
		System.out.println("是否可以送达：" + 	remAdd2.isReachable(3000));
		return remAdd.getHostAddress();
	}
	
	public static Boolean isReachable(String domainName) throws IOException {
		//InetAddress locAdd = InetAddress.getLocalHost();
		String remIP =getRemoteIP(domainName);
		String[] strings =remIP.split(",");
		byte[] ip=remIP.trim().getBytes();
		//byte[] ip= {(byte) 211,100,52,39}; 
		InetAddress remAdd2 = InetAddress.getByAddress(ip);
		//System.out.println("本机IP= " + locAdd.getHostAddress());
		Boolean flag =remAdd2.isReachable(3000);
		System.out.println("是否可以送达：" + 	flag);
		return flag;
	}

}

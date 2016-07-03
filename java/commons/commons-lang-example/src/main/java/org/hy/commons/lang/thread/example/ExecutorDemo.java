package org.hy.commons.lang.thread.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Yield y = new Yield();
		executorService.execute(new Thread(y,"     老大"));
		executorService.execute(new Thread(y,"小三"));
		executorService.shutdown();
	}
	
	
}

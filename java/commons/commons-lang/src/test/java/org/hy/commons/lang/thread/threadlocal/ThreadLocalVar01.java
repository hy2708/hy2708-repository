package org.hy.commons.lang.thread.threadlocal;

public class ThreadLocalVar01 {

	private static ThreadLocal<String> tl = new ThreadLocal<String>();

	public static String getTl() {
		if (tl.get()==null) {
			setTl("default01");
		}
		return tl.get();
	}

	public static void setTl(String tl) {
		ThreadLocalVar01.tl.set( tl);
	}
}

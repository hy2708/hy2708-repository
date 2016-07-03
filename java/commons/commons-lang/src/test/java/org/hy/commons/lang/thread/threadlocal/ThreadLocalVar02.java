package org.hy.commons.lang.thread.threadlocal;

public class ThreadLocalVar02 {

	private static ThreadLocal<String> tl = new ThreadLocal<String>();

	public static String getTl() {
		if (tl.get()==null) {
			setTl("default02");
		}
		return tl.get();
	}

	public static void setTl(String tl) {
		ThreadLocalVar02.tl.set( tl);
	}
}

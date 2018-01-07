package com.hy.commons.xuanzeti;

public class Return_Finally {

	public static void main(String[] args) {

		//name();
		System.out.println(name2());

	}
	
	public static void name() {
		try {
			return;
		} finally {
			System.out.println("fffffffff");
		}
	}

	public static String name2() {
		try {
			return "rrr";
		} finally {
			System.out.println("fffffffff");
		}
	}
}

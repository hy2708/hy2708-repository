package com.hy.designpatern.threadsafety;

public class SafetySinglton {
	
	private static SafetySinglton instance =null;

	private SafetySinglton() {
		// TODO Auto-generated constructor stub
	}
	public static SafetySinglton getinstance() {

	       if (instance == null) {

	           instance = new SafetySinglton();

	       }

	       return instance;

	    }
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println(getinstance());
		}
	}

}

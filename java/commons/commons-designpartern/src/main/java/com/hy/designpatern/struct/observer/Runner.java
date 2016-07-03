package com.hy.designpatern.struct.observer;

public class Runner {
	
	public void run() {
		System.err.println("run............");
		new RunEvent().setSource(this);
	}
	
	public RunEvent getEvent() {
		// TODO Auto-generated method stub
		return null;
	}

}

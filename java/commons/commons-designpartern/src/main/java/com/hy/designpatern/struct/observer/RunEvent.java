package com.hy.designpatern.struct.observer;

public class RunEvent {

	Object source = null;
	public void setSource(Object source) {
		this.source = source;
	}

	public Object getSource() {
		
		return null;
	}
	RunListener listener = null;
	public void setListener(RunListener listener) {
		this.listener = listener;
	}

	public Object getListener() {
		
		return null;
	}
}

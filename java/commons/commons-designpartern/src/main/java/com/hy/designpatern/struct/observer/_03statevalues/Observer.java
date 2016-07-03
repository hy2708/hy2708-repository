package com.hy.designpatern.struct.observer._03statevalues;

public class Observer {

	public Observer(int stateLevel) {
		super();
		this.stateLevel = stateLevel;
	}

	int stateLevel=0;
	
	public void update(Subject subject) {
		System.out.println(this.toString()+"  "+stateLevel);
	}
	
	public void setStateLevel(int stateLevel) {
		this.stateLevel = stateLevel;
	}

	public Integer getStateLevel() {
		// TODO Auto-generated method stub
		return stateLevel;
	}

}

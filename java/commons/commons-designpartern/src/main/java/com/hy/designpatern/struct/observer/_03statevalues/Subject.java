package com.hy.designpatern.struct.observer._03statevalues;

import java.util.LinkedList;
import java.util.List;


/*
 * 一种状态，多个值
 */
public class Subject {

	int state=0;
	List<Observer> list=new LinkedList<Observer>();

	public void changeState(int state) {
		this.state=state;
		notifyObservers(this);
	}
	
	public void notifyObservers(Subject subject) {
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			if (state >= list.get(i).getStateLevel()) {
				list.get(i).update(subject);
			};
		}
	}

	public void addObserver(Observer o) {
		list.add(o);
	}

}

package com.hy.designpatern.struct.observer._01state;

import java.util.Observable;

public class Subject extends Observable{


	public void changeState() {
		setChanged();
		notifyObservers();
	}
}

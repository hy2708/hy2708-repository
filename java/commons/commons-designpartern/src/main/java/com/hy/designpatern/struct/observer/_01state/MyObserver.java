package com.hy.designpatern.struct.observer._01state;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(o+"做出了响应");
	}

}

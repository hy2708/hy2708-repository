package com.hy.designpatern.struct.observer._05liandongstates;

import com.hy.designpatern.struct.observer._04states.Event;
import com.hy.designpatern.struct.observer._04states.Handler;

public class GuojiaHandler implements Handler{

	@Override
	public void handle(Event event) {
		ShengSource shengSource = new ShengSource();
		System.out.println("我根据国家名称，查询省的列表");
		ShengEvent shengEvent=new ShengEvent();
		shengSource.addEvent(shengEvent);
		shengEvent.addHandler(null);
	}

}

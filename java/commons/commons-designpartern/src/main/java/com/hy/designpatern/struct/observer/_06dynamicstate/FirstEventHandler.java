package com.hy.designpatern.struct.observer._06dynamicstate;

public class FirstEventHandler implements Handler{

	@Override
	public void handle(Event event) {
		System.out.println("handle event[" +
				event.getClass().getSimpleName()+"],eventsource[" +
						event.getSource()+"]");
		
	}

}

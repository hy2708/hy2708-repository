package com.hy.designpatern.struct.observer._04states;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Observed {
	List<Event> events = new ArrayList<Event>();
	Subject subject  =new Subject();
	FirstEvent oneEvent  =new FirstEvent();
	private void triggeEvent01() {
		subject.happen(this);

	}

	private void triggeEvent02() {
		oneEvent.happen(this);

	}

	
	public void addListener(Handler handler) {
		subject.addHandler(handler);

	}
	
	public void addHandler(Handler handler) {
		subject.addHandler(handler);

	}
	
	public void addHandler(Event event ,Handler handler) {
		if (events.size()>0) {
			for(Event event2 : events){
				if (!event2.getEventId().equals(event.getEventId())) {
					events.add(event);					
				}
			}
		}else {
			events.add(event);
		}
		event.addHandler(handler);

	}
	
	@Test
	public void ss(){
		System.err.println(Integer.valueOf(1).equals(new Integer(1)));;
	}

}

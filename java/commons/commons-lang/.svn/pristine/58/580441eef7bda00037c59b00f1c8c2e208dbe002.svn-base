package org.hy.commons.lang.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.hy.commons.lang.date.DateUtil;

public class TimerUtil {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar calendar =DateUtil.getCalendar(new Date());
		DateUtil.updateCalendar(calendar, Calendar.SECOND, 1);
		timer.schedule(new TimerTaskE(), 1000,1000);
		
		timer.cancel();
	}
}

class TimerTaskE extends TimerTask{

	@Override
	public void run() {
		System.err.println("0000000000");
		
	}
	
}
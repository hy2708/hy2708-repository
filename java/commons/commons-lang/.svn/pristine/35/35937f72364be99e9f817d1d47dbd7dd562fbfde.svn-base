package org.hy.commons.lang.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Tes{ 
 public static void main(String[] args) {   
	 Timer t = new Timer();   Date date = new Date(); 
   date.setHours(8); 
  //1.特定时间运行,注意，这里不能每天都执行，你要根据实际情况做修改   t.schedule(new MyTask(), date);   date.setHours(12); 
  t.schedule(new MyTask(), date);   date.setHours(14); 
  t.schedule(new MyTask(), date); 
  //2.间隔一定时间段运行一次,这里是每5秒   t.schedule(new MyTask(), date, 5000);    } } 
 }
}
/*
 * imer timer = new Timer();  
timer.schedule(new MyTask(), firstTime, 24*60*60*1000L)；  timer.schedule(new MyTask(), secondTime,24*60*60*1000L)；
 */
class MyTask2 extends TimerTask {  public void run() { 
	  System.out.println("run！");  }  
	}
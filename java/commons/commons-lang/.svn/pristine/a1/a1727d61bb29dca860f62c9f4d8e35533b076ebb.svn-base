package org.hy.commons.lang.timer;

import java.util.Random;
import java.util.TimerTask;

/**
 * 定时任务的模板例子： * 
 * 要使用定时任务只需要：
 *  1.写一个类继承TimerTask,把要做的任务写到run方法里 
 *  2.按照需求调用不同的构造方法
 * 3.方法要求写继承了TimerTask的子类全路径名(包名+类名) *
 * 
 * @author uwaysoft weisy 时间：2009年4月20日16:36:14
 */
public class MyTask extends TimerTask {
	public void run() {
		// TODO: write you task here
		System.out.println("----正在执行定时任务 编号=" + new Random().nextInt(10000));
	}

	public static void main(String[] args) {
		// 如：从５.１开始每天早上８：30给员工发信息 一直发送
		// OpenTask openTask = new OpenTask("2009-05-01 08:30:00", true, 10,
		// 24*60*60*1000);
		// 如：从5.1开始每天早上8：30给员工发信息 连续发送一周
		OpenTask openTask = new OpenTask("2009-04-21 08:58:00", false, 10, 1000);
		// 如：5.1早上8：30给员工发信息 只发送一次
		// OpenTask openTask = new OpenTask("2009-05-01 08:30:00", false, 1,
		// 1000);
		// 如：从5.1开始每天早上8：30给员工发信息 每隔2小时发送一次 总共发送5次
		// OpenTask openTask = new OpenTask("2009-05-01 08:30:00", false, 1,
		// 2*60*60*1000);
		// ***************错误的参数*************
		// OpenTask openTask = new OpenTask("2009-05-01 08:30:00", false, 0,
		// 2*60*60*1000); //OpenTask openTask = new
		// OpenTask("2009-05-01 08:30:00", false, 2, -2*60*60*1000);
		// //************************************
		openTask.openTimerTask("com.ab.oa.timer.MyTask");
	}
}
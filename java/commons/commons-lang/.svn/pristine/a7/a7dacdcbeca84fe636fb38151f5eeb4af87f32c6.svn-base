package org.hy.commons.lang.timer;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * *
 * 
 * @author uwaysoft 魏韶颖 时间：2009年4月20日15:02:58
 */
public class TimerTaskProxy extends TimerTask {
	Logger logger = LoggerFactory.getLogger(TimerTaskProxy.class);
	private int count;
	private Timer timer;
	private int hasExeNum = 0;
	private TimerTask timerTask;

	/**
	 * 定时任务代理 调用客户写的子类run方法 
	 * @param subClassName 子类名
	 * @param count 执行多少次 
	 * @param
	 * timer 定时器
	 */
	public TimerTaskProxy(String subClassName, int count, Timer timer) {
		super();
		this.count = count;
		this.timer = timer;
		try {
			this.timerTask = (TimerTask) Class.forName(subClassName)
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		/**
		 * 运用了多态 条件：继承,重写,父类引用指向子类对象 所以调用的是子类的run()
		 */
		timerTask.run();
		hasExeNum++;
		if (count == hasExeNum) {
			timer.cancel();
			logger.info("定时任务执行完毕，线程成功终止！");
		}
	}
}

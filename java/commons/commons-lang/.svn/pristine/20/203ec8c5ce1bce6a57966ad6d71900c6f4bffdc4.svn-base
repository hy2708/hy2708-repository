package org.hy.commons.lang.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * <ul>
 * <li>开发作者：花宏宇</li>
 * <li>设计日期：2014-2-2；时间：下午3:58:52</li>
 * <li>类型名称：OpenTask</li>
 * <li>设计目的：开启定时任务：可以指定执行多少次，是否一直执行，执行的频率 </li>
 * </ul>
 * <ul>
 * <b>修订编号：</b>
 * <li>修订日期：</li>
 * <li>修订作者：</li>
 * <li>修订原因：</li>
 * <li>修订内容：</li>
 * </ul>
 */
public class OpenTask {
	
	/**   *  
	  * @param beginTime 任务第一次开始执行时间 格式如：2009-09-01 08:30:00 
	  * @param exeForEver 此定时任务是否一直执行，如果为true 参数exeNum将忽略   * @param exeNum 任务总共执行多少次数 如果=1后 参数period可随意 
	  * @param period 每隔多长时间执行一次 单位毫秒如：24*60*60*1000 就是一天
	*/
	public OpenTask(String beginTime, boolean exeForEver,
			int exeNum, long period) {
		super();
		//this.timer = timer;
		this.beginTime = beginTime;
		this.exeForEver = exeForEver;
		this.exeNum = exeNum;
		this.period = period;
	}
	public OpenTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	static Logger logger = LoggerFactory.getLogger(OpenTask.class);
	Timer timer = new Timer();
	String beginTime;
	boolean exeForEver;
	int exeNum;
	long period;
	public static void main(String[] args) {
		
	}
	
	/**
	 * 
	 * 
	 * <ul>
	 * <li>方法含义：openTimerTask</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-2-2；时间：下午10:25:09</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param subClassName
	 * @return
	 */
	public void openTimerTask(String subClassName) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this.beginTime);
			if (exeForEver) {
				if (period<1) {
					logger.info("错误的执行周期！周期 = "+period+"毫秒");
					return;
				}else {
					TimerTask timerTask = (TimerTask) Class.forName(subClassName).newInstance();
					//System.out.println("--period = " + period + "毫秒");      timer.scheduleAtFixedRate(timerTask, date, period);       //区别在于如果超时会补上任务 
					//timer.schedule(timerTask, date, period); 
					logger.info("定时任务监控线程已成功启动...执行类型：一直执行！");
				}
				
				
			}else{
				if(exeNum<1){
					logger.info("执行次数<1,定时任务不会执行！");
					return;
				}else{
					//     TimerTask timerTask = (TimerTask) Class.forName(subClassName).newInstance(); //     if(exeNum == 1) { 
					//      timer.scheduleAtFixedRate(new TimerTaskProxy(subClassName,exeNum,timer), date, period);   //      logger.info("定时任务已经成功启动...执行次数1次"); //     }else { 
					//      timer.scheduleAtFixedRate(new TimerTaskProxy(subClassName,exeNum,timer), date, period);  //      logger.info("定时任务已经成功启动...执行次数" + exeNum + "次");  //     } 
					timer.schedule(new TimerTaskProxy(subClassName,exeNum,timer),date,period);

					logger.info("定时任务监控线程已经成功启动...预计执行次数"+exeNum+"次");
				 }
			}

		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

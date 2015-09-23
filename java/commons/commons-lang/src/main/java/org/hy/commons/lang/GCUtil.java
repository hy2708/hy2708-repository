/************************************************************************
 * <br>
 * <ul>
 * <li>版权所有：唐山弘川科技有限公司 2009－2020</li>
 * <li>创建日期：2009-8-12</li>
 * <li>初始作者：花宏宇</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 ***********************************************************************/
package org.hy.commons.lang ;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <ul>
 * <li>设计作者：花宏宇</li>
 * <li>设计日期：2009-8-12</li>
 * <li>设计时间：下午09:48:51</li>
 * <li>设计目的：垃圾收集器助手类</li>
 * </ul>
 * <ul>
 * <b>修订历史</b>
 * <li>1、</li>
 * </ul>
 */
public class GCUtil
{
	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:51:44</li>
	 * <li>设计目的：垃圾回收任务</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 */
	@ SuppressWarnings ( "unused" )
	private class GCTask extends TimerTask
	{

		private GCTask	instance	=
		                              null ;

		/**
		 * <ul>
		 * <li>设计作者：花宏宇</li>
		 * <li>设计日期：2009-8-12</li>
		 * <li>设计时间：下午09:51:31</li>
		 * <li>设计目的：获取垃圾收集器实例</li>
		 * </ul>
		 * <ul>
		 * <b>修订历史</b>
		 * <li>1、</li>
		 * </ul>
		 * 
		 * @return
		 */
		private synchronized GCTask getInstance ( )
		{
			if ( this.instance == null )
			{
				this.instance =
				                new GCTask ( ) ;
			}
			return this.instance ;
		}

		/**
		 * <ul>
		 * <li>设计作者：花宏宇</li>
		 * <li>设计日期：2009-8-12</li>
		 * <li>设计时间：下午09:50:39</li>
		 * <li>设计目的：执行任务</li>
		 * </ul>
		 * <ul>
		 * <b>修订历史</b>
		 * <li>1、</li>
		 * </ul>
		 */
		@ Override
		public void run ( )
		{
			GCUtil
			      .gcNow ( ) ;
		}

		/**
		 * <ul>
		 * <li>设计作者：花宏宇</li>
		 * <li>设计日期：2009-8-12</li>
		 * <li>设计时间：下午09:51:20</li>
		 * <li>设计目的：调度垃圾回收方法</li>
		 * </ul>
		 * <ul>
		 * <b>修订历史</b>
		 * <li>1、</li>
		 * </ul>
		 * 
		 * @param interval
		 */
		public void scheduleGC (
		                         long interval )
		{
			if ( ! GCUtil.this.done )
			{
				GCTask gcTask =
				                this
				                    .getInstance ( ) ;
				Timer timer =
				              new Timer ( ) ;
				timer
				     .scheduleAtFixedRate (
				                            gcTask ,
				                            10 ,
				                            interval ) ;
				GCUtil.this.done =
				                   true ;
			}
			else
			{
				System.err
				          .println ( "垃圾回收任务已经调度" ) ;
			}
		}

	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:50:15</li>
	 * <li>设计目的：调用系统的垃圾回收方法</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 */
	public static void gcNow ( )
	{
		System
		      .gc ( ) ;
	}

	/**
	 * <ul>
	 * <li>设计作者：花宏宇</li>
	 * <li>设计日期：2009-8-12</li>
	 * <li>设计时间：下午09:49:51</li>
	 * <li>设计目的：清空指定对象</li>
	 * </ul>
	 * <ul>
	 * <b>修订历史</b>
	 * <li>1、</li>
	 * </ul>
	 * 
	 * @param object
	 */
	public static void nullify (
	                             Object object )
	{
		object =
		         null ;
	}

	private boolean	done	=
	                          false ;

	/**
	 * 构造函数
	 */
	private GCUtil ( )
	{
		super ( ) ;
	}
}

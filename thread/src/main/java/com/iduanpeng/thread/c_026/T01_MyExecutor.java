/**
 * ��ʶExecutor
 */
package com.iduanpeng.thread.c_026;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class T01_MyExecutor implements Executor {

	public static void main(String[] args) {
		//new T01_MyExecutor().execute(()->System.out.println("hello executor"));
		//线程池参数 1.corePoolSize 核心线程数 2.maximumPoolSize 最大线程数 3.keepAliveTime 非核心线程数存活时间 4.单位 5.任务存放队列
		/**
		 * 任务到来之后 先判断当前线程数 是否大于核心线程数 < 创建核心线程 > 放入队列 如果队列满了  创建非核心线程数
		 *
		 * 所以参数配置上 注意 如果配置的是无界队列，那永远不会创建非核心线程
		 */

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < 10 ;i++){
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						TimeUnit.MILLISECONDS.sleep(5000);
						System.out.println("---------");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}


	}

	@Override
	public void execute(Runnable command) {
		//new Thread(command).run();
		command.run();
	}

}


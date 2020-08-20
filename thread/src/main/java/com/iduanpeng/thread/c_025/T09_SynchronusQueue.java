package com.iduanpeng.thread.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T09_SynchronusQueue { //容量为0
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();

		new Thread(()->{
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		strs.put("aaa"); //阻塞等待消费者消费
		//strs.add("aaa");//不能调用add（报错）  只能调用put阻塞 等待消费
		System.out.println(strs.size());
	}
}

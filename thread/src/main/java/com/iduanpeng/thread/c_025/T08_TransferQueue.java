package com.iduanpeng.thread.c_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		
		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/
		
		strs.transfer("aaa");//找不到消费者的话 会阻塞在这里
		
		//strs.put("aaa");
		

		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		//strs.transfer("aaa");//先启动消费者 后启动生产者 不阻塞
	}
}

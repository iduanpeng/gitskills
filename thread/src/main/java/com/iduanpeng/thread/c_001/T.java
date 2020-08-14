/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package com.iduanpeng.thread.c_001;

public class T {
	
	private int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { //任何线程要运行，必须要拿到o的锁
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
}


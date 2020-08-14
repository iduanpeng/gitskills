/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package com.iduanpeng.thread.c_004;

public class T {

	private static int count = 10;
	
	public synchronized static void m() { //静态方法 这里等同于synchronized(yxxy.c_004.T.class)
		count--;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void mm() {
		synchronized(T.class) { //考虑一下这里写synchronized(this)是否可以？   不可以 静态方法不可以锁定this
			count --;
		}
	}

}

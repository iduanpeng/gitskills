/**
 * synchronized�ؼ���
 * ��ĳ���������
 * @author mashibing
 */

package com.iduanpeng.thread.c_002;

public class T {
	
	private int count = 10;
	
	public void m() {
		synchronized(this) { //任何线程要执行下面的代码 必须获得this锁
			count--;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
	
}


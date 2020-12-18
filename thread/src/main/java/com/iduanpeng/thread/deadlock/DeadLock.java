package com.iduanpeng.thread.deadlock;

public class DeadLock {

    private Object a = new Object();

    private Object b = new Object();

    public void funA(){
        synchronized (a){
            try {
                Thread.sleep(1000);
                System.out.println("funA 获得A锁");
                synchronized (b){
                    System.out.println("funA 获得B锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void funB(){
        synchronized (b){
            try {
                Thread.sleep(1000);
                System.out.println("funB 获得B锁");
                synchronized (a){
                    System.out.println("funB 获得A锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DeadLock a = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.funA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.funB();
            }
        }).start();
    }
}

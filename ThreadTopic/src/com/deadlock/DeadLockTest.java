package com.deadlock;

public class DeadLockTest {
	public static void main(String[] args){
		new Thread(new DeadLock(true)).start();
		new Thread(new DeadLock(false)).start();
	}
}

class MyLock{
	static Object locka = new Object();
	static Object lockb = new Object();
}

class DeadLock implements Runnable{
	private boolean flag = false;
	public DeadLock(boolean flag){
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if(flag){
			synchronized (MyLock.locka) {
				System.out.println("if..locka");
				synchronized (MyLock.lockb) {
					System.out.println("if..lockb");
				}
			}
		}else {
			synchronized (MyLock.lockb) {
				System.out.println("else..lockb");
				synchronized (MyLock.locka) {
					System.out.println("else..locka");
				}
			}
		}
	}
}
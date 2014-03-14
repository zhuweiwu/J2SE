package com.interrupt;

public class InterruptThreadTest {
	public static void main(String[] args){
		StopThread st = new StopThread();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.start();
		t2.start();
		
		
		int num = 0;
		
		while(true){
			if(num++ == 60){
				//st.changeFlag();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"......"+ num);

		}
		
		System.out.println("over");
	}
}

class StopThread implements Runnable{
	private boolean flag = true;
	
	@Override
	public synchronized void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(Thread.currentThread().getName()
						+ "....Exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName() + "...run");
		}
	}
	
	public void changeFlag(){
		this.flag = false;
	}
}
package com.join;

public class JoinTest {
	public static void main(String[] args) throws InterruptedException{
		Demo demo = new Demo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		
		t1.start();
		//t1.join();//t1要执行权，因为t2还没开始，所以只需要主线程让出执行权
		t2.start();
		t1.join();//t1要执行权，主线程让出，但是t1和t2两者继续抢执行权
		for(int i=0; i<80; i++){
			System.out.println("main....." + i);
		}
		
		System.out.println("over");
	}
}

class Demo implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<70; i++){
			System.out.println(Thread.currentThread().getName()+"....."+ i);
		}
	}
}
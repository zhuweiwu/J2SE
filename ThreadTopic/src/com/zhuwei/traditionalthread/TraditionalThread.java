package com.zhuwei.traditionalthread;

public class TraditionalThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		//thread1	
			
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread1.start();
		
		//thread2
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		});
		thread2.start();
		

	}

}

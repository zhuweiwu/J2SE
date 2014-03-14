package com.zhuwei.traditionalthread;

public class MultiThreadShareData {
	
	public static void main(String[] args){
		ShareData1 data1 = new ShareData1();
		new Thread(data1).start();
		new Thread(data1).start();
		
	}
	
}

class ShareData1 implements Runnable{
	private int count = 100;
	private boolean flag = true;
	private Object obj = new Object();
	@Override
	public void run() {

		while(flag){
			synchronized (obj) {
				if(count>0){
					try {
						System.out.println("Thank you! You buy one ticket----Current Count: " +(--count));
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					flag = false;
				}
				
			}
		}
	}
	
}
package com.zhuwei.traditionalthread;

public class MultiThreadShareData2 {
	
	private int j = 0;
	
	public static void main(String[] args){
		MultiThreadShareData2 test = new MultiThreadShareData2();
		
		Inc inc = test.new Inc();
		Dec dec = test.new Dec();
		
		for (int i = 0; i < 5; i++) {
			new Thread(inc).start();
			new Thread(dec).start();
		}	
	}
	
	public synchronized void decrease(){
		j--;
		System.out.println("current j: " + j);
	}
	
	public synchronized void increase(){
		j++;
		System.out.println("current j: " + j);
	}
	
	class Inc implements Runnable{
		@Override
		public void run() {
			for(int i=0; i<10; i++){
				increase();
			}
		}
	}
	
	class Dec implements Runnable{
		@Override
		public void run() {
			for(int i=0; i<10; i++){
				decrease();
			}
		}
	}
}


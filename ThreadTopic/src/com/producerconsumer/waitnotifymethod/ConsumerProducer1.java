package com.producerconsumer.waitnotifymethod;

import java.util.LinkedList;

public class ConsumerProducer1 {
	private LinkedList<Object> objs = new LinkedList<Object>();
	private final int MAX = 10;
	
	public static void main(String[] args){
		ConsumerProducer1 c = new ConsumerProducer1();
		Producer producer = c.new Producer();
		Consumer consumer = c.new Consumer();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(consumer).start();
		
	}
	
	public void produce(Object obj){
		synchronized (this) {
			while (objs.size() == MAX) {
				System.out.println("It is full.");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			objs.add(obj);
			System.out.println("Produce: " + obj);
			notify();
		}
	}
	
	public void comsume(){
		synchronized (this) {
			while (objs.size() == 0) {
				System.out.println("It is empty.");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Object obj = objs.removeLast();
			System.out.println("Consumer:" + obj);
			notify();
		}
	}
	
	class Producer implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object obj = new Object();
				produce(obj);
			}
		}
	}

	class Consumer implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comsume();
			}
		}
	}
}

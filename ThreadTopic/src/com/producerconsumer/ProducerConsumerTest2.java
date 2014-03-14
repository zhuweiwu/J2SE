package com.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerTest2 {
	public static void main(String[] args){
		Resource2 resource = new Resource2();
		
		Producer2 producer = new Producer2(resource);
		Consumer2 consumer = new Consumer2(resource);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(producer).start();
	}
}


class Resource2{
	private String name;
	private int count = 1;
	private boolean flag = false;
	private Lock lock = new ReentrantLock();
	//private Condition condition = lock.newCondition();
	private Condition proCondition = lock.newCondition();
	private Condition conCondition = lock.newCondition();
	
	public void set(String name){
		lock.lock();
		try {
			while(flag){
				proCondition.await();//线程等待
			}
			this.name = name+"--"+count++;
			System.out.println(Thread.currentThread().getName()+"...Producer.."+ this.name);
			flag = true;
			conCondition.signal();//线程唤醒
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}		
	}
	
	public void out(){
		lock.lock();
		try {
			while(!flag){
				conCondition.await();
			}
			System.out.println(Thread.currentThread().getName()+"...Consumer.."+this.name);
			flag = false;
			proCondition.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}

class Producer2 implements Runnable{
	private Resource2 resource;
	
	public Producer2(Resource2 resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true){
			resource.set("Producer--");
		}
	}
}

class Consumer2 implements Runnable{
	private Resource2 resource;
	
	public Consumer2(Resource2 resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true){
			resource.out();
		}
	}
	
	
}
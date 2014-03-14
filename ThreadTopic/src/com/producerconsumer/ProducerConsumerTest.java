package com.producerconsumer;

public class ProducerConsumerTest {
	public static void main(String[] args){
		Resource resource = new Resource();
		
		Producer producer = new Producer(resource);
		Consumer consumer = new Consumer(resource);
		
		new Thread(producer).start();
		new Thread(consumer).start();
		new Thread(consumer).start();
		new Thread(producer).start();
	}
}


class Resource{
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	public synchronized void set(String name){
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name+"--"+count++;
		System.out.println(Thread.currentThread().getName()+"...Producer.."+ this.name);
		flag = true;
		this.notifyAll();
	}
	
	public synchronized void out(){
		while(!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"...Consumer.."+this.name);
		flag = false;
		this.notifyAll();
	}
}

class Producer implements Runnable{
	private Resource resource;
	
	public Producer(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true){
			resource.set("Producer--");
		}
	}
}

class Consumer implements Runnable{
	private Resource resource;
	
	public Consumer(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true){
			resource.out();
		}
	}
	
	
}
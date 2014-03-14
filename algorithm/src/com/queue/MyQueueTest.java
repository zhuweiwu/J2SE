package com.queue;

public class MyQueueTest {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>(10, Integer.class);
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		queue.insert(40);
		
		while(!queue.isEmpty()){
			System.out.print(queue.remove());
			System.out.print(" ");
		}
	}
}

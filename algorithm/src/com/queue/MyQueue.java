package com.queue;

import java.lang.reflect.Array;

/**
 * 
 * @author zhuwei wu
 * 2014-2-23
 */
public class MyQueue<T> {
	Class<T> type; //type of queue
	private int maxSize; //queue max size
	private T[] queueArray; //queue array
	private int front; //front pointer
	private int rear; // rear pointer
	private int nItems; //queue current size
	
	@SuppressWarnings("unchecked")
	public MyQueue(int maxSize, Class<T> type) {
		this.maxSize = maxSize;
		this.type = type;
		queueArray = (T[]) Array.newInstance(type, maxSize);
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	
	public void insert(T val){
		if(rear == maxSize-1){
			rear = -1;
		}
		queueArray[++rear] = val;
		nItems++;
	}
	
	public T remove(){
		T temp = queueArray[front++];
		if(front == maxSize){
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public T peekFront(){
		return queueArray[front];
	}
	
	public boolean isEmpty(){
		return nItems==0;
	}
	
	public boolean isFull(){
		return nItems==maxSize;
	}
	
	public int size(){
		return nItems;
	}
}

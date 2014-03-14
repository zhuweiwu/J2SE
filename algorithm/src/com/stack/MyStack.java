package com.stack;

import java.lang.reflect.Array;
/**
 * implement a stack
 * 
 * @author AD
 * 2014-2-21
 * @param <T>
 */
public class MyStack<T> {
	Class<T> type;
	private int maxSize;
	private T[] stackArray;
	private int top;
	
	@SuppressWarnings("unchecked")
	public MyStack(int maxSize, Class<T> type) {
		this.maxSize = maxSize;
		this.type = type;
		stackArray =(T[]) Array.newInstance(type, maxSize);
		top = -1;
	}
	
	public void push(T val){
		stackArray[++top] = val;
	}
	
	public T pop(){
		return stackArray[top--];
	}
	
	public T peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == maxSize);
	}
}

package com.stack;


public class MyStackTest {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<Integer>(5, Integer.class);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
			System.out.print(" ");
		}
		System.out.println();
	}
}

package com.solution;
import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * @author AD
 * 2014-2-24
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens){
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<tokens.length; i++){
			if(tokens[i].equals("+")){
				int val = Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop());
				stack.push(""+val);
			}else if (tokens[i].equals("-")) {
				int val = -Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop());
				stack.push(""+val);
			}else if (tokens[i].equals("*")) {
				int val = Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop());
				stack.push(""+val);
			}else if (tokens[i].equals("/")){
				int v1,v2,val;
				try {
					v1 = Integer.valueOf(stack.pop());
					v2 = Integer.valueOf(stack.pop());
					val = v2/v1;
					stack.push(""+val);
				} catch (ArithmeticException e) {
					return Integer.MAX_VALUE;
				}
				
			}else{
				stack.push(tokens[i]);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}

package com.parsingarithmrticexpressions;

import java.util.Stack;

public class PostfixConversion {
	private Stack<Character> stack = new Stack<Character>();
	private String input;
	private String output="";
	
	public PostfixConversion(String input){
		this.input = input;
	}
	
	public String doTrans(){
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j);
			switch (ch) {
			case '+':
				
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;

			default:
				output = output + ch;
				break;
			}
		}
		
		while(!stack.isEmpty()){
			output = output + stack.pop();
		}
		return output;
	}
	
	public void gotOper(char opThis, int prec1){
		while(!stack.isEmpty()){
			char opTop = (char) stack.pop();
			if(opTop == '('){
				stack.push(opTop);
				break;
			}else {
				int prec2;
				if(opTop == '-' || opTop == '+'){
					prec2 = 1;
				}else {
					prec2 = 2;
				}
				if(prec2 < prec1){
					stack.push(opTop);
					break;
				}else {
					output = output + opTop;
				}
				
			}
		}
		stack.push(opThis);
	}
	
	public void gotParen(char ch){
		while(!stack.isEmpty()){
			char chx = (char) stack.pop();
			if(chx == '('){
				break;
			}else {
				output = output + chx;
			}
		}
	}
}

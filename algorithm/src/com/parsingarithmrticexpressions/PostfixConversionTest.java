package com.parsingarithmrticexpressions;

import java.util.Scanner;

public class PostfixConversionTest {
	public static void main(String[] args) {
		String input, output;
		
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("Enter infix: ");
			input = scanner.nextLine();
			if(input.equals("quit")){
				break;
			}
			PostfixConversion conversion = new PostfixConversion(input);
			output = conversion.doTrans();			
			System.out.println("Postfix is: " + output);
			
		}
		
		System.out.println("End");
	}
}

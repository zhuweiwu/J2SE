package com.exp4j;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class Test {
	public static void main(String[] args) {
		//String expression = "3*5+6";
		String expression = "sin(60)";
		Calculable calc;
		try {
			calc = new ExpressionBuilder(expression).build();
			double result = calc.calculate();
			System.out.println(result);
		} catch (UnknownFunctionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnparsableExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

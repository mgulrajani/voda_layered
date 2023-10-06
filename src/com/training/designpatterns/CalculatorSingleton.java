package com.training.designpatterns;


public class CalculatorSingleton {
	
	private static Calculator calculator = null;
	private CalculatorSingleton() {}
	
	public static Calculator getCalculator() {
		if (calculator == null) {
			
			calculator=new Calculator();
		}
		return calculator;
	}

}

package com.bayviewglen.dayfour;

public class ExampleOne {

	public static void main(String[] args) {
		int num = 180308;
		int digit1 = num/100000;
		int digit2 = num/10000%10;
		int digit3 = num/1000%10;
		int digit4 = num/100%10;
		int digit5 = num/10%10;
		int digit6 = num%10;
		System.out.println(digit1+digit2+digit3+digit4+digit5+digit6);
	}

}

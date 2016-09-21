package com.bayviewglen.daysix;

public class HomeworkOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price = 895;
		double tax = 0.055;
		double total = price * (1+tax);
		System.out.println("The total bill is " + (int)(total*1000)/1000 + ".");
	}

}

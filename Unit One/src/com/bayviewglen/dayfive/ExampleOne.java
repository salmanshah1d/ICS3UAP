package com.bayviewglen.dayfive;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		//System.out prints to console
		//Class = not primitive data like int or double
		Scanner keyboard = new Scanner(System.in);
		int x, y, z;
		System.out.print("Please enter three integers: ");
		x = keyboard.nextInt();
		y = keyboard.nextInt();
		z = keyboard.nextInt();
		
		double average = (x + y + z)/3.0;
		System.out.print(average);
	}

}

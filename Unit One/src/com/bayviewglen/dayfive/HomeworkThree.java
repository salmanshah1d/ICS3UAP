package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkThree {

	public static void main(String[] args) {

		System.out.print("Please enter a number: ");
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();

		int digit2 = (num / 10000) % 10;
		int digit5 = (num / 10) % 10;

		System.out.print("The product of the 2nd digit and 5th digit of " + num + " is " + digit2 * digit5 + ".");
		keyboard.close();
	}
}
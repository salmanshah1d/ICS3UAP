package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please enter a number: ");
		Scanner keyboard = new Scanner(System.in);
		double num = keyboard.nextInt();
		System.out.println("The square of " + num + " is " + num * num + ".");
		keyboard.close();
	}

}

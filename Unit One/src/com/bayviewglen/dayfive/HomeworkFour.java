package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {

		System.out.print("Please enter the initial velocity, accelaration, and time passed, separated by spaces: ");
		Scanner keyboard = new Scanner(System.in);
		double initial = keyboard.nextInt();
		double acc = keyboard.nextInt();
		double time = keyboard.nextInt();
		double velocity = initial + (acc * time);

		System.out.print("The velocity is " + (int)velocity + ".");
		keyboard.close();
	}
}
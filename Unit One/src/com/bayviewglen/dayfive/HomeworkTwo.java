package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkTwo {

	public static void main(String[] args) {
	System.out.print("How much is the quiz out of? ");
	Scanner keyboard = new Scanner(System.in);
	double total = keyboard.nextInt();
	
	System.out.print("What score did you get? ");
	Scanner keyboard1 = new Scanner(System.in);
	double score = keyboard1.nextInt();
	
	double grade = score/total;
	
	System.out.print("The student received " + (int)(grade*100) + "% or " + (int)score + "/" + (int)total + " on his test.");
	keyboard.close();
	keyboard1.close();
	}
}

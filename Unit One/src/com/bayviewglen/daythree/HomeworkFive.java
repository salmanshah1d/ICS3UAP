package com.bayviewglen.daythree;

public class HomeworkFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pennies, nickles, dimes, quarters, loonies, toonies, money;
		pennies = 200;
		nickles = 40;
		dimes = 20;
		quarters = 8;
		loonies = 2;
		toonies = 1;
		money = (pennies + (nickles*5) + (dimes*10) + (quarters * 25) + (loonies * 100) + (toonies*200))/100;
		System.out.print("When there are " + pennies + " pennies, " + nickles + " nickles, " + dimes + " dimes, " + quarters + " quarters, " + loonies + " loonies, and " + toonies + " toonies, it totals to " + money + " dollars.");
	}

}

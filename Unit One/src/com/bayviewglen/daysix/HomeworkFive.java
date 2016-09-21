package com.bayviewglen.daysix;

public class HomeworkFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int won = 110;
		int lost = 44;
		double total = won + lost;
		double rate = (double)(int)((100*(won/total))*1000)/1000;
		
		System.out.print("The Yankees have won " + rate + "% games.");
	}

}

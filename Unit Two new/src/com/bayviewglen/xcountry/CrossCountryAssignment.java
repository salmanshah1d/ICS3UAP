package com.bayviewglen.xcountry;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {

	public static void main(String[] args) {

		// PREFACE //
		final int SECONDS_PER_MINUTE = 60;
		Scanner keyboard = new Scanner(System.in);
		// Establish decimal format for future decimals (seconds)
		DecimalFormat formatter = new DecimalFormat("00.000");

		// RUNNER ONE
		String name, firstName, lastName, mileOne, mileTwo, finishTime, splitOne, splitTwo, splitThree, formattedName;
		System.out.print("Please enter your first and last name: ");
		name = keyboard.nextLine();

		// Divides name into first and last name
		firstName = name.split(" ")[0];
		lastName = name.split(" ")[1];

		// Puts name into "last, first" format for future tables
		formattedName = lastName + ", " + firstName;

		System.out.print(firstName + ", please enter your Mile One time (mm:ss.sss): ");
		mileOne = keyboard.nextLine();

		// Split Mile One time into seconds and minutes, convert minutes to
		// seconds, and format to have 0 padding
		int minutesOne = Integer.parseInt(mileOne.split(":")[0]);
		double secOne = Double.parseDouble(mileOne.split(":")[1]);
		double totalSecMileOne = (minutesOne * SECONDS_PER_MINUTE) + secOne;
		splitOne = minutesOne + ":" + formatter.format(secOne);

		System.out.print(firstName + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		mileTwo = keyboard.nextLine();

		// Split Mile Two time into seconds, minutes, and calculate total amount
		// of seconds
		int minutesTwo = Integer.parseInt(mileTwo.split(":")[0]);
		double secTwo = Double.parseDouble(mileTwo.split(":")[1]);
		double totalSecMileTwo = (minutesTwo * SECONDS_PER_MINUTE) + secTwo;

		// Take input on time until finish line
		System.out.print(firstName + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		finishTime = keyboard.nextLine();

		// Split finishing time into seconds, minutes, and calculate total
		// amount of seconds
		int minutesFinish = Integer.parseInt(finishTime.split(":")[0]);
		double secFinish = Double.parseDouble(finishTime.split(":")[1]);
		double totalSecFinish = (minutesFinish * SECONDS_PER_MINUTE) + secFinish;
		String finishTimeFormatted = minutesFinish + ":" + formatter.format(secFinish);

		// Calculate time (in seconds) of splits two and three
		double totalSecSplitTwo = totalSecMileTwo - totalSecMileOne;
		double totalSecSplitThree = totalSecFinish - totalSecMileTwo;

		// Converting split two time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitTwo = (int) (totalSecSplitTwo / SECONDS_PER_MINUTE);
		double secSplitTwo = (double) (totalSecSplitTwo - (minutesSplitTwo * SECONDS_PER_MINUTE));
		splitTwo = minutesSplitTwo + ":" + formatter.format(secSplitTwo);

		// Converting split three time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitThree = (int) (totalSecSplitThree / SECONDS_PER_MINUTE);
		double secSplitThree = (double) (totalSecSplitThree - (minutesSplitThree * SECONDS_PER_MINUTE));
		splitThree = minutesSplitThree + ":" + formatter.format(secSplitThree);

		// Print all results to the console
		System.out.println("\nRunner One Summary");
		System.out.println("******************\n");
		System.out.println("Runner: " + formattedName);
		System.out.println("Split One: " + splitOne);
		System.out.println("Split Two: " + splitTwo);
		System.out.println("Split Three: " + splitThree);
		System.out.println("Total Time: " + finishTimeFormatted);
		System.out.println("\n");

		// RUNNER ONE
		String name2, firstName2, lastName2, mileOne2, mileTwo2, finishTime2, splitOne2, splitTwo2, splitThree2,
				formattedName2;
		System.out.print("Please enter your first and last name: ");
		name2 = keyboard.nextLine();

		// Divides name into first and last name
		firstName2 = name2.split(" ")[0];
		lastName2 = name2.split(" ")[1];

		// Puts name into "last, first" format for future tables
		formattedName2 = lastName2 + ", " + firstName2;

		System.out.print(firstName2 + ", please enter your Mile One time (mm:ss.sss): ");
		mileOne2 = keyboard.nextLine();

		// Split Mile One time into seconds and minutes, convert minutes to
		// seconds, and format to have 0 padding
		int minutesOne2 = Integer.parseInt(mileOne2.split(":")[0]);
		double secOne2 = Double.parseDouble(mileOne2.split(":")[1]);
		double totalSecMileOne2 = (minutesOne2 * SECONDS_PER_MINUTE) + secOne2;
		splitOne2 = minutesOne2 + ":" + formatter.format(secOne2);

		System.out.print(firstName2 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		mileTwo2 = keyboard.nextLine();

		// Split Mile Two time into seconds, minutes, and calculate total amount
		// of seconds
		int minutesTwo2 = Integer.parseInt(mileTwo2.split(":")[0]);
		double secTwo2 = Double.parseDouble(mileTwo2.split(":")[1]);
		double totalSecMileTwo2 = (minutesTwo2 * SECONDS_PER_MINUTE) + secTwo2;

		// Take input on time until finish line
		System.out.print(firstName2 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		finishTime2 = keyboard.nextLine();

		// Split finishing time into seconds, minutes, and calculate total
		// amount of seconds
		int minutesFinish2 = Integer.parseInt(finishTime2.split(":")[0]);
		double secFinish2 = Double.parseDouble(finishTime2.split(":")[1]);
		double totalSecFinish2 = (minutesFinish2 * SECONDS_PER_MINUTE) + secFinish2;
		String finishTimeFormatted2 = minutesFinish2 + ":" + formatter.format(secFinish2);

		// Calculate time (in seconds) of splits two and three
		double totalSecSplitTwo2 = totalSecMileTwo2 - totalSecMileOne2;
		double totalSecSplitThree2 = totalSecFinish2 - totalSecMileTwo2;

		// Converting split two time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitTwo2 = (int) (totalSecSplitTwo2 / SECONDS_PER_MINUTE);
		double secSplitTwo2 = (double) (totalSecSplitTwo2 - (minutesSplitTwo2 * SECONDS_PER_MINUTE));
		splitTwo2 = minutesSplitTwo2 + ":" + formatter.format(secSplitTwo2);

		// Converting split three time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitThree2 = (int) (totalSecSplitThree2 / SECONDS_PER_MINUTE);
		double secSplitThree2 = (double) (totalSecSplitThree2 - (minutesSplitThree2 * SECONDS_PER_MINUTE));
		splitThree2 = minutesSplitThree2 + ":" + formatter.format(secSplitThree2);

		// Print all results to the console
		System.out.println("\nRunner One Summary");
		System.out.println("******************\n");
		System.out.println("Runner: " + formattedName2);
		System.out.println("Split One: " + splitOne2);
		System.out.println("Split Two: " + splitTwo2);
		System.out.println("Split Three: " + splitThree2);
		System.out.println("Total Time: " + finishTimeFormatted2);
		System.out.println("\n");

		// RUNNER THREE
		String name3, firstName3, lastName3, mileOne3, mileTwo3, finishTime3, splitOne3, splitTwo3, splitThree3,
				formattedName3;
		System.out.print("Please enter your first and last name: ");
		name3 = keyboard.nextLine();

		// Divides name into first and last name
		firstName3 = name3.split(" ")[0];
		lastName3 = name3.split(" ")[1];

		// Puts name into "last, first" format for future tables
		formattedName3 = lastName3 + ", " + firstName3;

		System.out.print(firstName3 + ", please enter your Mile One time (mm:ss.sss): ");
		mileOne3 = keyboard.nextLine();

		// Split Mile One time into seconds and minutes, convert minutes to
		// seconds, and format to have 0 padding
		int minutesOne3 = Integer.parseInt(mileOne3.split(":")[0]);
		double secOne3 = Double.parseDouble(mileOne3.split(":")[1]);
		double totalSecMileOne3 = (minutesOne3 * SECONDS_PER_MINUTE) + secOne3;
		splitOne3 = minutesOne3 + ":" + formatter.format(secOne3);

		System.out.print(firstName3 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		mileTwo3 = keyboard.nextLine();

		// Split Mile Two time into seconds, minutes, and calculate total amount
		// of seconds
		int minutesTwo3 = Integer.parseInt(mileTwo3.split(":")[0]);
		double secTwo3 = Double.parseDouble(mileTwo3.split(":")[1]);
		double totalSecMileTwo3 = (minutesTwo3 * SECONDS_PER_MINUTE) + secTwo3;

		// Take input on time until finish line
		System.out.print(firstName3 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		finishTime3 = keyboard.nextLine();

		// Split finishing time into seconds, minutes, and calculate total
		// amount of seconds
		int minutesFinish3 = Integer.parseInt(finishTime3.split(":")[0]);
		double secFinish3 = Double.parseDouble(finishTime3.split(":")[1]);
		double totalSecFinish3 = (minutesFinish3 * SECONDS_PER_MINUTE) + secFinish3;
		String finishTimeFormatted3 = minutesFinish3 + ":" + formatter.format(secFinish3);

		// Calculate time (in seconds) of splits two and three
		double totalSecSplitTwo3 = totalSecMileTwo3 - totalSecMileOne3;
		double totalSecSplitThree3 = totalSecFinish3 - totalSecMileTwo3;

		// Converting split two time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitTwo3 = (int) (totalSecSplitTwo3 / SECONDS_PER_MINUTE);
		double secSplitTwo3 = (double) (totalSecSplitTwo3 - (minutesSplitTwo3 * SECONDS_PER_MINUTE));
		splitTwo3 = minutesSplitTwo3 + ":" + formatter.format(secSplitTwo3);

		// Converting split three time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitThree3 = (int) (totalSecSplitThree3 / SECONDS_PER_MINUTE);
		double secSplitThree3 = (double) (totalSecSplitThree3 - (minutesSplitThree3 * SECONDS_PER_MINUTE));
		splitThree3 = minutesSplitThree3 + ":" + formatter.format(secSplitThree3);

		// Print all results to the console
		System.out.println("\nRunner Three Summary");
		System.out.println("******************\n");
		System.out.println("Runner: " + formattedName3);
		System.out.println("Split One: " + splitOne3);
		System.out.println("Split Two: " + splitTwo3);
		System.out.println("Split Three: " + splitThree3);
		System.out.println("Total Time: " + finishTimeFormatted3);
		System.out.println("\n");

		// RUNNER FOUR
		String name4, firstName4, lastName4, mileOne4, mileTwo4, finishTime4, splitOne4, splitTwo4, splitThree4,
				formattedName4;
		System.out.print("Please enter your first and last name: ");
		name4 = keyboard.nextLine();

		// Divides name into first and last name
		firstName4 = name4.split(" ")[0];
		lastName4 = name4.split(" ")[1];

		// Puts name into "last, first" format for future tables
		formattedName4 = lastName4 + ", " + firstName4;

		System.out.print(firstName4 + ", please enter your Mile One time (mm:ss.sss): ");
		mileOne4 = keyboard.nextLine();

		// Split Mile One time into seconds and minutes, convert minutes to
		// seconds, and format to have 0 padding
		int minutesOne4 = Integer.parseInt(mileOne4.split(":")[0]);
		double secOne4 = Double.parseDouble(mileOne4.split(":")[1]);
		double totalSecMileOne4 = (minutesOne4 * SECONDS_PER_MINUTE) + secOne4;
		splitOne4 = minutesOne4 + ":" + formatter.format(secOne4);

		System.out.print(firstName4 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		mileTwo4 = keyboard.nextLine();

		// Split Mile Two time into seconds, minutes, and calculate total amount
		// of seconds
		int minutesTwo4 = Integer.parseInt(mileTwo4.split(":")[0]);
		double secTwo4 = Double.parseDouble(mileTwo4.split(":")[1]);
		double totalSecMileTwo4 = (minutesTwo4 * SECONDS_PER_MINUTE) + secTwo4;

		// Take input on time until finish line
		System.out.print(firstName4 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		finishTime4 = keyboard.nextLine();

		// Split finishing time into seconds, minutes, and calculate total
		// amount of seconds
		int minutesFinish4 = Integer.parseInt(finishTime4.split(":")[0]);
		double secFinish4 = Double.parseDouble(finishTime4.split(":")[1]);
		double totalSecFinish4 = (minutesFinish4 * SECONDS_PER_MINUTE) + secFinish4;
		String finishTimeFormatted4 = minutesFinish4 + ":" + formatter.format(secFinish4);

		// Calculate time (in seconds) of splits two and three
		double totalSecSplitTwo4 = totalSecMileTwo4 - totalSecMileOne4;
		double totalSecSplitThree4 = totalSecFinish4 - totalSecMileTwo4;

		// Converting split two time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitTwo4 = (int) (totalSecSplitTwo4 / SECONDS_PER_MINUTE);
		double secSplitTwo4 = (double) (totalSecSplitTwo4 - (minutesSplitTwo4 * SECONDS_PER_MINUTE));
		splitTwo4 = minutesSplitTwo4 + ":" + formatter.format(secSplitTwo4);

		// Converting split three time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitThree4 = (int) (totalSecSplitThree4 / SECONDS_PER_MINUTE);
		double secSplitThree4 = (double) (totalSecSplitThree4 - (minutesSplitThree4 * SECONDS_PER_MINUTE));
		splitThree4 = minutesSplitThree4 + ":" + formatter.format(secSplitThree4);

		// Print all results to the console
		System.out.println("\nRunner Four Summary");
		System.out.println("******************\n");
		System.out.println("Runner: " + formattedName4);
		System.out.println("Split One: " + splitOne4);
		System.out.println("Split Two: " + splitTwo4);
		System.out.println("Split Three: " + splitThree4);
		System.out.println("Total Time: " + finishTimeFormatted4);
		System.out.println("\n");

		// RUNNER FIVE
		String name5, firstName5, lastName5, mileOne5, mileTwo5, finishTime5, splitOne5, splitTwo5, splitThree5,
				formattedName5;
		System.out.print("Please enter your first and last name: ");
		name5 = keyboard.nextLine();

		// Divides name into first and last name
		firstName5 = name5.split(" ")[0];
		lastName5 = name5.split(" ")[1];

		// Puts name into "last, first" format for future tables
		formattedName5 = lastName5 + ", " + firstName5;

		System.out.print(firstName5 + ", please enter your Mile One time (mm:ss.sss): ");
		mileOne5 = keyboard.nextLine();

		// Split Mile One time into seconds and minutes, convert minutes to
		// seconds, and format to have 0 padding
		int minutesOne5 = Integer.parseInt(mileOne5.split(":")[0]);
		double secOne5 = Double.parseDouble(mileOne5.split(":")[1]);
		double totalSecMileOne5 = (minutesOne5 * SECONDS_PER_MINUTE) + secOne5;
		splitOne5 = minutesOne5 + ":" + formatter.format(secOne5);

		System.out.print(firstName5 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		mileTwo5 = keyboard.nextLine();

		// Split Mile Two time into seconds, minutes, and calculate total amount
		// of seconds
		int minutesTwo5 = Integer.parseInt(mileTwo5.split(":")[0]);
		double secTwo5 = Double.parseDouble(mileTwo5.split(":")[1]);
		double totalSecMileTwo5 = (minutesTwo5 * SECONDS_PER_MINUTE) + secTwo5;

		// Take input on time until finish line
		System.out.print(firstName5 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		finishTime5 = keyboard.nextLine();

		// Split finishing time into seconds, minutes, and calculate total
		// amount of seconds
		int minutesFinish5 = Integer.parseInt(finishTime5.split(":")[0]);
		double secFinish5 = Double.parseDouble(finishTime5.split(":")[1]);
		double totalSecFinish5 = (minutesFinish5 * SECONDS_PER_MINUTE) + secFinish5;
		String finishTimeFormatted5 = minutesFinish5 + ":" + formatter.format(secFinish5);

		// Calculate time (in seconds) of splits two and three
		double totalSecSplitTwo5 = totalSecMileTwo5 - totalSecMileOne5;
		double totalSecSplitThree5 = totalSecFinish5 - totalSecMileTwo5;

		// Converting split two time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitTwo5 = (int) (totalSecSplitTwo5 / SECONDS_PER_MINUTE);
		double secSplitTwo5 = (double) (totalSecSplitTwo5 - (minutesSplitTwo5 * SECONDS_PER_MINUTE));
		splitTwo5 = minutesSplitTwo5 + ":" + formatter.format(secSplitTwo5);

		// Converting split three time (in seconds) to time (in minutes and
		// seconds)
		int minutesSplitThree5 = (int) (totalSecSplitThree5 / SECONDS_PER_MINUTE);
		double secSplitThree5 = (double) (totalSecSplitThree5 - (minutesSplitThree5 * SECONDS_PER_MINUTE));
		splitThree5 = minutesSplitThree5 + ":" + formatter.format(secSplitThree5);

		// Print all results to the console
		System.out.println("\nRunner Five Summary");
		System.out.println("******************\n");
		System.out.println("Runner: " + formattedName5);
		System.out.println("Split One: " + splitOne5);
		System.out.println("Split Two: " + splitTwo5);
		System.out.println("Split Three: " + splitThree5);
		System.out.println("Total Time: " + finishTimeFormatted5);
		System.out.println("\n");

		// Print all values into final chart
		System.out.println("Bayview Glen Cross Country Results");
		System.out.printf("%-24s%-24s%-24s%-24s%s", "Name", "Split One", "Split Two", "Split Three", "Finish Time\n");
		System.out.printf("%-24s%-24s%-24s%-24s%s", "----", "---------", "---------", "-----------", "-----------\n");
		System.out.printf("%-24s%-24s%-24s%-24s%-24s\n", formattedName, splitOne, splitTwo, splitThree, finishTime);
		System.out.printf("%-24s%-24s%-24s%-24s%-24s\n", formattedName2, splitOne2, splitTwo2, splitThree2,
				finishTime2);
		System.out.printf("%-24s%-24s%-24s%-24s%-24s\n", formattedName3, splitOne3, splitTwo3, splitThree3,
				finishTime3);
		System.out.printf("%-24s%-24s%-24s%-24s%-24s\n", formattedName4, splitOne4, splitTwo4, splitThree4,
				finishTime4);
		System.out.printf("%-24s%-24s%-24s%-24s%-24s\n", formattedName5, splitOne5, splitTwo5, splitThree5,
				finishTime5);

		keyboard.close();
	}

}
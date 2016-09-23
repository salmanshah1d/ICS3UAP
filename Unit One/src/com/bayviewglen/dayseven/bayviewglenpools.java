package com.bayviewglen.dayseven;

import java.util.Scanner;

public class bayviewglenpools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double length, width, sDepth, dDepth, transition, sLength, tLength, dLength, tDepth, linerOne, linerTwo, linerThree, surfaceArea, volume, volume1; 
		System.out.print("Please enter the length: ");
		Scanner key_Length = new Scanner(System.in);
		length = key_Length.nextInt();
		
		System.out.print("Please enter the width: ");
		Scanner key_Width = new Scanner(System.in);
		width = key_Width.nextInt();
		
		System.out.print("Please enter the depth of the shallow end: ");
		Scanner key_sDepth = new Scanner(System.in);
		sDepth = key_sDepth.nextInt();
		
		System.out.print("Please enter the depth of the deep end: ");
		Scanner key_dDepth = new Scanner(System.in);
		dDepth = key_dDepth.nextInt();
		
		System.out.print("Please enter the length of the transition between the shallow and deep end: ");
		Scanner key_transition = new Scanner(System.in);
		transition = key_transition.nextInt();
		
		System.out.print("Please enter the length of the shallow end: ");
		Scanner key_sLength = new Scanner(System.in);
		sLength = key_sLength.nextInt();
		
		tDepth = dDepth-sDepth;
		dLength = length - sLength;
		tLength = Math.sqrt(Math.pow(transition, 2) - Math.pow(tDepth, 2));
		dLength = width-sLength-tLength;
		
		System.out.print("Please enter the unit price for liner material: ");
		Scanner key_linerOne = new Scanner(System.in);
		linerOne = key_linerOne.nextInt();
		
		System.out.print("Please enter the unit price for a different brand of liner material: ");
		Scanner key_linerTwo = new Scanner(System.in);
		linerTwo = key_linerTwo.nextInt();
		
		System.out.print("Please enter the unit price for yet another different brand of liner material: ");
		Scanner key_linerThree = new Scanner(System.in);
		linerThree = key_linerThree.nextInt();
		
		surfaceArea = width*(dDepth+dLength+sDepth+sLength+transition); 
		volume = (width*((((dDepth+sDepth)/2)*tLength)+(dDepth * dLength) + (sDepth * sLength)));
		
		
		System.out.println("\nIf the pool is filled 90%, it will require " + (Math.round(volume*0.9)) + " gallons of water.");
		System.out.println("\nIt will require " + Math.round(surfaceArea) + " square meters.");
		System.out.println("\nThe price of liner is: \n" + "Type 1: " + ((double)(int)((surfaceArea * linerOne)*100))/100 + "\n" + "Type 2: " + ((double)(int)((surfaceArea * linerTwo)*100))/100 + "\n" + "Type 3: " + ((double)(int)((surfaceArea * linerThree)*100))/100 + "\n");
		
		
		key_Length.close();
		key_Width.close();
		key_Length.close();
		key_sDepth.close();
		key_dDepth.close();
		key_transition.close();
		key_sLength.close();
		key_linerOne.close();
		key_linerTwo.close();
		key_linerThree.close();
	}

	private static String round(double volume) {
		// TODO Auto-generated method stub
		return null;
	}

}

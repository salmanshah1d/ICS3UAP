package com.bayviewglen.dayfour;

public class HomeworkFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double x = 5.5;
		double y = 3.0;
		double z = -2.0;
		int i = 5;
		int j = 4;
		int k = 3;
		
		//a:
		int l = i-j;
		int m = i-l;
		int n = i-m;
		int o = i-n;
		System.out.println("a. " + o);
		
		//b:
		double w = x-y;
		double v = (w*(x+l));
		System.out.println("b. " + v);
		
		//c:
		double u = y-x;
		double t = w-u-w-u;
		System.out.println("c. " + t);
	}

}

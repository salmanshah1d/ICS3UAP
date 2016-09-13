package com.bayviewglen.daythree;

public class HomeworkSix {

	public static void main(String[] args) {
		double a, b, c, root1, root2;
		a = 2;
		b = 4;
		c = -6;
		root1 = (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);
		root2 = (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
		System.out.print("The two roots are " + root1 + " and " + root2 + ".");

	}

}

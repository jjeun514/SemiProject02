package com.test.model;

public class test {

	public static void main(String[] args) {
		int a = 10;
		int b = 12;
		
		int c = (int)Math.round(((double)b/a)*100);
		if ( c > 100 ) {
			c = 100;
		}
		System.out.println(c);
	}

}

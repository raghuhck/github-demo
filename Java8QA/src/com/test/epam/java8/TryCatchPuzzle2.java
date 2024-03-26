package com.test.epam.java8;

public class TryCatchPuzzle2 {

	public static int test(int i) {
		try {
			int a=i/0;
		}finally {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test(0));
		System.out.println(test(1));

	}

}

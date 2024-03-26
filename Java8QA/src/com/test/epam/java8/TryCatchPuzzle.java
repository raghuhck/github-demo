package com.test.epam.java8;

public class TryCatchPuzzle {

	public static int test(int i) {
		try {
			if (i == 0)
				throw new Exception();
			return 0;
		} catch (Exception e) {
			return 1;
		} finally {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test(0));
		System.out.println(test(1));

	}

}

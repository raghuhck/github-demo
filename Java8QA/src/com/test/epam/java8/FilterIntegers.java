package com.test.epam.java8;

import java.util.List;
import java.util.stream.Collectors;

/*Given a list of integers, find out all the numbers starting with 1 using Stream functions.
*/
public class FilterIntegers {

	public static void main(String[] args) {
		 List<Integer> numbers = List.of(123, 45, 12, 567, 198, 1001);

	        List<Integer> result = numbers.stream()
	                .filter(n -> String.valueOf(n).startsWith("1"))
	                .collect(Collectors.toList());

	        System.out.println("Numbers starting with 1: " + result);

	}

}

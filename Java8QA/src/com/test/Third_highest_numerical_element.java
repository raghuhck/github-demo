package com.test;

import java.util.Comparator;

// Given a list of Strings, find the 3rd highest numerical element present in it using Stream functions?

import java.util.List;
import java.util.stream.Collectors;

public class Third_highest_numerical_element{
	public static void main(String[] args) {
		/*
		 * List<String> myList = List.of("apple", "", "  ", "15", "98.9", "0.0", "94.0",
		 * "98", "-0.98", "orange", "0.98", "0099", "098", "32", "98.0", "98.019",
		 * "98.08", "-1", "-98.09");
		 */
	
	List<String> myList = List.of("-1", "10", "20", "30", "40", "50", "60", "90");
	
	List<Double> numbers = myList.stream()
                .filter(s -> s.matches("[0-9.-]+")) // Filter out non-numeric values- -?\\d+(\\.\\d+)?
                .map(Double::parseDouble)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    
    System.out.println(numbers);
    System.out.println(numbers.size());
        if (numbers.size() >= 3) {
            double thirdHighest = numbers.get(numbers.size() - 3);
            System.out.println("Third highest numerical element: " + thirdHighest);
        } else {
            System.out.println("There are less than three numerical elements in the list.");
        }	
	}
}



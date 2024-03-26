package com.test.epam.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*2> Consider a String array and find the count of repetitive elements by ignoring its case. Please use Java 8+ features and try to get the expected output.

String[] array = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};

Expected output:JAVA = 3, SPRING = 2, MICROSERVICES = 1, SQL = 1, CLOUD = 1
*/
public class FindCountOfRepetitiveElements {

	public static void main(String[] args) {
		 String[] array = {"jaVa", "Spring", "Microservices", "java", "SqL", "Java", "cLoud", "spring"};

	        Map<String, Long> countMap = Arrays.stream(array)
	                .map(String::toLowerCase) // Convert each string to lowercase
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	        countMap.forEach((key, value) -> System.out.println(key.toUpperCase() + " = " + value));

	}

}

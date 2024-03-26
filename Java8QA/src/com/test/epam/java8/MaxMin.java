package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxMin {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

		Optional<Integer> max = listOfIntegers.stream().collect(Collectors.maxBy(Integer::compareTo));

		Optional<Integer> min = listOfIntegers.stream().collect(Collectors.minBy(Integer::compareTo));

		System.out.println("Maximum number: " + max.orElse(null));
		System.out.println("Minimum number: " + min.orElse(null));
	}

}

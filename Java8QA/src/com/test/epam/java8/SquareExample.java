package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Transform a List of integers to square each even element and skip all the odd numbers from output
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
Output = 4, 16, 36, 64*/

public class SquareExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        String result = numbers.stream()
                              .filter(n -> n % 2 == 0) // Filter out odd numbers
                              .map(n -> n * n) // Square each even number
                              .map(Object::toString) // Convert each square to a string
                              .collect(Collectors.joining(", ")); // Join the squares with a comma and space

        System.out.println("Output: " + result);
    }
}

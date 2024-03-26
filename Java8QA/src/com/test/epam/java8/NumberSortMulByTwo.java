package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*You have a list of integers. You need to write a code that will return a new list where all numbers will be sorted in ascending order and then multiplied by 2.
*/
		
public class NumberSortMulByTwo {
    public static List<Integer> doubleSorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(num -> num * 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 2, 5);
        List<Integer> doubledSortedNumbers = doubleSorted(numbers);

        System.out.println("Doubled and sorted numbers: " + doubledSortedNumbers);
    }
}


package com.test.epam.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/*Given an array of integers numbers and an integer sumElement, return indices of the two numbers such that they add up to sumElement,
You may assume that each input would have exactly one solution, and you may not use the same element twice.

int[] numbers={1,3,4,5,78,9};
int sumElement=13;
Expected output: [2,5]*/
		
public class TwoSumIndex {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 78, 9};
        int sumElement = 13;
        int[] result = twoSumJava8(numbers, sumElement);
        System.out.println("Expected output: [" + result[0] + ", " + result[1] + "]");
	}

    public static int[] twoSum(int[] numbers, int sumElement) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = sumElement - numbers[i];
            if (complementMap.containsKey(complement)) {
                return new int[]{complementMap.get(complement), i};
            }
            complementMap.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static int[] twoSumJava8(int[] numbers, int sumElement) {
        OptionalInt firstIndex = IntStream.range(0, numbers.length)
                .filter(i -> IntStream.range(0, numbers.length)
                        .filter(j -> j != i)
                        .anyMatch(j -> numbers[i] + numbers[j] == sumElement))
                .findFirst();

        if (firstIndex.isPresent()) {
            int i = firstIndex.getAsInt();
            int j = IntStream.range(0, numbers.length)
                    .filter(k -> k != i)
                    .filter(k -> numbers[i] + numbers[k] == sumElement)
                    .findFirst()
                    .getAsInt();
            return new int[]{i, j};
        } else {
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}

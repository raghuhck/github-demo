package com.test.epam.java8;

/*Given an array of integers, write a Java method to find the frequency of each unique element in the array and return the result as a Map where the keys are the unique elements and the values are their respective frequencies. java8

Example: Input: [1, 2, 3, 2, 1, 3, 4, 5, 4, 4] Output: {1=2, 2=2, 3=2, 4=3, 5=1}
*/

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyUnqiueEle {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1, 3, 4, 5, 4, 4};
        Map<Integer, Long> frequencyMap = findFrequency(array);
        System.out.println("Frequency Map: " + frequencyMap);
    }

    public static Map<Integer, Long> findFrequency(int[] array) {
        return Arrays.stream(array)
                .boxed()  // Convert int to Integer
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}


package com.test.epam.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintMissingNumber {
    public static void main(String[] args) {
        int[] givenArray = {1, 2, 3, 4, 9, 8};
        int givenSize = 10;

        printMissingNumberJava8(givenArray, givenSize);
    }

    public static void printMissingNumberJava8(int[] givenArray, int givenSize) {
        Set<Integer> set = Arrays.stream(givenArray).boxed().collect(Collectors.toSet());

        System.out.print("Missing numbers: ");
        IntStream.rangeClosed(1, givenSize)
                 .filter(num -> !set.contains(num))
                 .forEach(num -> System.out.print(num + " "));
    }
    
    public static void printMissingNumber(int[] givenArray, int givenSize) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : givenArray) {
            set.add(num);
        }

        System.out.print("Missing numbers: ");
        for (int i = 1; i <= givenSize; i++) {
            if (!set.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

package com.test.epam.java8;

import java.util.Arrays;

public class SquareAvg {
    public static void main(String[] args) {
        int[] array = {6, 8, 9, 10, 5, 12, 20, 40};

        double averageOfSquaredValues = Arrays.stream(array)
                .mapToDouble(num -> num * num)  // Square each element
                .filter(squaredValue -> squaredValue > 100)  // Filter values greater than 100
                .average()  // Calculate average
                .orElse(0);  // Default value if no values match the criteria

        System.out.println("Average of squared values greater than 100: " + averageOfSquaredValues);
    }
}



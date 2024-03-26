package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;

/*You are given a list of lists containing integers. Create a stream to flatten the nested lists, remove duplicate integers, and then find the square root of each distinct value.

List<List<Integer>> nestedLists = Arrays.asList(
Arrays.asList(1, 2, 3),
Arrays.asList(3, 4, 5),
Arrays.asList(5, 6, 7),
Arrays.asList(7, 8, 9)
);*/

public class FlatNestedListAndSquare {
    public static void main(String[] args) {
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(7, 8, 9)
        );

        nestedLists.stream()
                .flatMap(List::stream) // Flatten nested lists
                .distinct() // Remove duplicate integers
                .map(Math::sqrt) // Find square root of each distinct value
                .forEach(System.out::println);
    }
}

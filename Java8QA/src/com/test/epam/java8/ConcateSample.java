package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Show how you would convert a list of strings into a single string where each word is separated by a comma using the Java Stream API.
List<String> fruitList = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
output = Apple,Banana,Cherry,Date,Elderberry*/

public class ConcateSample {
    public static void main(String[] args) {
        List<String> fruitList = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");

        String output = fruitList.stream()
                                 .collect(Collectors.joining(","));
        
        System.out.println("Output: " + output);
    }
}

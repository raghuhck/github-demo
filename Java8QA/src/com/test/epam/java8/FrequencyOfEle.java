package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Find frequency of each element in the given list using java8
List<String> list = Arrays.asList("Pen", "Java", "Name", "Pen", "Mango", "Stapler", "Name", "Mango");
*/
public class FrequencyOfEle {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Pen", "Java", "Name", "Pen", "Mango", "Stapler", "Name", "Mango");

        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println("Frequency of each element:");
        frequencyMap.forEach((element, frequency) -> System.out.println(element + ": " + frequency));
    }
}

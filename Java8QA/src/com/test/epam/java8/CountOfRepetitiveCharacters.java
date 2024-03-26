package com.test.epam.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Find the count of repetitive character in given string using java8 features?

String name ="Nayan Rajvansh";*/

public class CountOfRepetitiveCharacters {
    public static void main(String[] args) {
        String name = "Nayan Rajvansh";
        Map<Character, Long> charCountMap = countRepetitiveCharacters(name);
        System.out.println("Count of repetitive characters:");
        charCountMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static Map<Character, Long> countRepetitiveCharacters(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}


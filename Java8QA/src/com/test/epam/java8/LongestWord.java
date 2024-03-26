package com.test.epam.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class LongestWord {
    public static void main(String[] args) {
        String test = "Welcome to the EPAM Interview process";

        Optional<String> longestWord = Arrays.stream(test.split("\\s+")) // Split the string into words
                .filter(word -> !word.isEmpty()) // Filter out empty strings
                .max(Comparator.comparingInt(String::length)); // Find the word with the maximum length

        longestWord.ifPresent(word -> System.out.println("Word with the largest length: " + word));
    }
}


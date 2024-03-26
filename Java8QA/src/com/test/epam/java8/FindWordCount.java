package com.test.epam.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*find the words present in the string more than once along with their occurrences
(the words inside the input should be treated as case insensitive)

String input="HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";
Output - {BYE-3, EPAM-6, HI-2}*/

public class FindWordCount {
    public static void main(String[] args) {
        String input = "HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";

        Map<String, Long> wordOccurrences = Arrays.stream(input.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> repeatedWords = wordOccurrences.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(repeatedWords);
    }
}


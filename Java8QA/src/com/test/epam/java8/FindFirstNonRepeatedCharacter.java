package com.test.epam.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Given a String, find the first non-repeated character in it using Stream functions.
*/
public class FindFirstNonRepeatedCharacter {

	public static void main(String[] args) {
        String str = "abcaedbd";

        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First non-repeated character: " + result);

	}

}

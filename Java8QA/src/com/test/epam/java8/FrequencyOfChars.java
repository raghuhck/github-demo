package com.test.epam.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
	*/	
public class FrequencyOfChars {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(sortStringByFrequency(s)); // Output: "eert" or "eetr"
        System.out.println(sortStringByFrequencyJava8(s));
    }

    public static String sortStringByFrequency(String s) {
        // Step 1: Create frequency map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Sort characters based on frequency
        List<Character> sortedCharacters = new ArrayList<>(frequencyMap.keySet());
        sortedCharacters.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        // Step 3: Construct sorted string
        StringBuilder sortedString = new StringBuilder();
        for (char c : sortedCharacters) {
            int frequency = frequencyMap.get(c);
            for (int i = 0; i < frequency; i++) {
                sortedString.append(c);
            }
        }
        
        return sortedString.toString();
    }
    
    public static String sortStringByFrequencyJava8(String s) {
        // Step 1: Create frequency map using Java 8 streams
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        
        // Step 2: Sort characters based on frequency in decreasing order
        List<Character> sortedCharacters = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .flatMap(entry -> Collections.nCopies(entry.getValue().intValue(), entry.getKey()).stream())
                .collect(Collectors.toList());
        
        // Step 3: Construct sorted string
        return sortedCharacters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}

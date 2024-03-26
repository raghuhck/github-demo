package com.test.epam.java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Iterate through the characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare the character with the corresponding characters of other strings
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // If the characters don't match or we reach the end of any string, return the prefix
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If all strings have the same prefix, return the prefix of the first string
        return strs[0];
    }

    public static String longestCommonPrefixJava8(String[] strs) {
    	if (strs == null || strs.length == 0) {
            return "";
        }

        // Find the shortest string length in the array
        int shortestLength = Arrays.stream(strs)
                                   .mapToInt(String::length)
                                   .min()
                                   .orElse(0);

        // Iterate through the indices of the shortest string
        return IntStream.range(0, shortestLength)
                        .mapToObj(i -> {
                            char commonChar = strs[0].charAt(i); // Get the character from the first string
                            // Check if the character exists in all other strings
                            return Arrays.stream(strs)
                                         .skip(1) // Skip the first string
                                         .allMatch(str -> str.length() > i && str.charAt(i) == commonChar) ? commonChar : null;
                        })
                        .takeWhile(c -> c != null) // Take characters until we find a null character
                        .map(Object::toString)
                        .collect(Collectors.joining());
    }
    
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix for strs1: " + longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix for strs2: " + longestCommonPrefix(strs2));
    }
}


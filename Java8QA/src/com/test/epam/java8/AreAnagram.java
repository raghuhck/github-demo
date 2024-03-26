package com.test.epam.java8;

import java.util.Arrays;

/*You are given two strings as an input. You must check if they form an anagram.
public boolean areAnagram(String s1, String s2) {} HEART <-> EARTH, LISTEN <-> SILENT
*/
public class AreAnagram {
    public static void main(String[] args) {
        System.out.println(areAnagram("HEART", "EARTH")); // Output: true
        System.out.println(areAnagram("LISTEN", "SILENT")); // Output: true
        System.out.println(areAnagram("TEST", "BEST")); // Output: false
    }

    public static boolean areAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // Different lengths cannot be anagrams
        }

        // Convert strings to char arrays, sort them, and compare
        return Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
    }
}

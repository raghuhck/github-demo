package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOfNonRepeatedCharacters {
 // This Program is case sensitivie too 
    public static void main(String[] args) {
        String str = "alphaadida";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);

        long count = map.values().stream().filter(i -> i == 1).count();

        System.out.println("The number of non-repeated characters is " + count);
    }
}


/* A data compression software utilizes various steps to compress a string of data. One of the steps involves finding the count of characters that are not repeated in the string.

Write an algorithm for the software developer to find the count of characters that are not repeated in the string.

Input Format
The input consists of a string.
compString representing the string
to be compressed.

Output
Print an integer representing the count of characters that are not repeated in the string. If no such character is found or the input string is empty then print 0.

Note
The input string compString is case sensitive. Uppercase characters and lowercase characters are counted as different. The input string compString consists of alphanumeric and special characters only.

Example
Input:
alphaadida
Output:
4
Explanation
** Non repeated characters are l, p ,h ,i ** */
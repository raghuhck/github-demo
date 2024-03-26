package com.test.epam.java8;

import java.util.Arrays;

/*
The candidate was asked to write an algorithm that, given an array with String objects, transforms these values based on a set of requirements (transformations) and returns the transformed values in an array. ==============

Please write a Java method named cleanAndSortStringArray(String[] myArray), which:
- Accepts a String array as an argument
- Converts string values to lowercase letters
- Replaces spaces in string values with underscores "_"
- Replaces all empty string values with the word 'missing'
- Sorts the string values in alphabetical order
- Return the processed string values in an array
Print the result in the main method.

For example, if you pass the following list to the method:
["First data", "Second data", "", "other DATA", "", "LAST DATA"]

The result given by the method should be:
["first_data", "last_data", "missing", "missing", "other_data", "second_data"]

What's the BigO of the implemented solution?

The time complexity of this implemented solution is O(n log n), where n is the number of elements in the 
input array. This is because the sorting step (Arrays.sort()) dominates the time complexity, 
which has a time complexity of O(n log n) in the average case. 
The other operations (converting to lowercase, replacing spaces, and replacing empty strings) 
have a time complexity of O(n), as they iterate through the array once.
*/

public class CleanAndSortStringArray {
    public static String[] cleanAndSortStringArray(String[] myArray) {
        // Convert string values to lowercase and replace spaces with underscores
        String[] transformedArray = Arrays.stream(myArray)
                .map(String::toLowerCase)
                .map(str -> str.replace(" ", "_"))
                .toArray(String[]::new);

        // Replace all empty string values with the word 'missing'
        for (int i = 0; i < transformedArray.length; i++) {
            if (transformedArray[i].isEmpty()) {
                transformedArray[i] = "missing";
            }
        }

        // Sort the string values in alphabetical order
        Arrays.sort(transformedArray);

        return transformedArray;
    }

    public static void main(String[] args) {
        String[] myArray = {"First data", "Second data", "", "other DATA", "", "LAST DATA"};
        String[] result = cleanAndSortStringArray(myArray);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}


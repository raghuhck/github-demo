package com.test.epam.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*There is an array of elements from 0 to eleven.
We need to write an algorithm that will select all pairs of elements whose sum is equal to eleven.
*/
public class TwoSumPairs {
	
    public static List<int[]> findPairs(int[] array) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int complement = 11 - array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == complement) {
                    pairs.add(new int[]{array[i], array[j]});
                }
            }
        }

        return pairs;
    }
    
    public static List<int[]> findPairsJava8(int[] array) {
        List<int[]> pairs = new ArrayList<>();

        IntStream.range(0, array.length)
                .forEach(i -> IntStream.range(i + 1, array.length)
                        .filter(j -> array[i] + array[j] == 11)
                        .mapToObj(j -> new int[]{array[i], array[j]})
                        .forEach(pairs::add));

        return pairs;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        List<int[]> pairs = findPairs(array);
        
        if (!pairs.isEmpty()) {
            System.out.println("Pairs whose sum is equal to eleven:");
            for (int[] pair : pairs) {
                System.out.println(pair[0] + " + " + pair[1] + " = 11");
            }
        } else {
            System.out.println("No pairs found whose sum is equal to eleven.");
        }
    }
}

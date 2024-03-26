package com.test.epam.java8;

import java.util.Arrays;

/*Q: (Array) Find the length of the largest continuous subarray whose sum is equal to the given targetSum value.

int[] arr = {15, 4, -2, 2, -3, 1, 3, 3, 0};
int targetSum = 4;
4 ==> len 1
4, -2, 2 ==> len 3
-3, 1, 3, 3 ==> len 4
-3, 1, 3, 3, 0 ==> len 5
-2, 2, -3, 1, 3, 3, 0 ==> len 7
1, 3 ==> len 2
output: Max length is 7*/

public class LargestContinuousSubarray {
    public static int maxLengthSubarrayJava8(int[] arr, int targetSum) {
        return Arrays.stream(arr)
                .mapToObj(num -> new int[]{num}) // Convert each element to a single-element array
                .reduce((a, b) -> {
                    int[] combined = Arrays.copyOf(a, a.length + b.length);
                    System.arraycopy(b, 0, combined, a.length, b.length);
                    return combined;
                }) // Combine all elements into a single array
                .map(array -> {
                    int maxLength = 0;
                    int sum = 0;
                    for (int i = 0; i < array.length; i++) {
                        sum = array[i];
                        for (int j = i + 1; j < array.length; j++) {
                            sum += array[j];
                            if (sum == targetSum && (j - i + 1) > maxLength) {
                                maxLength = j - i + 1;
                            }
                        }
                    }
                    return maxLength;
                })
                .orElse(0); // Handle empty array case
    }
    
    
    public static int maxLengthSubarray(int[] arr, int targetSum) {
        int maxLength = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > targetSum) {
                sum -= arr[start];
                start++;
            }

            if (sum == targetSum) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, -2, 2, -3, 1, 3, 3, 0};
        int targetSum = 4;
        int maxLength = maxLengthSubarray(arr, targetSum);
        System.out.println("Max length is " + maxLength);
    }
}


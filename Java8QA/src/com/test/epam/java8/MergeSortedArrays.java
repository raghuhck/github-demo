package com.test.epam.java8;

import java.util.Arrays;
import java.util.stream.IntStream;

/*You are given two integer arrays nums1 and nums2, sorted in non-decreasing order.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should be returned by the function.



Example 1:

Input: nums1 = [1,2,3], nums2 = [2,5,6]
Output: [1,2,2,3,5,6]*/
		
public class MergeSortedArrays {
    public static int[] mergeSortedArraysJava8(int[] nums1, int[] nums2) {
    	return IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};

        int[] mergedArray = mergeSortedArraysJava8(nums1, nums2);
        System.out.println("Merged sorted array: " + Arrays.toString(mergedArray));
    }
    
    
    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }

        return mergedArray;
    }
}


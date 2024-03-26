package com.test.epam.java8;

import java.util.Arrays;

/*Implement the binary search algorithm to find the index of a given element in a sorted array.
*/
public class BinarySearch {

	public static void main(String[] args) {
		 int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18};
	        int target = 10;
	        int index = binarySearchJava8(array, target);
	        if (index != -1) {
	            System.out.println("Element " + target + " found at index " + index);
	        } else {
	            System.out.println("Element " + target + " not found in the array");
	        }

	}

	public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // If we reach here, then the element was not present
        return -1;
    }
	
    public static int binarySearchJava8(int[] array, int target) {
        int index = Arrays.binarySearch(array, target);
        return index >= 0 ? index : -1;
    }
}

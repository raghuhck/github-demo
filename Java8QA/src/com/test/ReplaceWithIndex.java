package com.test;

import java.util.Scanner;

public class ReplaceWithIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];

        // Read the input list of numbers
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        // Create a result array
        int[] result = new int[N];

        // Replace the values with their corresponding indices
        for (int i = 0; i < N; i++) {
            result[arr[i]] = i;
        }

        // Print the result
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}


/* You are given a list of N unique positive numbers ranging from 0 to (N-1). Write an algorithm to replace the value of each number with its corresponding index value in the list.

Input
The first line of the input consists of an integer size, representing the size of the list (N). The next line consists of N space-separated integers, arr[0], arr[1].... arr[N-1] representing the given list of numbers.

Output
Print N space-separated integers representing the list obtained by replacing the values of the 
numbers with their corresponding index values in the list.

Constraints
0 < size ≤ 105
0 ≤ arr[i]≤ 105
0 <i< size

Note
All the numbers in the list are unique.

Example
Input
4
3 2 0 1
0 1 2 3 -> these are indexes
Output
2 3 1 0

Explanation
Before the change, the elements of the list are
arr[0]=3, arr[1]=2, arr[2]=0 and arr[3]=1

After the change, the elements of the list are
arr[0]=2, arr{1]=3, arr[2]=1 and arr[3] =0 */

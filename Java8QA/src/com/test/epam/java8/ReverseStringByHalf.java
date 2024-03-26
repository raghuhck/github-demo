package com.test.epam.java8;

public class ReverseStringByHalf {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s)); // Output: "olleh"
    }

    	//time complexity of n/2
    public static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Swap characters at left and right pointers
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move pointers towards each other
            left++;
            right--;
        }

        // Convert char array back to string
        return new String(charArray);
    }
    
    //time complexity of O(n)
    public static String reverseStringJava8(String s) {
        // Convert string to StringBuilder, reverse it, and convert back to string
        return new StringBuilder(s).reverse().toString();
    }
}


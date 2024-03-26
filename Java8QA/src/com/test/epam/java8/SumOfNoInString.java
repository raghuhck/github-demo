package com.test.epam.java8;

import java.util.Arrays;

/*Calculate sum of all numbers present in a string
String alphasnum = "12abc20yz8";
Output: 40*/

public class SumOfNoInString {
    public static void main(String[] args) {
        String alphasnum = "12abc20yz8";

        int sum = 0;
        String[] numbers = alphasnum.replaceAll("[^0-9]+", " ").split(" ");
        
        for (String num : numbers) {
            if (!num.isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }
        
        System.out.println("Sum of all numbers present in the string: " + sum);
        System.out.println("Sum of all numbers present in the string: " + SumOfNoInString.SumOfNoIntStringjava8());
   }
    
    public static int SumOfNoIntStringjava8()
    {
    	String alphasnum = "12abc20yz8";

        int sum = Arrays.stream(alphasnum.split("[^0-9]+"))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .sum();

        System.out.println("Sum of all numbers present in the string: " + sum);
        return sum;
     }
   
 }


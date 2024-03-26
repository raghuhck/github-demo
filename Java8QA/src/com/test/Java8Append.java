package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Append {
    
    public static void main(String[] args) {
        String name="Raghu";
        long charCount = name.chars().count();
        System.out.println("Number of characters: " + charCount); 

        List<String> list = Arrays.asList("a", "b", "c");
        List<String> newList = list.stream().map(s -> s + "d").collect(Collectors.toList());
        System.out.println(newList);  

        List<String> valuesList = Arrays.asList("value1", "value2", "value3");
        String commaSeparatedValues = String.join("; ", valuesList);
        System.out.println(commaSeparatedValues);

        List<String> list1 = Arrays.asList("a", "b", "c");
        // list1.forEach(i -> i = i+"d"); //The forEach method takes a Consumer as an argument, and the lambda expression you provided only modifies the local variable i, not the elements in the list.
        list1.replaceAll(i -> i + "d");
        System.out.println(list1); // [ad, bd, cd]

        List<String> list2 = Arrays.asList("a", "b", "c");
        for (String s : list2) {  
                s += "d";  
        }
        System.out.println(list2); // [ad, bd, cd]
        // The issue with your code is that you are using an enhanced for loop to iterate over the elements of the list, and then trying to modify each element by concatenating "d" to it. However, in this case, the variable s is a copy of each element in the list, and modifying it does not affect the original list.
        
        List<String> list3 = Arrays.asList("a", "b", "c");
        for (int i = 0; i < list3.size(); i++) {
           list3.set(i, list3.get(i) + "d");
        }
        System.out.println(list3); // [ad, bd, cd]
    
    }
}

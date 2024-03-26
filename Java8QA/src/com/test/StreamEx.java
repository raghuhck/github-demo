package com.test;


import java.util.*; 
import java.util.stream.Collectors; 
import java.util.stream.Stream; 

public class StreamEx {
    public static void main(String args[]) 
    {   
        // Creating a List using toList Collectors method
        List<String> list1 = Stream.of("January", "February", "March", "April", "May") 
                                  .collect(Collectors.toList()); 
 
        // Print the list 
        System.out.println("List from Java 8 stream: "
                           + list1.toString()); 

        String[] strArray = {"Delhi", "Mumbai", "Kolkata", "Chennai"};
        //initialize an immutable list from array using asList method
        List<String> mylist = Arrays.asList(strArray);
        //print the list
        System.out.println("Immutable list:");
        for(String val : mylist){
            System.out.print(val + " ");
        }
        System.out.println("\n");

        //initialize a mutable list(arraylist) from array using asList method
        List<String> arrayList = new ArrayList<>(Arrays.asList(strArray));
        System.out.println("Mutable list:");
        //add one more element to list
        arrayList.add("Pune");
        //print the arraylist
            for(String val : arrayList){
            System.out.print(val + " ");
         }
        System.out.println("\n");

        List<Integer> num_stack = new Stack<Integer>(){{ add(10);add(20); }}; 
        System.out.println("Stack : " + num_stack.toString());

        List<String> strList = List.of("Delhi", "Mumbai", "Kolkata"); 
          // Print the List 
        System.out.println("List using Java 9 List.of() : " + strList.toString()); 

        List<Integer> evenlist = Arrays.asList(2,4,6,8,10,12,14);
        // print list using streams
        System.out.println("Contents of evenlist using streams:");
        evenlist.stream().forEach(S ->System.out.print(S + " "));

        
     /*    An implementation may choose to not execute the stream pipeline
        (either sequentially or in parallel) if it is capable of computing the 
        count directly from the stream source. In such cases no source elements will
         be traversed and no intermediate operations will be evaluated. 
         Behavioral parameters with side-effects, which are strongly discouraged 
         except for harmless cases such as debugging, may be affected.
          For example, consider the following stream:
        The number of elements covered by the stream source, a List, is known 
       and the intermediate operation, peek, does not inject into or remove elements
        from the stream (as may be the case for flatMap or filter operations).
         Thus the count is the size of the List and there is no need to execute the pipeline
          and, as a side-effect, print out the list elements. */
        System.out.println("END");
        List<String> l = Arrays.asList("A", "B", "C", "D");
        long count = l.stream().peek(System.out::println).count();
        System.out.println(l.stream().count());
   } 
}

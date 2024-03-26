package com.test;

import java.util.ArrayList;
import java.util.List;

public class ListOfList {
    public static void main(String[] args) {
        List<ArrayList<String>> java_listOfLists = new ArrayList<ArrayList<String>>();

        //create a language list and add elements to it
        ArrayList<String> lang_list = new ArrayList<String>();
        lang_list.add("Java");
        lang_list.add("C++");
        //add language list to java list of list
        java_listOfLists.add(lang_list);

        //create a city list and add elements to it
        ArrayList<String> city_list = new ArrayList<String>();
        city_list.add("Pune");
        city_list.add("Mumbai");
        //add the city list to java list of lists
        java_listOfLists.add(city_list);

        //display the contents of list of lists     
        // System.out.println("Java list of lists contents:");
        // java_listOfLists.forEach((list)  ->                 //access each list
        // {
        //     list.forEach((city)->System.out.print(city + " ")); //each element of inner list
        // });

        //display the contents of list of lists    
        System.out.println(java_listOfLists); 
        System.out.println("Java list of lists contents:");
        for(ArrayList<String> List:java_listOfLists){  
                for(String inside:List){
                    System.out.println(inside);
                }          
        }
    }
}

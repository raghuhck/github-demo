package com.test;

// Create a functional interface
interface Converter {
    int convert(int input);
}


public class LambdaMethodArg {
    
    public static void main(String[] args) {   
        // Create a lambda expression
        Converter converter = (input) -> input * 2;
    
        // Pass the lambda expression to the method
        int result = converter.convert(10);
    
        // Print the result
        System.out.println(result);
    }

}

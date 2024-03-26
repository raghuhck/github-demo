package com.test;

import java.math.BigDecimal;

public class MethodOverload {
    
        
    public int add(Number n1, Number n2) {
        // Implementation for adding two Numbers
        System.out.println("Inside Number");
        // return n1.doubleValue() + n2.doubleValue();
        return n1.intValue() + n2.intValue();
    }

    public int add(Integer i1, Integer i2) {
        // Implementation for adding two Integers
        System.out.println("Inside Integer");
        return i1 + i2;
    }

    // public int add(Integer i1, Integer[] i2){
    //     System.out.println("Inside Integer arry arg");
    //     return 0;
    // }

    // public int add(Integer i1, Integer... iVarArgs){
    //     System.out.println("Inside Integer var arg");
    //     return i1 + i2;
    // }

    public static void main(String[] args) {
        MethodOverload mod = new MethodOverload();
        System.out.println(mod.add(101,21));
    }

    
}

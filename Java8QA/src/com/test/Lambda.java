package com.test;

import java.util.function.IntBinaryOperator;

public class Lambda {
    public static void main(String javalatte[]) {
        // this is lambda expression
        IntBinaryOperator plusOperation = (a, b) -> a + b;
        System.out.println("Sum of 10,34 : " + plusOperation.applyAsInt(10, 34));

    }
}

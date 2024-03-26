package com.test.epam.java8;

import java.util.Stack;

/*given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true*/

public class ValidParanthesis {
	
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        System.out.println("Is \"" + s1 + "\" valid? " + isValid(s1));
        System.out.println("Is \"" + s2 + "\" valid? " + isValid(s2));
        System.out.println("Is \"" + s3 + "\" valid? " + isValid(s3));
        System.out.println("Is \"" + s4 + "\" valid? " + isValid(s4));
        System.out.println("Is \"" + s5 + "\" valid? " + isValid(s5));
    }
    
    public static boolean isValidJava8(String s) {
        Stack<Character> stack = new Stack<>();

        s.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if (c == '(' || c == '[' || c == '{') {
                        stack.push(c);
                    } else {
                        if (stack.isEmpty()) {
                            stack.push('*'); // Placeholder to indicate an invalid state
                        } else {
                            char top = stack.pop();
                            if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                                stack.push('*'); // Placeholder to indicate an invalid state
                            }
                        }
                    }
                });

        return stack.isEmpty();
    }
}


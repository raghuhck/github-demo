package com.test.epam.java8;

import java.util.Arrays;
import java.util.List;

public class SumCalJava8 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("John", 30), new User("Julie", 35));
        int sumOfAges = calculateSumOfAges(users);
        System.out.println("Sum of ages: " + sumOfAges);
    }

    public static int calculateSumOfAges(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .sum();
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

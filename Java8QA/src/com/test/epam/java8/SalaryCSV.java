package com.test.epam.java8;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryCSV {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = List.of(
                new Employee("John", "Account", true, false, 900),
                new Employee("Alice", "HR", false, false, 600),
                new Employee("Bob", "IT", true, true, 800),
                new Employee("Emma", "HR", true, false, 700),
                new Employee("Mike", "IT", true, false, 400)
        );

        // Call the salaryCSV method and print the result
        System.out.println("Salary CSV: " + salaryCSV(employees));
    }

    public static String salaryCSV(List<Employee> employees) {
        // Filter employees based on the specified conditions and extract their salaries
        return employees.stream()
                .filter(employee -> (employee.isPermanent() && !employee.isManager()) || employee.getSalary() > 500)
                .filter(employee -> employee.getDepartment().equals("Account") || employee.getDepartment().equals("HR"))
                .map(Employee::getSalary)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    // Employee class definition
    static class Employee {
        private String name;
        private String department;
        private boolean isPermanent;
        private boolean isManager;
        private int salary;

        public Employee(String name, String department, boolean isPermanent, boolean isManager, int salary) {
            this.name = name;
            this.department = department;
            this.isPermanent = isPermanent;
            this.isManager = isManager;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public boolean isPermanent() {
            return isPermanent;
        }

        public boolean isManager() {
            return isManager;
        }

        public int getSalary() {
            return salary;
        }
    }
}


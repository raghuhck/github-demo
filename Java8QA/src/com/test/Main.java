package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employeeList = new ArrayList<>();

        // Add some Employee objects to the list
        employeeList.add(new Employee(1, "John", "Donovan", "IT", 5000.0, 30, 2010, "Male"));
        employeeList.add(new Employee(2, "Jane", "Smithson", "Network", 6000.0, 35, 2012, "Female"));
        employeeList.add(new Employee(3, "David", "Johnson", "Network", 5500.0, 45, 2011, "Male"));
        employeeList.add(new Employee(4, "Emily", "Davis", "HR", 4500.0, 48, 2015, "Female"));
        employeeList.add(new Employee(5, "Mark", "Thompson", "Network", 7000.0, 42, 2010, "Male"));
        employeeList.add(new Employee(6, "Adam", "Nelson", "Network", 8000.0, 41, 2013, "Male"));
        employeeList.add(new Employee(7, "Michael", "Mason", "IT", 5500.0, 52, 2009, "Male"));
        employeeList.add(new Employee(8, "Robert", "Nixon", "Network", 6500.0, 49, 2008, "Male"));
        employeeList.add(new Employee(9, "Daniel", "Brown", "Network", 7200.0, 43, 2014, "Male"));
        employeeList.add(new Employee(10, "Alex", "Johnson", "Network", 5800.0, 44, 2012, "Male"));
        employeeList.add(new Employee(11, "Thomas", "Harrison", "Network", 6700.0, 47, 2009, "Male"));
        employeeList.add(new Employee(12, "Edward", "Nelson", "Network", 8100.0, 46, 2011, "Male"));

        // Filter employees based on the criteria
        List<Employee> filteredEmployees = employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("Network"))
                .filter(employee -> employee.getAge() > 40)
                .filter(employee -> employee.getGender().equalsIgnoreCase("Male"))
                .filter(employee -> employee.getLastName().endsWith("n") || employee.getLastName().endsWith("N"))
                .collect(Collectors.toList());

        // Sort employees based on the date of joining (oldest first)
        List<Employee> sortedEmployees = filteredEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .collect(Collectors.toList());

        // Retrieve the top 50 employees with the oldest date of joining
        List<Employee> top50Employees = sortedEmployees.stream()
                .limit(50)
                .collect(Collectors.toList());

        // Sort employees based on the salary (highest first)
        List<Employee> sortedBySalary = filteredEmployees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Retrieve the 5th employee with the highest salary
        Employee fifthHighestSalaryEmployee = sortedBySalary.size() >= 5 ? sortedBySalary.get(4) : null;

        // Print the results
        if (!top50Employees.isEmpty()) {
            System.out.println("Employees matching the criteria:");
            for (Employee employee : top50Employees) {
                System.out.println("First Name: " + employee.getFirstName());
                System.out.println("Last Name: " + employee.getLastName());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No employees found matching the criteria.");
        }

        if (fifthHighestSalaryEmployee != null) {
            System.out.println("5th Employee with the highest salary:");
            System.out.println("First Name: " + fifthHighestSalaryEmployee.getFirstName());
            System.out.println("Last Name: " + fifthHighestSalaryEmployee.getLastName());
            System.out.println("Salary: " + fifthHighestSalaryEmployee.getSalary());
        } else {
            System.out.println("No employee found for the 5th highest salary.");
        }
    }
}
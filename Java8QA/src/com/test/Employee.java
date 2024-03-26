package com.test;

class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String department;
    private Double salary;
    private Integer age;
    private Integer yearOfJoining;
    private String gender;

    public Employee(Integer id, String firstName, String lastName, String department, Double salary, Integer age,
                    Integer yearOfJoining, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.yearOfJoining = yearOfJoining;
        this.gender = gender;
    }

    // Getter and Setter methods for the properties

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(Integer yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

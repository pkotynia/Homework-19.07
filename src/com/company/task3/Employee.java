package com.company.task3;

public class Employee {

    private String name;
    private Departments departments;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Departments departments, double salary) {
        this.name = name;
        this.departments = departments;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Departments getDepartments() {
        return departments;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  "name ='" + name + '\'' +
                ", departments =" + departments.toString().toLowerCase() +
                ", salary =" + salary;
    }
}

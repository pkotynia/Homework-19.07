package com.company.task3;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    public static void main(String[] args) {


        Employee e1 = new Employee("Jacek", Departments.IT, 12000);
        Employee e2 = new Employee("Wiola", Departments.MARKETING, 9000);
        Employee e3 = new Employee("Marian", Departments.PRODUCTION, 4000);
        Employee e4 = new Employee("Marek", Departments.IT, 15000);
        Employee e5 = new Employee("Małgosia", Departments.MARKETING, 11000);
        Employee e6 = new Employee("Wiesiek", Departments.PRODUCTION, 3500);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        EmployeeService employee = new EmployeeService();
        //Podpunkt 1
        List<String> listDepartmants = employee.getDepartments(employees);
        System.out.println("Departments:");
        System.out.println(listDepartmants);
        System.out.println();

        //Podpunkt 2
        Map<String, Double> maxSalaryByDeprtment = employee.getMaxSalaryByDeprtment(employees);
        System.out.println("max salary by deprtment");
        for (Map.Entry<String, Double> e : maxSalaryByDeprtment.entrySet()) {
            String key = e.getKey();
            Double value = e.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();

        //Podpunkt 3
        Map<String, Double> sumSalaryByDeprtment = employee.getSumSalaryByDeprtment(employees);
        System.out.println("sum salary by deprtment");
        for (Map.Entry<String, Double> e : sumSalaryByDeprtment.entrySet()) {
            String key = e.getKey();
            Double value = e.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();

        //Podpunkt 4
        System.out.println("The richest employee");
        System.out.println(employee.employeeWithMaxSalary(employees));
        System.out.println();

        //Podpunkt 5
        System.out.println("The richest department");
        System.out.println(employee.departmentWithMaxSalary(employees));
        System.out.println();

        //Podpunkt 6
        System.out.println("List of employees with salary above some number");
        displayList(employee.emplyeesWithSalaryAboveGiven(employees, 7000));
        System.out.println();

        //Podpunkt 7
        List<Employee> employeesFromIT = employee.listOfEmployeesFromOneDepartment(employees, Departments.IT);
        List<Employee> employeesFromProduction = employee.listOfEmployeesFromOneDepartment(employees, Departments.PRODUCTION);
        List<Employee> employeesFromMarketing = employee.listOfEmployeesFromOneDepartment(employees, Departments.MARKETING);
        List<List<Employee>> allEmployees = new ArrayList<>();
        allEmployees.add(employeesFromIT);
        allEmployees.add(employeesFromMarketing);
        allEmployees.add(employeesFromProduction);
        System.out.println("Combined names");
        System.out.println(employee.allEmplyeesNamesConcatenated(allEmployees));
        System.out.println();

        //Podpunkt 8


    }//end main


    List<String> getDepartments(List<Employee> employees) {
        Set<String> stringSet = new HashSet<>();
        for (Employee e : employees
        ) {
            stringSet.add(e.getDepartments().toString());
        }
        return new ArrayList<>(stringSet);
    }

    Map<String, Double> getMaxSalaryByDeprtment(Collection<Employee> employees) {

        Map<String, Double> mapMaxSalaryByDepartments = new HashMap<>();


        Optional<Employee> optionalEmployeeIT = employees.stream()
                .filter(e -> e.getDepartments().equals(Departments.IT))
                .max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));

        Optional<Employee> optionalEmployeeMarketing = employees.stream()
                .filter(e -> e.getDepartments().equals(Departments.MARKETING))
                .max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));

        Optional<Employee> optionalEmployeeProduction = employees.stream()
                .filter(e -> e.getDepartments().equals(Departments.PRODUCTION))
                .max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));

        mapMaxSalaryByDepartments.put(Departments.IT.toString(), optionalEmployeeIT.orElse(new Employee()).getSalary());
        mapMaxSalaryByDepartments.put(Departments.MARKETING.toString(), optionalEmployeeMarketing.orElse(new Employee()).getSalary());
        mapMaxSalaryByDepartments.put(Departments.PRODUCTION.toString(), optionalEmployeeProduction.orElse(new Employee()).getSalary());
        return mapMaxSalaryByDepartments;
    }

    Map<String, Double> getSumSalaryByDeprtment(Collection<Employee> employees) {
        Map<String, Double> mapSumSalaryByDepartments = new HashMap<>();

        double sumProduction = 0;
        double sumMarketing = 0;
        double sumIT = 0;
        for (Employee e : employees
        ) {
            if (e.getDepartments().equals(Departments.PRODUCTION)) {
                sumProduction += e.getSalary();
            }
            if (e.getDepartments().equals(Departments.IT)) {
                sumIT += e.getSalary();
            }
            if (e.getDepartments().equals(Departments.MARKETING)) {
                sumMarketing += e.getSalary();
            }
        }
        mapSumSalaryByDepartments.put(Departments.PRODUCTION.toString(), sumProduction);
        mapSumSalaryByDepartments.put(Departments.IT.toString(), sumIT);
        mapSumSalaryByDepartments.put(Departments.MARKETING.toString(), sumMarketing);
        return mapSumSalaryByDepartments;
    }

    Employee employeeWithMaxSalary(Collection<Employee> employees) {
        return (employees.stream()
                .max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))).orElse(new Employee());
    }

    String departmentWithMaxSalary(Collection<Employee> employees) {
        EmployeeService employeeService = new EmployeeService();
        Map<String, Double> salaryByDepartment = employeeService.getSumSalaryByDeprtment(employees);
        String s = "";
        double d = 0;
        for (Map.Entry<String, Double> e : salaryByDepartment.entrySet()) {
            if (e.getValue() > d) {
                d = e.getValue();
                s = e.getKey();
            }
        }
        return s;
    }

    List<Employee> emplyeesWithSalaryAboveGiven(Collection<Employee> employees,
                                                double givenSalary) {
        return employees.stream()
                .filter(e -> e.getSalary() > givenSalary)
                .collect(Collectors.toList());
    }

    String allEmplyeesNamesConcatenated(List<List<Employee>> eployees) {
        StringBuilder s = new StringBuilder();
        for (List<Employee> e : eployees
        ) {
            for (Employee e1 : e) {
                s.append(e1.getName());
            }
        }
        return s.toString();
    }

    List<Employee> listOfEmployeesFromOneDepartment(List<Employee> employees, Departments departments) {
        return employees.stream()
                .filter(e -> e.getDepartments().equals(departments))
                .collect(Collectors.toList());
    }

    String allEmplyeesNamesConcatenated(Iterable<Iterable<Employee>> eployees) {
        return "";
    }

    static void displayList(List<Employee> list) {
        for (Employee e : list
        ) {
            System.out.println(e);
        }
        System.out.println();
    }


}

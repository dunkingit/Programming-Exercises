package com.techelevator;

import java.lang.reflect.Constructor;

public class Employee {
    int employeeId;
    String firstName;
    String lastName;
    String department;
    double annualSalary;

    public Employee(int employeeId, String firstName, String lastName, double salary){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = salary;
    };

    public int getEmployeeId() {
        return employeeId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
//
        this.lastName = lastName;
    }

    public String getFullName() {
        return getLastName() + ", " + getFirstName() ;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void raiseSalary(double percent){
        this.annualSalary += (getAnnualSalary() * percent) / 100;
    };
}

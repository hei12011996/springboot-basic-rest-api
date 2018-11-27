package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private Integer employeesNumber;
    private List<Employee> employees = new ArrayList<Employee>();

    public Company(){

    }

    public Company(String companyName, Integer employeesNumber, List<Employee> employees){
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
        this.employees.addAll(employees);
    }


    public String getCompanyName() {
        return companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public List<Employee> employees() {
        return employees;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }
}

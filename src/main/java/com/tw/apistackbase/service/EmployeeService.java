package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);
    Employee findById(Long id);
    Employee update(Long id, Employee employee);
    Employee delete(Long id);

    List<Employee> getAll();
    List<Employee> findByGender(String gender);
    List<Employee> findByPageAndPageSize(Integer page, Integer pageSize);

}

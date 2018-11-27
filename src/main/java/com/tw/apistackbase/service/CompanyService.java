package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface CompanyService {

    Company add(Company company);
    Company findById(Long id);
    Company update(Long id, Company company);
    Company delete(Long id);

    List<Employee> getEmployeeUnderCompany(Long id);
    List<Company> getAll();
    List<Company> findByPageAndPageSize(Integer page, Integer pageSize);
}

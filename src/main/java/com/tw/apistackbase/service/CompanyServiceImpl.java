package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {
    private static Map<Long, Company> companiesStorage = new HashMap<Long, Company>();

    @Autowired
    private EmployeeService employeeService;

    public Company add(Company company){
        return null;
    }

    public Company findById(Long id){
        return companiesStorage.get(id);
    }

    public Company update(Long id, Company company){
        return null;
    }

    public Company delete(Long id){
        return companiesStorage.remove(id);
    }

    public List<Employee> getEmployeeUnderCompany(Long id){
        return companiesStorage.get(id).getEmployees();
    }

    public List<Company> getAll(){
        return new ArrayList<>(companiesStorage.values());
    }

    public List<Company> findByPageAndPageSize(Integer page, Integer pageSize){
        return null;
    }
}

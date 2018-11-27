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
    private Map<Long, Company> companiesStorage = new HashMap<Long, Company>();

    @Autowired
    private EmployeeService employeeService = new EmployeeServiceImpl();

    public Company add(Company company){
        Long latestId = Long.valueOf(companiesStorage.size() + 1);
        companiesStorage.put(latestId, company);
        for (Employee employee : company.getEmployees()){
            employeeService.upsert(employee.getId(), employee);
        }
        return company;
    }

    public Company findById(Long id){
        return companiesStorage.get(id);
    }

    public Company update(Long id, Company company){
        if (!companiesStorage.containsKey(id)) {
            companiesStorage.put(id, company);
            for (Employee employee : company.getEmployees()) {
                employeeService.upsert(employee.getId(), employee);
            }
            return company;
        }
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
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, companiesStorage.size());
        if (endIndex < startIndex) {
            return new ArrayList<>();
        }
        return new ArrayList<>(companiesStorage.values()).subList(startIndex, endIndex);
    }
}

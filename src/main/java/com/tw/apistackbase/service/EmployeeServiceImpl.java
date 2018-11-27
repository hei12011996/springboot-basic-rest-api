package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private static Map<Long, Employee> employeeStorage = new HashMap<Long, Employee>();

    public Employee add(Employee employee){
        Long latestId = Long.valueOf(employeeStorage.size() + 1);
        employee.setId(latestId);
        employeeStorage.put(latestId, employee);
        return employee;
    }

    public Employee findById(Long id){
        return employeeStorage.get(id);
    }

    public Employee update(Long id, Employee employee){
        if (!employeeStorage.containsKey(id)) {
            return null;
        }
        employee.setId(id);
        employeeStorage.put(id, employee);
        return employee;
    }

    public Employee delete(Long id){
        return employeeStorage.remove(id);
    }

    public List<Employee> getAll(){
        return new ArrayList<>(employeeStorage.values());
    }

    public List<Employee> findByGender(String gender){
        return employeeStorage.values().stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }

    public List<Employee> findByPageAndPageSize(Integer page, Integer pageSize){
        int startindex = (page - 1) * pageSize;
        return new ArrayList<>(employeeStorage.values()).subList(startindex, startindex + pageSize);
    }
}

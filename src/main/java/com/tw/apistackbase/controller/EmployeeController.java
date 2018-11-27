package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import com.tw.apistackbase.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> queryByPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(employeeService.findByPageAndPageSize(page, pageSize));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> findByGender(@RequestParam String gender) {
        return ResponseEntity.ok(employeeService.findByGender(gender));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.add(employee));
    }
}

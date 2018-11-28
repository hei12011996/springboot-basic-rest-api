package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping(produces = {"application/json"}, params = {"gender"})
    public ResponseEntity<List<Employee>> findByGender(@RequestParam(value = "gender") String gender){
        return ResponseEntity.ok(employeeService.findByGender(gender));
    }

    @GetMapping(produces = {"application/json"}, params = {"page", "pageSize"})
    public ResponseEntity<List<Employee>> findByPageAndPageSize(@RequestParam(value = "page") Integer page,
                                                @RequestParam(value = "pageSize") Integer pageSize){
        return ResponseEntity.ok(employeeService.findByPageAndPageSize(page, pageSize));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.add(employee));
    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.delete(id));
    }
}

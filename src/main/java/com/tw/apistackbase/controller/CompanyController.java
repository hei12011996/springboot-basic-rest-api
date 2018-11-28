package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping(path = "/{id}/employees", produces = {"application/json"})
    public ResponseEntity<List<Employee>> queryEmployeesUnderCompany(@PathVariable Long id){
        return ResponseEntity.ok(companyService.getEmployeeUnderCompany(id));
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> getAll(){
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping(produces = {"application/json"}, params = {"page", "pageSize"})
    public ResponseEntity<List<Company>> findByPageAndPageSize(@RequestParam(value = "page") Integer page,
                                                                @RequestParam(value = "pageSize") Integer pageSize){
        return ResponseEntity.ok(companyService.findByPageAndPageSize(page, pageSize));
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.add(company));
    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.update(id, company));
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.delete(id));
    }
}

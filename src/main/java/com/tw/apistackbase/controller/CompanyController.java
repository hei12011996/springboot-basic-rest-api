package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
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

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Company>> query(@RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "pageSize", required = false) Integer pageSize){
        if (page != null && pageSize != null){
            return ResponseEntity.ok(companyService.findByPageAndPageSize(page, pageSize));
        }
        return ResponseEntity.ok(companyService.getAll());
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.add(company));
    }
}

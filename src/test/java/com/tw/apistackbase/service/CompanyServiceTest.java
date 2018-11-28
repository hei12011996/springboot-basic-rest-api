package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CompanyServiceTest {
    private static final String DUMMY_COMPANY_NAME = "dummyCompanyName";
    private static final String DUMMY_EMPLOYEE_NAME = "dummyEmployeeName";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final Integer AGE_TWENTY_TWO = 22;
    private static final Integer AGE_FIFTY = 50;
    private static final Integer SALARY = 25000;
    private static final Integer SALARY_UPDATED = 50000;

    @Test
    public void should_return_company_while_add_company(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Employee employee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);
        Company company = new Company(DUMMY_COMPANY_NAME, 1, employees);

        Company returnCompany = service.add(company);

        assertEquals(DUMMY_COMPANY_NAME, returnCompany.getCompanyName());
        assertEquals(new Integer(1), returnCompany.getEmployeesNumber());
        assertEquals(employees, returnCompany.getEmployees());
    }

    @Test
    public void should_return_company_while_find_company_by_id(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        List<Employee> employees = new ArrayList<Employee>();
        Company firstCompany = new Company(DUMMY_COMPANY_NAME, 1, employees);
        Company secondCompany = new Company(DUMMY_COMPANY_NAME, 1, employees);

        service.add(firstCompany);
        service.add(secondCompany);

        assertSame(secondCompany, service.findById(2L));
    }

    @Test
    public void should_return_company_while_update_company(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Employee firstEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        Company company = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee));
        Company updatedCompany = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee, secondEmployee));
        service.add(company);

        Company returnCompany = service.update(1L, updatedCompany);

        assertSame(updatedCompany, returnCompany);
        assertEquals(updatedCompany.getEmployees(), Arrays.asList(firstEmployee, secondEmployee));
    }

    @Test
    public void should_return_null_while_update_company_given_non_existing_id(){
        Long nonExistingId = 2L;
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Company company = new Company(DUMMY_COMPANY_NAME, 1, new ArrayList<>());
        Company updatedCompany = new Company(DUMMY_COMPANY_NAME, 1, new ArrayList<>());
        service.add(company);

        Company returnCompany = service.update(nonExistingId, updatedCompany);

        assertNull(returnCompany);
    }

    @Test
    public void should_return_company_while_delete_company(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Company company = new Company(DUMMY_COMPANY_NAME, 1, new ArrayList<>());
        service.add(company);

        service.delete(1L);

        assertEquals(0, service.getAll().size());
    }

    @Test
    public void should_return_all_companies_while_get_all_companies(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Employee firstEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        Company firstCompany = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee));
        Company secondCompany = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee, secondEmployee));
        service.add(firstCompany);
        service.add(secondCompany);

        assertEquals(Arrays.asList(firstCompany, secondCompany), service.getAll());
    }

    @Test
    public void should_return_all_employees_under_company_while_query_employees_under_a_company(){
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Employee firstEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        List<Employee> employees = Arrays.asList(firstEmployee, secondEmployee);
        Company company = new Company(DUMMY_COMPANY_NAME, 1, employees);
        service.add(company);

        List<Employee> returnEmployees = service.getEmployeeUnderCompany(1L);

        assertEquals(employees, returnEmployees);
    }

    @Test
    public void should_return_companies_while_find_companies_by_page_and_page_size(){
        Integer page = 2;
        Integer pageSize = 1;
        CompanyService service = new CompanyServiceImpl(new EmployeeServiceImpl());
        Employee firstEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_EMPLOYEE_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        Company firstCompany = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee));
        Company secondCompany = new Company(DUMMY_COMPANY_NAME, 1, Arrays.asList(firstEmployee, secondEmployee));
        service.add(firstCompany);
        service.add(secondCompany);

        List<Company> returnCompanies = service.findByPageAndPageSize(page, pageSize);

        assertEquals(Arrays.asList(secondCompany), returnCompanies);
    }
}

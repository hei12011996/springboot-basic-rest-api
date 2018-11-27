package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {


    public static final String DUMMY_NAME = "dummyName";
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final Integer AGE_TWENTY_TWO = 22;
    public static final Integer AGE_FIFTY = 50;
    public static final Integer SALARY = 25000;
    public static final Integer SALARY_UPDATED = 50000;

    @Test
    public void should_return_employee_while_add_employee(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee employee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);

        Employee returnEmployee = service.add(employee);

        assertEquals(new Long(1L), returnEmployee.getId());
        assertEquals(DUMMY_NAME, returnEmployee.getName());
        assertEquals(AGE_TWENTY_TWO, returnEmployee.getAge());
        assertEquals(MALE, returnEmployee.getGender());
        assertEquals(SALARY, returnEmployee.getSalary());
    }

    @Test
    public void should_return_employee_while_find_employee_by_id(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee employee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        service.add(employee);

        Employee returnEmployee = service.findById(1L);

        assertEquals(new Long(1L), returnEmployee.getId());
        assertEquals(DUMMY_NAME, returnEmployee.getName());
        assertEquals(AGE_TWENTY_TWO, returnEmployee.getAge());
        assertEquals(MALE, returnEmployee.getGender());
        assertEquals(SALARY, returnEmployee.getSalary());
    }

    @Test
    public void should_return_employee_while_update_employee(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee employee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee updatedEmployee = new Employee(0L, DUMMY_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        service.add(employee);

        Employee returnEmployee = service.update(1L, updatedEmployee);

        assertEquals(new Long(1L), returnEmployee.getId());
        assertEquals(DUMMY_NAME, returnEmployee.getName());
        assertEquals(AGE_FIFTY, returnEmployee.getAge());
        assertEquals(FEMALE, returnEmployee.getGender());
        assertEquals(SALARY_UPDATED, returnEmployee.getSalary());
    }

    @Test
    public void should_return_employee_while_delete_employee(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee employee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        service.add(employee);

        service.delete(1L);

        assertEquals(0, service.getAll().size());
    }

    @Test
    public void should_return_all_employees_while_get_all_employees(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee firstEmployee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_NAME, AGE_FIFTY, FEMALE, SALARY_UPDATED);
        service.add(firstEmployee);
        service.add(secondEmployee);

        assertEquals(Arrays.asList(firstEmployee, secondEmployee), service.getAll());
    }

    @Test
    public void should_return_employees_while_find_employee_by_gender(){
        EmployeeService service = new EmployeeServiceImpl();
        Employee firstEmployee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, FEMALE, SALARY);
        service.add(firstEmployee);
        service.add(secondEmployee);

        List<Employee> returnEmployees = service.findByGender(MALE);

        assertEquals(Arrays.asList(firstEmployee), returnEmployees);
    }

    @Test
    public void should_return_employees_while_find_employee_by_page_and_page_size(){
        Integer page = 2;
        Integer pageSize = 1;
        EmployeeService service = new EmployeeServiceImpl();
        Employee firstEmployee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, MALE, SALARY);
        Employee secondEmployee = new Employee(0L, DUMMY_NAME, AGE_TWENTY_TWO, FEMALE, SALARY);
        service.add(firstEmployee);
        service.add(secondEmployee);

        List<Employee> returnEmployees = service.findByPageAndPageSize(page, pageSize);

        assertEquals(Arrays.asList(secondEmployee), returnEmployees);
    }
}

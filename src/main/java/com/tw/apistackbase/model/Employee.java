package com.tw.apistackbase.model;

public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;

    public Employee(){
    }

    public Employee(Long id, String name, Integer age, String gender, Integer salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Integer getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public Integer getSalary(){
        return this.salary;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setSalary(Integer salary){
        this.salary = salary;
    }

}

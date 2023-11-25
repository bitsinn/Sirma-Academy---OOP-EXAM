package com.system.management.staff;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Employee implements Serializable {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String department;
    @JsonProperty
    private String role;
    @JsonProperty
    private double salary;

    public Employee(long id, String name, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
    public Employee(){}

    @Override
    public String toString() {
        return "{" + "\n" +
                "id: " + id + "\n" +
                "name: " + name + "\n" +
                "department: " + department + "\n" +
                "role: " + role +  "\n" +
                "salary: " + salary + "\n" +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }
}

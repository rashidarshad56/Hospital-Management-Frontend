package com.cg.hospital.model;


public class Department {
    private Integer departmentId;
    private String name;

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Optional: for Thymeleaf compatibility
    public Integer getId() { return departmentId; }
}
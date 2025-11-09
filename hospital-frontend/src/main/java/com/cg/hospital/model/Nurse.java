package com.cg.hospital.model;

public class Nurse {
    private Integer employeeId;
    private String name;
    private String position;
    private String registered; // or Boolean if backend sends true/false
    private Integer ssn;

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getRegistered() { return registered; }
    public void setRegistered(String registered) { this.registered = registered; }

    public Integer getSsn() { return ssn; }
    public void setSsn(Integer ssn) { this.ssn = ssn; }
}

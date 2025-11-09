package com.cg.hospital.model;

public class PhysicianDTO {
    private String name;
    private String position;
    private int employeeId;
    public PhysicianDTO() {}

    public PhysicianDTO(int employeeId, String name, String position) {
    	this.employeeId = employeeId;
        this.name = name;
        this.position = position;
    }

    public String getName() { return name; }
    public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
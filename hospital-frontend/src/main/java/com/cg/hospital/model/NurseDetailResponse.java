package com.cg.hospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class NurseDetailResponse {

    @JsonProperty("EmployeeID")
    private Integer employeeId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Position")
    private String position;

    @JsonProperty("Registered")
    private Boolean registered;

    @JsonProperty("SSN")
    private Integer ssn;

    @JsonProperty("OnCalls")
    private List<OnCall> onCalls;

    @JsonProperty("message")
    private String message;

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Boolean getRegistered() { return registered; }
    public void setRegistered(Boolean registered) { this.registered = registered; }

    public Integer getSsn() { return ssn; }
    public void setSsn(Integer ssn) { this.ssn = ssn; }

    public List<OnCall> getOnCalls() { return onCalls; }
    public void setOnCalls(List<OnCall> onCalls) { this.onCalls = onCalls; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

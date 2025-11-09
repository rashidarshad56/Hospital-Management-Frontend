package com.cg.hospital.model;


public class AnkithaPatientModel {
	private int ssn;
    private String name;
    private String address;
    private String phone;
    private long insuranceId;
    private int pcp;
	public int getPcp() {
		return pcp;
	}
	public void setPcp(int pcp) {
		this.pcp = pcp;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(long insuranceId) {
		this.insuranceId = insuranceId;
	}

}


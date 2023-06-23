package com.sistemi.informativi.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable{

	private String vatNumber;
	private String businessName;
	private String addressLocation;
	private int employeesNumber;
	
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getAddressLocation() {
		return addressLocation;
	}
	public void setAddressLocation(String adressLocation) {
		this.addressLocation = adressLocation;
	}
	public int getEmployeesNumber() {
		return employeesNumber;
	}
	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}
	
	protected CompanyDTO() {
		
	}
	public CompanyDTO(String vatNumber, String businessName, String addressLocation, int employeesNumber) {

		this.vatNumber = vatNumber;
		this.businessName = businessName;
		this.addressLocation = addressLocation;
		this.employeesNumber = employeesNumber;
	}
	
}

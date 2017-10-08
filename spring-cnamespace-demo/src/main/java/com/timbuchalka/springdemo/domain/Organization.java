package com.timbuchalka.springdemo.domain;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private Address address;
	
	public Organization(String companyName, int yearOfIncorporation, Address address) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", address=" + address + "]";
	}

}

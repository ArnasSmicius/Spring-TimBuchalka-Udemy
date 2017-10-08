package com.timbuchalka.springdemo;

public class OrganizationFactory {
	
	public Organization getInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoking instance factory method...");
		return new Organization(companyName, yearOfIncorporation);
	}

}

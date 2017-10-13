package com.timbuchalka.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.service.BusinessService;

@Component("myorg")
public class Organization {
	
	@Value("${nameOfCompany}")
	private String companyName;
	
	@Value("${startUpYear}")
	private int yearOfIncorporation;
	
	@Value("${postalCode}")
	private String postalCode;
	
	@Value("${empCount: 22222}")
	private int employeeCount;
	
	@Value("${corporateSlogan: We build world class slogan!}")
	private String slogan;
	
	private String missionStatement;
	
	@Autowired
	private Environment env;
	
	private BusinessService businessService;
	
	public Organization() {
		System.out.println("Default constructor called");
	}
	
	public Organization(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("constructor called: " + companyName + " " + yearOfIncorporation);
	}

	public String corporateSlogan() {
		missionStatement = env.getProperty("statement");
		return missionStatement + " and also " + slogan;
	}
	
//	public void initialize() {
//		System.out.println("Organization: initialize method called");
//	}
//	
//	public void destroy() {
//		System.out.println("Organization: destroy method called");
//	}
	
	public void postConstruct() {
		System.out.println("Organization: postConstruct called...");
	}
	
	public void preDestroy() {
		System.out.println("Organization: preDestroy called...");
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called: " + postalCode);
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmployeeCount called: " + employeeCount);
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called: " + slogan);
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called: " + businessService);
	}
	
	public String corporateService() {
		return businessService.offerService(companyName);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}

}

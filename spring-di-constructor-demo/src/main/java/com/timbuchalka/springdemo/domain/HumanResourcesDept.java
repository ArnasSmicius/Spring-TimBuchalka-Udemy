 package com.timbuchalka.springdemo.domain;

import com.timbuchalka.springdemo.service.RecruitmentService;

public class HumanResourcesDept implements Department {
	
	private String deptName;
	private RecruitmentService recruitmentService;
	private Organization organization;

	public HumanResourcesDept(RecruitmentService recruitmentService, Organization organization) {
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitEmployees(organization.getCompanyName(), deptName, numberOfRecruitments);
		return hiringFacts;
	}

}

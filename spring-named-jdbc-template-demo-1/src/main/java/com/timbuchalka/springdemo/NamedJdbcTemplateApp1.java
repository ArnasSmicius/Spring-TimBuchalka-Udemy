package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Component
public class NamedJdbcTemplateApp1 {

	@Autowired
	private OrganizationDao dao;

	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {
		// Creating seed data.
		daoUtils.createSeedData(dao);

		// List organizations.
		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		// Create a new Organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.createOperation);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		// Get a sinle organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, daoUtils.readOperation);

		// Updating slogan for an organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build ** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		// Delete an organization
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);

		// Cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
	}

	public static void main(String[] args) {

		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		NamedJdbcTemplateApp1 mainApp = ctx.getBean(NamedJdbcTemplateApp1.class);
		mainApp.actionMethod();

		// Close the application context
		((ClassPathXmlApplicationContext) ctx).close();

		// Create the bean
//		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
	}

}

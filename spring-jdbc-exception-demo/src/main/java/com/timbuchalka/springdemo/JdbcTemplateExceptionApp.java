package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateExceptionApp {

	public static void main(String[] args) {
		
		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		OrganizationDao dao = (OrganizationDao) ctx.getBean("orgDao");
		List<Organization> orgs = null;
		try {
			orgs = dao.getAllOrganizations();
		} catch(BadSqlGrammarException bge) {
			System.out.println("SUB EXCEPTION MESSAGE: " + bge.getMessage());
			System.out.println("SUB EXCEPTION CLASS: " + bge.getClass());
		} catch(DataAccessException dae) {
			System.out.println("EXCEPTION MESSAGE: " + dae.getMessage());
			System.out.println("EXCEPTION CLASS: " + dae.getClass());
		}
//		dao.getAllOrganizations();
		for (Organization org : orgs) {
			System.out.println(org);
		}
		
		// Close the application context
		((ClassPathXmlApplicationContext) ctx).close();
		

	}

}

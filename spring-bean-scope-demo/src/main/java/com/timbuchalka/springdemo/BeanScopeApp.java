package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {
		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("98989");
		
		// Invoke the company's slogan by the bean
//		System.out.println(org.corporateSlogan());
//		
//		System.out.println(org.corporateService());
	
		// Print organization info
		System.out.println(org);
		System.out.println(org2);
		
		if (org == org2) {
			System.out.println("Singleton scope test: org and org2 points to the same instance");
		} else {
			System.out.println("Both org and org2 are separate instances");
		}

		
		// Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}

package com.timbuchalka.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.domain.Organization;

public class DISetterApp {

	public static void main(String[] args) {
		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		// Invoke the company's slogan by the bean
		System.out.println(org.corporateSlogan());
		
		System.out.println(org.corporateService());
		
		// Print organization info
		System.out.println(org);
		
		// Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}

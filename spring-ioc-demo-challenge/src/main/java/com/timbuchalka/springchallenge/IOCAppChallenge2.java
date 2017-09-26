package com.timbuchalka.springchallenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCAppChallenge2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-challenge.xml");
		
		City city = (City) ctx.getBean("city");
		
		city.cityName();
		
		((ClassPathXmlApplicationContext) ctx).close();

	}

}

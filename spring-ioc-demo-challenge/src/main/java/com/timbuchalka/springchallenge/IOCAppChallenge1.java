package com.timbuchalka.springchallenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans-challenge.xml");
		
		City city = (City) ctx.getBean("city");
		
		city.cityName();
		
		((FileSystemXmlApplicationContext) ctx).close();

	}

}

package com.timbuchalka.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value="/home")
	public String home() {
		// This method would open "requestMappingAndParamHome.jsp" View
		return "requestMappingAndParamHome";
	}
}

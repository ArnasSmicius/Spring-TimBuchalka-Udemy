package com.timbuchalka.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/requestMappingAndParamDemo")
@Controller
public class RequestMappingAndParamDemoController {

	private static Logger LOGGER = LoggerFactory.getLogger(RequestMappingAndParamDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		// This method would open "requestMappingAndParamHome.jsp" View
		return "requestMappingAndParamHome";
	}

	// test 1: Testing @RequestParam without explicit attributes
	@RequestMapping(value = "/test1")
	public String requestMappingAndParamTest1(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test1");
		return "requestMappingAndParamResults";
	}

	// test 2: Testing @RequestMapping 'method' attribute
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String requestMappingAndParamTest2(@RequestParam("orgName") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test2");
		return "requestMappingAndParamResults";
	}

	// test 2: Testing @RequestMapping fall back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
//	@RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST })
	public String requestMappingAndParamTest3() {
		return "fallback";
	}
}

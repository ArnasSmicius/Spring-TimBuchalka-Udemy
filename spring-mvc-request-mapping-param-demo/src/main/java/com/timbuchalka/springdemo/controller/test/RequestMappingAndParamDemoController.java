package com.timbuchalka.springdemo.controller.test;

import javax.servlet.http.HttpServletRequest;

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

	// test 3: Testing @RequestMapping fall back feature
	@RequestMapping(value = "*", method = RequestMethod.GET)
	// @RequestMapping(value = "*", method = { RequestMethod.GET, RequestMethod.POST
	// })
	public String requestMappingAndParamTest3() {
		return "fallback";
	}

	// test 4: Testing @RequestParam 'defaultValue' attribute
	@RequestMapping(value = "/test4")
	public String requestMappingAndParamTest4(
			@RequestParam(value = "orgName", defaultValue = "Anonymous Organization") String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test4");
		return "requestMappingAndParamResults";
	}

	// test 5: Testing @RequestParam without 'name' or 'value' attributes
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String requestMappingAndParamTest5(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test5");
		return "requestMappingAndParamResults";
	}

	// // test 6, subtest 1: Testing @RequestMapping
	// @RequestMapping(value = "/test6")
	// public String requestMappingAndParamTest6Subtest1(@RequestParam String
	// orgName, Model model) {
	// model.addAttribute("orgName", orgName);
	// model.addAttribute("testSerial", "test6-subtest1");
	// return "requestMappingAndParamResults2";
	// }

	// test 6, subtest 1: Testing removal of @RequestMapping ambiguity with the same
	// base URI but with a different parameter
	@RequestMapping(value = "/test6", params = "orgName")
	public String requestMappingAndParamTest6Subtest1(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6-subtest1");
		return "requestMappingAndParamResults2";
	}

	// test 6, subtest 2: Testing removal of @RequestMapping ambiguity with the same
	// base URI but with a different parameter
	@RequestMapping(value = "/test6", params = "empCount")
	public String requestMappingAndParamTest6Subtest2(@RequestParam String empCount, Model model) {
		model.addAttribute("orgName", empCount);
		model.addAttribute("testSerial", "test6-subtest2");
		return "requestMappingAndParamResults2";
	}

	// test 6, subtest 3: Testing removal of @RequestMapping with multiple request
	// params
	@RequestMapping(value = "/test6/subtest3", method = RequestMethod.GET, params = { "orgName", "empCount" })
	public String requestMappingAndParamTest6Subtest3(@RequestParam String orgName, @RequestParam String empCount,
			Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("empCount", empCount);
		model.addAttribute("testSerial", "test6-subtest3");
		return "requestMappingAndParamResults2";
	}

	// test 6, subtest 4: Testing with multiple request params and @RequestParam
	// with single param
	@RequestMapping(value = "/test6/subtest4", method = RequestMethod.GET, params = { "orgName", "empCount" })
	public String requestMappingAndParamTest6Subtest4(@RequestParam String orgName, Model model) {
		model.addAttribute("orgName", orgName);
		model.addAttribute("testSerial", "test6-subtest4");
		return "requestMappingAndParamResults2";
	}

	// test 7 & 8: Testing @RequestParam with multiple request URI's
	@RequestMapping(value = {"/test7", "/test8"}, method = RequestMethod.GET)
	public String requestMappingAndParamTest7and8(@RequestParam String orgName, Model model, HttpServletRequest request) {
		model.addAttribute("orgName", orgName);
		LOGGER.info(request.getRequestURL().toString());
		if (request.getRequestURL().toString().contains("test7")) {
			model.addAttribute("testSerial", "test7");
		} else {
			model.addAttribute("testSerial", "test8");
		}
		return "requestMappingAndParamResults2";
	}

	// // test 6, subtest 2: Testing @RequestMapping
	// @RequestMapping(value = "/test6")
	// public String requestMappingAndParamTest6Subtest2(@RequestParam String
	// empCount, Model model) {
	// model.addAttribute("orgName", empCount);
	// model.addAttribute("testSerial", "test6-subtest2");
	// return "requestMappingAndParamResults2";
	// }

}

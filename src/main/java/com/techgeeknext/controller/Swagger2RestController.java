package com.techgeeknext.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Swagger2RestController {

	@RequestMapping(method = RequestMethod.GET, value = "/api/home-page")
	public String homePage() {
		return "TechGeekNext - Welcome to Swagger Profile Example!";
	}
}

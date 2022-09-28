package com.springdatarest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("getallalien")
	@ResponseBody
	public String getallaliens() {
		System.out.println("Java");
		return "Test Response Body";
	}

}

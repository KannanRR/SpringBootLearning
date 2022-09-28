package com.webapp.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendparamsinurltojspController {
	
	@RequestMapping("sendparams")
	public String sendparams(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("Welcome to Sendparams Controller .." + name);
		session.setAttribute("name", name);
		return "sendparams";
	}

}

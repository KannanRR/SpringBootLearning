package com.webapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutusController {
	
	@RequestMapping("about")
	public String aboutus() {
		return "aboutus";
	}

}

package com.webapp.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SendparamsinurltojspControlleradv {
	
	@RequestMapping("sendparamsadv")
	public String sendparams(@RequestParam("Myname") String name, HttpSession session) {
		// using session to jsp
		System.out.println("Welcome to Sendparams Controller .." + name);
		session.setAttribute("name", name);
		return "sendparams";
	}
	
	@RequestMapping("sendparamswithoutsession")
	public ModelAndView sendparamswithoutsession(@RequestParam("Myname") String name) {
		// using Modelandview to jsp
		ModelAndView mv = new ModelAndView();
		System.out.println("Welcome to Sendparams Controller .." + name);
		mv.addObject("name", name);
		mv.setViewName("sendparams");
		return mv;
	}

	@RequestMapping("sendparamsobj")
	public ModelAndView sendparamsasobj(Alien alien) {
		// using class object to jsp
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("sendparamsobj");
		return mv;
	}
}

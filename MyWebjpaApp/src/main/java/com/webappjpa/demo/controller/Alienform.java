package com.webappjpa.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.webappjpa.demo.dao.AlienRepo;
import com.webappjpa.demo.model.Alien;

@Controller
public class Alienform {
	
	@Autowired
	AlienRepo repo;
	@RequestMapping("alienform")
	public String sendparams() {

		return "alienform";
	}
	
	@RequestMapping("addalien")
	public String addalien(Alien alien) {
		repo.save(alien);
		return "alienform";
	}
	
	@RequestMapping("getalien")
	public ModelAndView getalien(@RequestParam int aid) {
		// using class object to jsp
		ModelAndView mv = new ModelAndView();
		// we have to use optional object here for null pointer exception error
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(2));
		System.out.println(repo.findByTechSorted("Java"));
		mv.addObject("obj", alien);
		mv.setViewName("getalien");
		return mv;
	}
	
	@RequestMapping("getallalien")
	@ResponseBody
	public String getallaliens() {
		return repo.findAll().toString();
	}
	
	@RequestMapping("/getaalienbyid/{aid}")
	@ResponseBody
	public String getalienbyid(@PathVariable("aid") int aid) {
		return repo.findById(aid).toString();
	}
	
	@RequestMapping(path="/getalienbyidjson/{aid}",produces="application/json")
	@ResponseBody
	public Optional<Alien> getalienbyidjson(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

}

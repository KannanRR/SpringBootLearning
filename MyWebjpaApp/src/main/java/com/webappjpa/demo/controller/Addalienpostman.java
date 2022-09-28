package com.webappjpa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webappjpa.demo.dao.AlienRepo;
import com.webappjpa.demo.model.Alien;

@RestController
public class Addalienpostman {
	
	@Autowired
	AlienRepo repo;
	
	@PostMapping("addalienpostman")
	public Alien addalienpostman(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PutMapping("addalienpostman")
	public Alien addorupdatealienpostman(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("addalienpostman/{aid}")
	public String addalienpostman(@PathVariable("aid") int aid) {
		System.out.println(aid);

		Alien a = repo.getReferenceById(aid);
		repo.delete(a);
		return "Deleted Succesfully";
	}

}

package com.varahi.varahiframes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.varahi.varahiframes.Model.Products;

@RestController
public class UploadDetailsController {
	@PostMapping("/")
	
	public ResponseEntity<?> UploadDetails(@RequestBody Products pro)
	{
		System.out.println(pro.getName());
		System.out.println("In UploadDetailsController:UploadDetails");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/login")
	public String DisplayLogin()
	{
		/*
		 * ModelAndViewContainer m=new ModelAndViewContainer();
		 * m.setViewName("login.html");
		 */
		return "login.html";
		
	}

}

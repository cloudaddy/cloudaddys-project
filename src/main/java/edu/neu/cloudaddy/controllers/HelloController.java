package edu.neu.cloudaddy.controllers;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Controller
public class HelloController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired 
	private DataSource dataSource;
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		try{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName(); //get logged in username'
		      //System.out.println("name : " + name);
		      model.addAttribute("username", name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "hello";
	}
}

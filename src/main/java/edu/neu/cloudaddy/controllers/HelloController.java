package edu.neu.cloudaddy.controllers;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import edu.neu.cloudaddy.model.Report;
import edu.neu.cloudaddy.model.Supplier;
import edu.neu.cloudaddy.model.User;
import edu.neu.cloudaddy.service.ReportService;
import edu.neu.cloudaddy.service.SupplierService;
import edu.neu.cloudaddy.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ReportService reportService;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello(Model model, HttpServletRequest request) {
		try{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
		      //System.out.println("name : " + name);
		      HttpSession session = request.getSession();
		      session.setAttribute("username", name);
		      User user = userService.getUserIdService(name);
		      ArrayList<Supplier> suppliers = supplierService.getSuppliersService();
		      if(user.getId() != 0){
		    	  ArrayList<Report> reports = reportService.getReportService(user.getId());
		    	  model.addAttribute("reports", reports);
		      }
		    	  
		      
		      model.addAttribute("suppliers", suppliers);
		      model.addAttribute("username", name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "hello";
	}
}

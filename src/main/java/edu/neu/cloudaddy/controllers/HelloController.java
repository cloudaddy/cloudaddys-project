package edu.neu.cloudaddy.controllers;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import edu.neu.cloudaddy.model.Product;
import edu.neu.cloudaddy.model.Supplier;
import edu.neu.cloudaddy.service.SupplierService;

@Controller
public class HelloController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired
	private SupplierService supplierService;

	@RequestMapping("/hello")
	public String hello(Model model) {
		try{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName(); //get logged in username'
		      //System.out.println("name : " + name);
		      ArrayList<Supplier> suppliers = supplierService.getSuppliersService();
		      model.addAttribute("suppliers", suppliers);
		      model.addAttribute("username", name);
		      //model.addAttribute("products", new ArrayList<Product>());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "hello";
	}
}

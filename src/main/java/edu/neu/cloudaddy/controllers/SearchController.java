package edu.neu.cloudaddy.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import edu.neu.cloudaddy.model.Product;
import edu.neu.cloudaddy.service.ProductService;

@Controller
public class SearchController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired
	private ProductService productService;

	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(Model model, HttpServletRequest request) {
		try {
			int suppId = Integer.parseInt(request.getParameter("prod"));
			
			ArrayList<Product> products = productService
					.getProductsService(suppId);
			System.out.println("suppId :" + suppId);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello";
	}
}

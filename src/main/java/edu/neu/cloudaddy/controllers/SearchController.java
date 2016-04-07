package edu.neu.cloudaddy.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import edu.neu.cloudaddy.model.Product;
import edu.neu.cloudaddy.model.Supplier;
import edu.neu.cloudaddy.service.ProductService;
import edu.neu.cloudaddy.service.SupplierService;

@Controller
public class SearchController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(value="/search")
	public String search(Model model, HttpServletRequest request) {
		try {
			int suppId = Integer.parseInt(request.getParameter("prod"));
			ArrayList<Supplier> suppliers = supplierService.getSuppliersService();
			ArrayList<Product> products = productService.getProductsService(suppId);
			System.out.println("suppId :" + suppId);
			
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello";
	}
}

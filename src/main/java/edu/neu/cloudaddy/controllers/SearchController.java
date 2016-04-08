package edu.neu.cloudaddy.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import edu.neu.cloudaddy.model.Product;
import edu.neu.cloudaddy.model.Report;
import edu.neu.cloudaddy.model.Supplier;
import edu.neu.cloudaddy.model.User;
import edu.neu.cloudaddy.service.ProductService;
import edu.neu.cloudaddy.service.ReportService;
import edu.neu.cloudaddy.service.SupplierService;
import edu.neu.cloudaddy.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private ThymeleafViewResolver resolver;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ReportService reportService;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/search")
	public String search(Model model, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = userService.getUserIdService((String) session.getAttribute("username"));
		    if(user.getId() != 0){
		      ArrayList<Report> reports = reportService.getReportService(user.getId());
		      model.addAttribute("reports", reports);
		    }
			int suppId = Integer.parseInt(request.getParameter("prod"));
			ArrayList<Supplier> suppliers = supplierService.getSuppliersService();
			ArrayList<Product> products = productService.getProductsService(suppId);
			productService.writeProductsService(suppId);
			System.out.println("supplier id : " + suppId);
			String supplier_company = supplierService.getSupplierNameService(suppId);
			System.out.println("supplier_company" + supplier_company);
			if(supplier_company ==null)
				supplier_company ="";
			productService.saveReportService(suppId, user.getId(), supplier_company);

		    model.addAttribute("username",user.getUsername());
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello";
	}
}

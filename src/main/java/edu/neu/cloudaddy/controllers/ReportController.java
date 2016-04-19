package edu.neu.cloudaddy.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import edu.neu.cloudaddy.model.Inventory_Transaction;
import edu.neu.cloudaddy.model.Product;
import edu.neu.cloudaddy.model.Report;
import edu.neu.cloudaddy.model.Supplier;
import edu.neu.cloudaddy.model.User;
import edu.neu.cloudaddy.service.ProductService;
import edu.neu.cloudaddy.service.ReportService;
import edu.neu.cloudaddy.service.SupplierService;
import edu.neu.cloudaddy.service.UserService;

@Controller
public class ReportController {

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

	@RequestMapping(value = "/report")
	public String report(Model model, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			User user = userService.getUserIdService((String) session
					.getAttribute("username"));
			String days = request.getParameter("daysOld");
			String supplierId = request.getParameter("prod");
			String counter = request.getParameter("count");
			if (days == null || days == "")
				days = "1";
			if (supplierId == null || supplierId == "")
				supplierId = "1";
			if (counter == null || counter == "")
				counter = "1";
			// System.out.println("days : " + days + "supplierId :" + supplierId
			// + "counter :" + counter);
			int suppId = Integer.parseInt(supplierId);
			int daysOld = Integer.parseInt(days);
			int count = Integer.parseInt(counter);

			ArrayList<Supplier> suppliers = supplierService
					.getSuppliersService();
			ArrayList<Product> products = productService
					.getProductsService(suppId);
			String supplier_company = supplierService
					.getSupplierNameService(suppId);

			for (int i = 1; i <= count; i++) {
				// generate data reports
				ArrayList<Inventory_Transaction> it = new ArrayList<>();
				it = productService.getInventoryTransactionsService(products,
						daysOld);
				productService.writeProductsService(suppId, user.getId(),
						supplier_company, products, it, daysOld, i);
			}

			if (user.getId() != 0) {
				ArrayList<Report> reports = reportService.getReportService(user
						.getId());
				model.addAttribute("reports", reports);
			}
			model.addAttribute("username", user.getUsername());
			model.addAttribute("suppliers", suppliers);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}

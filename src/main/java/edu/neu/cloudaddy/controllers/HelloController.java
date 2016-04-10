package edu.neu.cloudaddy.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();
			// System.out.println("name : " + name);
			HttpSession session = request.getSession();
			session.setAttribute("username", name);
			User user = userService.getUserIdService(name);
			ArrayList<Supplier> suppliers = supplierService
					.getSuppliersService();
			if (user.getId() != 0) {
				ArrayList<Report> reports = reportService.getReportService(user
						.getId());
				model.addAttribute("reports", reports);
			}

			model.addAttribute("suppliers", suppliers);
			model.addAttribute("username", name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hello";
	}

	@RequestMapping(value = "/download")
	public String download(Model model, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("report") String repoId, HttpSession session)
			throws IOException {
		System.out.println("report id : " + repoId);
		String name = (String) session.getAttribute("username");
		User user = userService.getUserIdService(name);
		ArrayList<Supplier> suppliers = supplierService.getSuppliersService();
		if (user.getId() != 0) {
			ArrayList<Report> reports = reportService.getReportService(user
					.getId());
			model.addAttribute("reports", reports);
		}
		
		Report report =null;
		if(repoId !="" && repoId!=null)
			report = reportService.getFileContentService(repoId);

		model.addAttribute("suppliers", suppliers);
		model.addAttribute("username", name);
		
		if(report ==null || report.getAttached()==null)
			return "/hello";
		
		InputStream input = new FileInputStream("tmp//"
				+ report.getReportName());

		response.setContentType("application/txt");
		response.setContentLength(report.getAttached().length());
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ report.getReportName() + "\"");

		FileCopyUtils.copy(input, response.getOutputStream());
		return null;
	}

	@RequestMapping(value = "/delete")
	public String delete(Model model, HttpServletRequest request,
			@RequestParam("report") String repoId, HttpSession session) {
		System.out.println("report id : " + repoId);
		String name = (String) session.getAttribute("username");
		User user = userService.getUserIdService(name);
		ArrayList<Supplier> suppliers = supplierService.getSuppliersService();

		if(repoId !="" && repoId!=null)
			reportService.deleteFileService(repoId);
		
		if (user.getId() != 0) {
			ArrayList<Report> reports = reportService.getReportService(user
					.getId());
			model.addAttribute("reports", reports);
		}
	
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("username", name);
		return "hello";
	}

}

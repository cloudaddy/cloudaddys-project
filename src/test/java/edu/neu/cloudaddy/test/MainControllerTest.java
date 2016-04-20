//package edu.neu.cloudaddy.test;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//import javax.sql.DataSource;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import edu.neu.cloudaddy.dao.SupplierDao;
//import edu.neu.cloudaddy.dao.SupplierDaoImp;
//import edu.neu.cloudaddy.service.SupplierService;
//import edu.neu.cloudaddy.service.SupplierServiceImpl;
//
//
//public class MainControllerTest {
//
//	private MockMvc mockMvc;
//
//	@Autowired
//	DataSource dataSource;
//
//	private static SupplierService supplierService;
//	private static SupplierDao supplierDao;
//
//	@Before
//	public void setup() throws Exception {
//		this.mockMvc = standaloneSetup(new MainControllerTest()).alwaysExpect(
//				status().isOk()).build();
//	}
//
//	@BeforeClass
//	public static void init() {
//		supplierDao = new SupplierDaoImp();
//		supplierService = new SupplierServiceImpl();
//	}
//
//	@Test
//	public void testSupplier() throws Exception {
//		System.out.println(supplierService);
//		String result = supplierDao.getSupplierName(dataSource, 1);
//
//		System.err.println(result);
//
//	}
//
//}

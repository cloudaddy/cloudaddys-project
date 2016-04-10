package edu.neu.cloudaddy.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cloudaddy.dao.ProductDao;
import edu.neu.cloudaddy.model.Inventory_Transaction;
import edu.neu.cloudaddy.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	ArrayList<Product> products; 

	@Autowired 
	DataSource dataSource;
	
	@Autowired
	private ProductDao productDao;
	
	public ArrayList<Product> getProductsService(int id){
		products = productDao.getProducts(dataSource, id);
		return products;		
	}

	@Override
	public void writeProductsService(int supplierId,int userId, String company, 
			ArrayList<Product> products, ArrayList<Inventory_Transaction> it, int daysOld, int count) {
		if(products.size()>0){
			String reportName = "Report_" + daysOld + "_" + count + "_" +
					(new SimpleDateFormat("MM-dd-yy:HH:mm:ss")).format(new Date())+
					 ".txt";
			productDao.saveReport(dataSource, supplierId, userId, company,reportName, products, it);
		}
	}

	@Override
	public ArrayList<Inventory_Transaction> getInventoryTransactionsService(
			ArrayList<Product> products, int daysOld) {
		
		return productDao.getInventoryTransactions(dataSource, products, daysOld);
	}

}

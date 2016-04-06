package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cloudaddy.dao.ProductDao;
import edu.neu.cloudaddy.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired 
	DataSource dataSource;
	
	@Autowired
	private ProductDao productDao;
	
	public ArrayList<Product> getProductsService(int id){
		return productDao.getProducts(dataSource, id);
		
	}
}

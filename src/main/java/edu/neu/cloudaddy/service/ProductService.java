package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import edu.neu.cloudaddy.model.Product;

public interface ProductService {

	ArrayList<Product> getProductsService(int id);
	void writeProductsService(int supplierId,int userId, String company, ArrayList<Product> products);
	//void saveReportService(int supp_id,int user_id, String company );
	
}

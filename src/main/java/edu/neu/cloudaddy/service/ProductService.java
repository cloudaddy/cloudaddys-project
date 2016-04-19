package edu.neu.cloudaddy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.neu.cloudaddy.model.Inventory_Transaction;
import edu.neu.cloudaddy.model.Product;

public interface ProductService {

	ArrayList<Product> getProductsService(int id);
	void writeProductsService(int supplierId,int userId, String company, 
			ArrayList<Product> products, ArrayList<Inventory_Transaction> it, int daysOld, int count) throws SQLException;
	ArrayList<Inventory_Transaction> getInventoryTransactionsService(ArrayList<Product> products, 
			int daysOld) throws SQLException;
	
}

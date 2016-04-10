package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Inventory_Transaction;
import edu.neu.cloudaddy.model.Product;

public interface ProductDao {

	ArrayList<Product> getProducts(DataSource dataSource, int id);
	void saveReport(DataSource dataSource,int supplierId, int userId, String company, 
			String rName,ArrayList<Product> products, ArrayList<Inventory_Transaction> it);
	ArrayList<Inventory_Transaction> getInventoryTransactions(DataSource dataSource, 
			ArrayList<Product> products, int daysOld);
}

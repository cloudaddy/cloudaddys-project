package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Product;

public interface ProductDao {

	ArrayList<Product> getProducts(DataSource dataSource, int id);
	void writeProducts(DataSource dataSource,int supplierId);
	void saveReport(DataSource dataSource,int supplierId, int userId, String company);
}

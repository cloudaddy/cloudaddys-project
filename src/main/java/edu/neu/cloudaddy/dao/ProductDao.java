package edu.neu.cloudaddy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Inventory_Transaction;
import edu.neu.cloudaddy.model.Product;

public interface ProductDao {

	ArrayList<Product> getProducts(DataSource dataSource, int id)
			throws SQLException;

	void saveReport(DataSource dataSource, int supplierId, int userId,
			String rName, ArrayList<Product> products,
			ArrayList<Inventory_Transaction> it) throws SQLException;

	ArrayList<Inventory_Transaction> getInventoryTransactions(
			DataSource dataSource, ArrayList<Product> products, int daysOld)
			throws SQLException;
}

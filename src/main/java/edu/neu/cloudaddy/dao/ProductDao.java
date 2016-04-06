package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Product;

public interface ProductDao {

	ArrayList<Product> getProducts(DataSource dataSource, int id);
}

package edu.neu.cloudaddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.neu.cloudaddy.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	ResultSet rs;
	Connection connection;
	
	public ArrayList<Product> getProducts(DataSource dataSource,int supplierId) {
		ArrayList<Product> productList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select * from products p, suppliers s where " +
							"p.supplier_ids = ? ;");
			query.setInt(1,supplierId);
			rs = query.executeQuery();
			
			while (rs.next()) {
				String product_code = rs.getString("product_code");
				String product_name = rs.getString("product_name");
				Product product = new Product();
				product.setProduct_code(product_code);
				product.setProduct_name(product_name);
				productList.add(product);
			}
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return productList;
	}
}

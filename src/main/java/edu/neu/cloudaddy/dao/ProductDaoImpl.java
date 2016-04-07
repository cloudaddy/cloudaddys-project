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
					.prepareStatement("select p.id, p.product_code, p.product_name, " +
							"p.category, p.list_price, p.standard_cost" + 
							" from products p where " +
							"p.supplier_ids = ? LIMIT 20;");
			query.setInt(1,supplierId);
			rs = query.executeQuery();
			
			while (rs.next()) {
				String product_id = rs.getString("id");
				String product_code = rs.getString("product_code");
				String product_name = rs.getString("product_name");
				String product_category = rs.getString("category");
				String product_List_price = rs.getString("list_price");
				String product_std_cost = rs.getString("standard_cost");
				
				Product product = new Product();
				product.setId(Integer.parseInt(product_id));
				product.setProduct_code(product_code);
				product.setProduct_name(product_name);
				product.setCategory(product_category);
				product.setList_price(Double.parseDouble(product_List_price));
				product.setStandard_cost(Double.parseDouble(product_std_cost));
				
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

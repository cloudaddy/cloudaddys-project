package edu.neu.cloudaddy.dao;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

import edu.neu.cloudaddy.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	ResultSet rs;
	Connection connection;

	public ArrayList<Product> getProducts(DataSource dataSource, int supplierId) {
		ArrayList<Product> productList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select p.id, p.product_code, p.product_name, "
							+ "p.category, p.list_price, p.standard_cost"
							+ " from products p where "
							+ "p.supplier_ids = ? LIMIT 20;");
			query.setInt(1, supplierId);
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

	public void saveReport(DataSource dataSource, int supplierId, int userId,
			String company,String reportName, ArrayList<Product> products) {
		try {
			System.out.println("inside save");
			//FileInputStream fis = null;
			connection = dataSource.getConnection();
			//connection.setAutoCommit(false);
			//File file = new File("tmp//" + reportName);
			//fis = new FileInputStream(file);
			PreparedStatement query = connection
					.prepareStatement("insert into reports (userId, name, "
							+ " attachment, deleted, created_on, modified_on, supplier_company)"
							+ " values (?,?,?,?,?,?,?);");
			query.setInt(1, userId);
			query.setString(2, reportName);
			//query.setAsciiStream(3, fis, (int) file.length());
			StringBuffer s = new StringBuffer();
			for(Product p : products){
				s.append(p.getProduct_code() + "," + p.getProduct_name() + ","+
			p.getList_price()+","+p.getStandard_cost()+","+p.getCategory()+"\n");
			}
			StringReader reader = new StringReader(s.toString());
			query.setCharacterStream(3, reader , s.toString().length());
			query.setString(4, "N");
			query.setString(5, (new SimpleDateFormat("MM-dd-yy")).format(new Date()));
			query.setString(6, (new SimpleDateFormat("MM-dd-yy")).format(new Date()));
			query.setString(7, company);
			query.executeUpdate();
			System.out.println("query:" + query);
			connection.commit();
			//fis.close();
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} 
	}

}

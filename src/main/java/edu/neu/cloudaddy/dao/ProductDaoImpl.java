package edu.neu.cloudaddy.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

import edu.neu.cloudaddy.model.Inventory_Transaction;
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
			String company, String reportName, ArrayList<Product> products,
			ArrayList<Inventory_Transaction> it) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			System.out.println("inside save");
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			PreparedStatement query = connection
					.prepareStatement("insert into reports (userId, name, "
							+ " attachment, deleted, created_on, modified_on, supplier_company)"
							+ " values (?,?,?,?,?,?,?);");
			query.setInt(1, userId);
			query.setString(2, reportName);
			
			StringBuffer s = new StringBuffer();
			s.append("--------------------Products List----------------");
			s.append("\n");
			s.append("PRODUCT_CODE | PRODUCT_NAME | PRODUCT_LIST_PRICE | "
					+ "PRODUCT _STD_PRICE | PRODUCT_CATEGORY");
			s.append("\n");
			for (Product p : products) {
				s.append(p.getProduct_code() + "," + p.getProduct_name() + ","
						+ p.getList_price() + "," + p.getStandard_cost() + ","
						+ p.getCategory() + "\n");
			}
			s.append("\n\n");
			s.append("------------------APPENDING PRODUCT TRANSACTION DATA--------------------");
			if (it.size() > 0) {
				if (it != null && it.get(0) != null) {
					s.append("---------------Inventory List Per product------------");
					s.append("TANSACTION_ID | transaction_type | transaction_created_date |"
							+ "transaction_modified_date | product_id | quantity | purchase_order_id |"
							+ "customer_order_id | comments");
					for (Inventory_Transaction i : it) {

						s.append(i.getId() + "," + i.getTransaction_type()
								+ "," + i.getTransaction_created_date() + ","
								+ i.getTransaction_modified_date() + ","
								+ i.getProduct_id() + "," + i.getQuantity()
								+ "," + i.getPurchase_order_id() + ","
								+ i.getCustomer_order_id() + ","
								+ i.getComments() + "\n");
					}
				}
			}
			
			// creating new report generation code
						File file = new File(reportName);
						fos = new FileOutputStream(file);
						byte[] contentInBytes = s.toString().getBytes();
						fos.write(contentInBytes);
						fos.flush();
						fos.close();
						fis = new FileInputStream(file);
						query.setAsciiStream(3, fis, (int) file.length());
						// -----------
			//StringReader reader = new StringReader(s.toString());
			//query.setCharacterStream(3, reader, s.toString().length());
			query.setString(4, "N");
			query.setString(5,
					(new SimpleDateFormat("MM-dd-yy")).format(new Date()));
			query.setString(6,
					(new SimpleDateFormat("MM-dd-yy")).format(new Date()));
			query.setString(7, company);
			query.executeUpdate();
			System.out.println("query:" + query);
			connection.commit();
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Inventory_Transaction> getInventoryTransactions(
			DataSource dataSource, ArrayList<Product> products, int daysOld) {
		ArrayList<Inventory_Transaction> it_List = new ArrayList<>();

		Date newDate = getDate(daysOld);
		System.out.println("newDate : " + newDate + "sqlDate : "
				+ new java.sql.Date(newDate.getTime()));
		try {
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("Select it.id, it.transaction_type,"
							+ "it.transaction_created_date, it.transaction_modified_date,"
							+ "it.product_id, it.quantity, it.purchase_order_id, "
							+ "it.customer_order_id, it.comments"
							+ " from inventory_transactions it inner join inventory_transaction_types itt "
							+ "on it.transaction_type=itt.id inner join products p on it.product_id = p.id "
							+ "where it.product_id=? and DATE_FORMAT(it.transaction_created_date,'%Y-%m-%d') >=?;");
			for (Product p : products) {
				query.setInt(1, p.getId());
				query.setDate(2, new java.sql.Date(newDate.getTime()));
			}
			System.out.println(query);

			rs = query.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String transaction_type = rs.getString("transaction_type");
				String transaction_created_date = rs
						.getString("transaction_created_date");
				String transaction_modified_date = rs
						.getString("transaction_modified_date");
				String product_id = rs.getString("product_id");
				String quantity = rs.getString("quantity");
				String purchase_order_id = rs.getString("purchase_order_id");
				String customer_order_id = rs.getString("customer_order_id");
				String comments = rs.getString("comments");

				Inventory_Transaction it = new Inventory_Transaction();
				it.setComments(comments);
				it.setCustomer_order_id(Integer.parseInt(customer_order_id));
				it.setId(Integer.parseInt(id));
				it.setProduct_id(Integer.parseInt(product_id));
				it.setPurchase_order_id(Integer.parseInt(purchase_order_id));
				it.setQuantity(Integer.parseInt(quantity));
				it.setTransaction_created_date(transaction_created_date);
				it.setTransaction_modified_date(transaction_modified_date);
				it.setTransaction_type(transaction_type);

				if (it != null && it.getId() > 0) {
					it_List.add(it);
				}
			}
			for (Inventory_Transaction i : it_List)
				System.out.println(i.getId() + " : " + i.getProduct_id()
						+ " : " + i.getTransaction_created_date());
			connection.close();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return it_List;

	}

	private Date getDate(int daysOld) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -daysOld);
		String mMonth = (cal.get(Calendar.MONTH) + 1) + "";
		String dDay = cal.get(Calendar.DATE) + "";
		String yYear = cal.get(Calendar.YEAR) + "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null;
		try {
			now = sdf.parse(yYear + "-" + mMonth + "-" + dDay);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		// String newDate = sdf.format(now);

		return now;
	}

}

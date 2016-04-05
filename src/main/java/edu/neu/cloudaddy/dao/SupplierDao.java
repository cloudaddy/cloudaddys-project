package edu.neu.cloudaddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public class SupplierDao {

	ResultSet rs;

	public ArrayList<Supplier> getSuppliers(DataSource dataSource) {
		ArrayList<Supplier> supplierList = new ArrayList<>();
		try {
			// Class.forName(driver).newInstance();
			Connection connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select * from supplier;");
			rs = query.executeQuery();
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		try {
			while (rs.next()) {
				String company = rs.getString("company");
				Supplier supplier = new Supplier();
				supplier.setCompany(company);
				supplierList.add(supplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplierList;

	}
}

package edu.neu.cloudaddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

import edu.neu.cloudaddy.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImp implements SupplierDao{

	ResultSet rs;
	Connection connection;

	public ArrayList<Supplier> getSuppliers(DataSource dataSource){
		ArrayList<Supplier> supplierList = new ArrayList<>();
		try {
			// Class.forName(driver).newInstance();
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select * from suppliers;");
			rs = query.executeQuery();

			while (rs.next()) {
				String company = rs.getString("company");
				String Id = rs.getString("Id");
				Supplier supplier = new Supplier();
				supplier.setCompany(company);
				supplier.setId(Integer.parseInt(Id));
				supplierList.add(supplier);
			}
			for(Supplier s: supplierList){
				System.out.println("supplier : " + s.getCompany() + " : " +  s.getId());
			}
			connection.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return supplierList;
	}
}

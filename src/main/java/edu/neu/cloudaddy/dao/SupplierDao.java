package edu.neu.cloudaddy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public interface SupplierDao {

	ArrayList<Supplier> getSuppliers(DataSource dataSource) throws SQLException;
	String getSupplierName(DataSource dataSource, int supplierId);
}

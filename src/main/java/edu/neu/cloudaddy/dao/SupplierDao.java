package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public interface SupplierDao {

	ArrayList<Supplier> getSuppliers(DataSource dataSource);
	String getSupplierName(DataSource dataSource, int supplierId);
}

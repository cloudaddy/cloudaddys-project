package edu.neu.cloudaddy.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> getSuppliersService() throws SQLException;
	String getSupplierNameService(int suppID);
}

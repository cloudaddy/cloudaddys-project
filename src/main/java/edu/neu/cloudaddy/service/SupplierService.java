package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> getSuppliersService();
	String getSupplierNameService(int suppID);
}

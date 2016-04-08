package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.neu.cloudaddy.dao.SupplierDao;
import edu.neu.cloudaddy.model.Supplier;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired 
	DataSource dataSource;
	
	@Override
	public ArrayList<Supplier> getSuppliersService() {
		
		return supplierDao.getSuppliers(dataSource);
	}

	@Override
	public String getSupplierNameService(int supplierId) {
		return supplierDao.getSupplierName(dataSource, supplierId);
	}
	
}

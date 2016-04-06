package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}

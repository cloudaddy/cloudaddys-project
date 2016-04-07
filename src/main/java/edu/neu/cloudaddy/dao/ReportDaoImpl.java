package edu.neu.cloudaddy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.neu.cloudaddy.model.Report;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao{

	ResultSet rs;
	Connection connection;
	
	@Override
	public ArrayList<Report> getReports(DataSource dataSource, int userId) {
		ArrayList<Report> reports = new ArrayList<>();
		try{
			connection = dataSource.getConnection();
			PreparedStatement query = connection
					.prepareStatement("select * from reports where userId =? " +
							"and deleted = 'N';");
			query.setInt(1,userId);
			//System.out.println("query : " + query);
			rs = query.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String Id = rs.getString("Id");
				String attached = rs.getString("attachment");
				String deleted = rs.getString("deleted");
				String created_on = rs.getString("created_on");
				String modified_on = rs.getString("modified_on");
				String supplierName = rs.getString("supplier_company");
				Report report = new Report();
				report.setReportName(name);
				report.setId(Integer.parseInt(Id));
				report.setCreated_on(created_on);
				report.setModified_on(modified_on);
				report.setDeleted(deleted);
				report.setAttached(attached);
				report.setSupplierName(supplierName);
				
				reports.add(report);
			}
			for(Report r: reports){
				System.out.println("report : " + r.getId()+ " : " +  r.getReportName());
			}
			connection.close();
		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return reports;
	}

}

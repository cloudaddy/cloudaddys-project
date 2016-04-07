package edu.neu.cloudaddy.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cloudaddy.dao.ReportDao;
import edu.neu.cloudaddy.model.Report;

@Service("reportService")
public class ReportServiceImpl implements ReportService{

	@Autowired 
	DataSource dataSource;
	
	@Autowired 
	ReportDao reportDao;
	
	@Override
	public ArrayList<Report> getReportService(int userID) {
		
		return reportDao.getReports(dataSource, userID);
	}

}

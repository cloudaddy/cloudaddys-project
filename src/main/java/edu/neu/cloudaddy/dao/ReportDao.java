package edu.neu.cloudaddy.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.neu.cloudaddy.model.Report;

public interface ReportDao {

	ArrayList<Report> getReports(DataSource dataSource, int userId);
	Report getFileContent(DataSource dataSource, String repoName);
	void deleteFile(DataSource dataSource, String repoId);
}
